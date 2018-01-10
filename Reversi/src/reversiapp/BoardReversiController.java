package reversiapp;

import java.io.IOException;
import game.Board;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardReversiController extends GridPane {
	 private Board board;

	 public BoardReversiController(Board board) {
		 this.board = board;
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BoardReversi.fxml"));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 fxmlLoader.load();
		 } catch (IOException exception) {
			 throw new RuntimeException(exception);
		 }

	 }
	 
	 
	 public void draw() {
		 this.getChildren().clear();

		 int height = (int)this.getPrefHeight();
		 int width = (int)this.getPrefWidth();

		 int size = board.getDimensions();
		 int cellHeight = height / size;
		 int cellWidth = width / size;

		 for (int i = 0; i < size; i++) {
			 for (int j = 0; j < size; j++) {
				this.add(new Rectangle(cellWidth, cellHeight, Color.BEIGE), j, i);
		 	}
		 }
	}

}
