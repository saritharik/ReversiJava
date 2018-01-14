package reversiapp;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import game.Board;
import game.GameLogic;
import game.GuiBoard;
import game.GuiGame;
import game.HumanPlayer;
import game.Point;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
public class ReversiGameController extends HBox implements Initializable{
	@FXML
	private HBox root;
	private Board board = new GuiBoard(4);
	
	private HumanPlayer player1 = new HumanPlayer('X');
	private HumanPlayer player2 = new HumanPlayer('O');
	private GameLogic gameLogic = new GameLogic(board);
	private GuiGame game = new GuiGame(player1, player2, board, gameLogic);

	 
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 BoardReversiController reversiBoard = new BoardReversiController(board, game);
		 
		 /*root.widthProperty().addListener((observable, oldValue, newValue) -> {
			 double boardNewWidth = newValue.doubleValue() - 120;
			 revrsiBoard.setPrefWidth(boardNewWidth);
			 revrsiBoard.draw();
			 });

			 root.heightProperty().addListener((observable, oldValue, newValue) -> {
				 revrsiBoard.setPrefHeight(newValue.doubleValue());
				 revrsiBoard.draw();
			 });*/

		 reversiBoard.setPrefWidth(400);
		 reversiBoard.setPrefHeight(400);
		 root.getChildren().add(0, reversiBoard);
		 reversiBoard.draw();
		 reversiBoard.drawOptions(game.options());
		 
		
	 }
}
