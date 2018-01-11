package reversiapp;

import java.net.URL;
import java.util.ResourceBundle;

import game.Board;
import game.GuiBoard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class ReversiGameController implements Initializable {
	@FXML
	 private HBox root;
	 //private Board board = new GuiBoard(8);
	private int[][] board = {
			{0, 1, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 1, 0, 0, 0, 1}
	};
	 
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 BoardReversiController revrsiBoard = new BoardReversiController(board);
		 /*root.widthProperty().addListener((observable, oldValue, newValue) -> {
			 double boardNewWidth = newValue.doubleValue() - 120;
			 revrsiBoard.setPrefWidth(boardNewWidth);
			 revrsiBoard.draw();
			 });

			 root.heightProperty().addListener((observable, oldValue, newValue) -> {
				 revrsiBoard.setPrefHeight(newValue.doubleValue());
				 revrsiBoard.draw();
			 });*/

		 revrsiBoard.setPrefWidth(400);
		 revrsiBoard.setPrefHeight(400);
		 root.getChildren().add(0, revrsiBoard);
		 //root.setOnKeyPressed(revrsiBoard.getOnKeyPressed());
		 revrsiBoard.draw();
	 }
	
}
