package reversiapp;

import java.net.URL;
import java.util.ResourceBundle;

import game.Board;
import game.GuiBoard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

public class ReversiGameController implements Initializable {
	@FXML
	 private HBox root;
	 private Board board = new GuiBoard(8);
	 
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 BoardReversiController revrsiBoard = new BoardReversiController(board);
		 revrsiBoard.setPrefWidth(400);
		 revrsiBoard.setPrefHeight(400);
		 root.getChildren().add(0, revrsiBoard);
		 revrsiBoard.draw();
	 }
	
}
