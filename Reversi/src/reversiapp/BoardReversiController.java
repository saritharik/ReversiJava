package reversiapp;

import java.io.IOException;
import game.Board;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardReversiController extends GridPane {
	 //private Board board;
	private Player player;

	private int[][] board;
	//private static final int FREE = 0;
	//private static final int WALL = 1;

	 public BoardReversiController(int[][] board) {
		 player = new Player(this, 0, 0);

		 this.board = board;
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BoardReversi.fxml"));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 fxmlLoader.load();
		 } catch (IOException exception) {
			 throw new RuntimeException(exception);
		 }
		 /*try {
			 fxmlLoader.load();
			 this.setOnKeyPressed(event -> {
			 switch (event.getCode()) {
			 	case DOWN:
			 		player.moveDown();
			 		break;
			 	case UP:
			 		player.moveUp();
			 		break;
			 	case LEFT:
			 		player.moveLeft();
			 		break;
			 	case RIGHT:
			 		player.moveRight();
			 		break;
			 }
			 event.consume();
		 }); 
		} catch (Exception e) {
		 
		} */
}
	 
	 
	 public void draw() {
		 this.getChildren().clear();

		 int height = (int)this.getPrefHeight();
		 int width = (int)this.getPrefWidth();

		 //int size = board.getDimensions();
		 int cellHeight = height / board.length;
		 int cellWidth = width / board[0].length;

		 for (int i = 0; i < board.length; i++) {
			 for (int j = 0; j < board[i].length; j++) {
				 //this.add(new Rectangle(cellWidth, cellHeight, Color.BEIGE), j, i);
					 Rectangle r = new Rectangle(cellWidth, cellHeight,Color.BEIGE);
					 r.setStroke(Color.BLACK);
					 this.add(r, j, i);

		 	}
		 }
		 player.draw(cellWidth, cellHeight); 
	}

}
