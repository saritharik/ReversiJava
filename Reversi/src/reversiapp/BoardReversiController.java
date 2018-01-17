package reversiapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import game.Board;
import game.Point;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class BoardReversiController extends GridPane {
	private Board board;
	private int height;
	private int width;
	private int size;
	private int cellHeight;
	private int cellWidth;
	private String firstPlayerColor;
	private String secondPlayerColor;
	Map<String, String> map;
	ImageView[][] firstPlayerImages;
	ImageView[][] secondPlayerImages;
	ImageView[][] squares;

	/**
	 * Constructor. Initialize the board and the images of the players.
	 * @param board - a gui board
	 * @param game - games controller
	 * @param firstColor - the color of the first player
	 * @param secondColor - the color of the second player
	 */
	public BoardReversiController(Board board, ReversiGameController game,
									String firstColor, String secondColor) {
		//init the map of the colors <-> images
		this.map = new HashMap<String, String>(); 
	    map.put("Green", "images/green.png");
	    map.put("Red", "images/red.png");
	    map.put("Yellow", "images/yellow.png");
	    map.put("Blue", "images/blue.png");
	    map.put("Black", "images/black.png");
	    map.put("Gray", "images/gray.png");
	    map.put("Light Blue", "images/light-blue.png");
	    map.put("Orange", "images/orange.png");
	    map.put("Purple", "images/purple.png");
	    map.put("White", "images/white.png");
	    this.firstPlayerColor = map.get(firstColor);
	    this.secondPlayerColor = map.get(secondColor);

		this.board = board;
		
		//load the fxml file
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BoardReversi.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);

		try {
			fxmlLoader.load();
			//the event of mouse clicked- the player choose square
			this.setOnMouseClicked(event -> {
				int x = (int) event.getSceneX() / this.cellWidth;
				int y = (int) event.getSceneY() / this.cellHeight;
				
				boolean gameIn = game.playOneTurn(new Point(x, y));
				if (gameIn) {
					this.draw();
					this.drawOptions(game.options());
				} else {
					//the game is over. show a message of the winner
					this.draw();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("End Of Game");
					if (game.getTheWinner() == 'X') {
						alert.setHeaderText("The Winner Is:");
						alert.setContentText("Player " + game.getTheWinner() + "!!!!");
					} else if (game.getTheWinner() == 'O') {
						alert.setHeaderText("The Winner Is:");
						alert.setContentText("Player " + game.getTheWinner() + "!!!!");
					} else {
						alert.setHeaderText(" ");
						alert.setContentText("The game ended in a draw!");
					}

					alert.showAndWait();
				}
				event.consume();
		 });
		} catch (Exception e) {
		}
		
		//init the size of the board
		this.setPrefWidth(400);
		this.setPrefHeight(400);
		this.height = (int)this.getPrefHeight();
		this.width = (int)this.getPrefWidth();
		this.size = board.getDimensions();
		this.cellHeight = height / size;
		this.cellWidth = width / size;

		//init the images of the first player
		this.firstPlayerImages = new ImageView[size][size];
	    for (int i = 0; i < size; i++) {
	    	for (int j = 0; j < size; j++) {
	    	this.firstPlayerImages[i][j] = new ImageView(getClass().
	    			getResource(this.firstPlayerColor).toExternalForm());
	    	}
	    }
		//init the images of the second player
	    this.secondPlayerImages = new ImageView[size][size];
	    for (int i = 0; i < size; i++) {
	    	for (int j = 0; j < size; j++) {
	    	this.secondPlayerImages[i][j] = new ImageView(getClass().
	    			getResource(this.secondPlayerColor).toExternalForm());
	    	}
	    }
	    
		//init the images of the squares
	    this.squares = new ImageView[size][size];
	    for (int i = 0; i < size; i++) {
	    	for (int j = 0; j < size; j++) {
	    	this.squares[i][j] = new ImageView(getClass().
	    			getResource("images/square.png").toExternalForm());
	    	}
	    }
	 }
	 
	/**
	 * draw the board
	 */
	 public void draw() {
		this.height = (int)this.getPrefHeight();
		this.width = (int)this.getPrefWidth();
		this.size = board.getDimensions();
		this.cellHeight = height / size;
		this.cellWidth = width / size;
		this.getChildren().clear();
		 
		 for (int i = 0; i < size; i++) {
			 for (int j = 0; j < size; j++) {
				 ImageView square = this.squares[i][j];
				 square.setFitWidth(cellWidth);
				 square.setFitHeight(cellHeight);
				 this.add(square, j, i);
		 	}
		 }
		 drawDisks();
	}

	 /**
	  *  draw the players
	  */
	 private void drawDisks() {
		 for (int i = 0; i < size; i++) {
			 for(int j = 0; j < size; j++) {
				 if (board.getSquare(i, j) == 'X') {
					 ImageView firstColor  = this.firstPlayerImages[i][j];
					 firstColor.setFitWidth(cellWidth);
					 firstColor.setFitHeight(cellHeight);
					 this.add(firstColor, j, i);
				 } else if (board.getSquare(i, j) == 'O') {
					 ImageView secondColor = this.secondPlayerImages[i][j];
					 secondColor.setFitWidth(cellWidth);
					 secondColor.setFitHeight(cellHeight);
					 this.add(secondColor, j, i);
				 }
			 }
		 }
	 }
	 
	 
	 /**
	  * draw the options of the player to choose
	  * @param options - the list of the legal options
	  */
	 public void drawOptions(ArrayList<Point> options) {
		 for (int i = 0; i < options.size(); i++) {
			 ImageView chooseSquares = new ImageView(getClass().getResource("images/choose.png").toExternalForm());
			 chooseSquares.setFitWidth(cellWidth);
			 chooseSquares.setFitHeight(cellHeight);
			 this.add(chooseSquares, options.get(i).getY(), options.get(i).getX());
		 }
	 }
}