package reversiapp;

import java.io.IOException;
import java.util.ArrayList;

import game.Board;
import game.GameLogic;
import game.GuiGame;
import game.Point;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class BoardReversiController extends GridPane {
	private Board board;
	private Player player;
	private int height;
	private int width;
	private int size;
	private int cellHeight;
	private int cellWidth;

	//private int[][] board;
	//private static final int FREE = 0;
	//private static final int WALL = 1;

	public BoardReversiController(Board board, GuiGame game) {
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
		
		try {
			fxmlLoader.load();
			this.setOnMouseClicked(event -> {
				int x = (int) event.getSceneX() / this.cellWidth;
				int y = (int) event.getSceneY() / this.cellHeight;
				
				game.playOneTurn(new Point(x, y));
				this.draw();
				this.drawOptions(game.options());
				//this.drawDisks();

				event.consume();
		 });
		} catch (Exception e) {
		 
		}
}
	 
	 public void draw() {
		this.height = (int)this.getPrefHeight();
		this.width = (int)this.getPrefWidth();
		this.size = board.getDimensions();
		this.cellHeight = height / size;
		this.cellWidth = width / size;
		this.getChildren().clear();
		 
		 for (int i = 0; i < size; i++) {
			 for (int j = 0; j < size; j++) {
				 //this.add(new Rectangle(cellWidth, cellHeight, Color.BEIGE), j, i);
					 Rectangle rec = new Rectangle(this.cellWidth, this.cellHeight,Color.BEIGE);
					 rec.setStroke(Color.BLACK);
					 this.add(rec, j, i);

		 	}
		 }
		 drawDisks();
		 board.printBoard();
		 //player.draw(cellWidth, cellHeight); 
	}

	 private void drawDisks() {
		 for (int i = 0; i < size; i++) {
			 for(int j = 0; j < size; j++) {
				 if (board.getSquare(i, j) == 'X') {
					 this.add(new Circle(this.cellWidth / 2, this.cellHeight / 2,
							 this.cellHeight / 3, Color.BLACK), j, i);
				 } else if (board.getSquare(i, j) == 'O') {
					 Circle whiteCircle = new Circle(this.cellWidth / 2, this.cellHeight / 2,
							 this.cellHeight / 3, Color.WHITE);
					 whiteCircle.setStroke(Color.BLACK);
					 this.add(whiteCircle, j, i);
				 }
			 }
		 }
	 }
	 
	 public void drawOptions(ArrayList<Point> options) {
		 
		 for (int i = 0; i < options.size(); i++) {
			 this.add(new Circle(this.cellWidth / 2, this.cellHeight / 2,
					 this.cellHeight / 4, Color.GREENYELLOW), options.get(i).getY(), options.get(i).getX());
		 }
	 }
}
