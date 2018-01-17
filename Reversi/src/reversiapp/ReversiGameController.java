package reversiapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import game.Board;
import game.GameLogic;
import game.GuiBoard;
import game.HumanPlayer;
import game.Point;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
public class ReversiGameController extends HBox implements Initializable{
	@FXML
	private HBox root;
	private Board board;
	@FXML
	private Label firstPlayerPoints;
	@FXML
	private Label secondPlayerPoints;
	@FXML
	private Label currPlayer;
	private static final int START_POINT = 2;
	private static final int DEFAULT_SIZE_BOARD = 8;
	private HumanPlayer player1;
	private HumanPlayer player2;
	private GameLogic gameLogic;
	private HumanPlayer currentPlayer;
	private boolean firstPlayer = true;
	private Main main;
	
	 /**
	  * init the game
	  */
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 //open file of settings
		 String firstColor = "Black";
		 String secondColor = "White";
		 File file = new File("settings.txt");
		 FileReader fReader = null;
		 try {
			fReader = new FileReader("settings.txt");
			BufferedReader r = new BufferedReader(fReader);
			 Settings settings = new Settings(r);
			 settings.readFromFile();
			 this.board = new GuiBoard(settings.getSizeBoard());
			 this.gameLogic = new GameLogic(board);
			 this.player1 = new HumanPlayer(settings.getFirstPlayer());
			 char p2Disk;
			 if (settings.getFirstPlayer() == 'X') {
				 p2Disk = 'O';
			 } else {
				 p2Disk = 'X';
			 }
			 this.player2 = new HumanPlayer(p2Disk);
			 firstColor = settings.getFirstPlayerColor();
			 secondColor = settings.getSecondPlayerColor();
		} catch (FileNotFoundException e) {
			 this.board = new GuiBoard(DEFAULT_SIZE_BOARD);
			 this.gameLogic = new GameLogic(board);
			 this.player1 = new HumanPlayer('X');
			 this.player2 = new HumanPlayer('O');
		}
		 
		 this.currentPlayer = player1;
		 
		 player1.setPoint(START_POINT);
		 player2.setPoint(START_POINT);
		 this.firstPlayerPoints.setText("First Player Points: " + player1.getPoint());
		 this.secondPlayerPoints.setText("Second Player Points: " + player2.getPoint());
		 this.currPlayer.setText("Current Player: " + this.currentPlayer.getDisk());
		 
		 //init the board controller
		 BoardReversiController reversiBoard = new BoardReversiController(board, this,
				 firstColor, secondColor);

		 reversiBoard.setPrefWidth(400);
		 reversiBoard.setPrefHeight(400);
		 root.getChildren().add(0, reversiBoard);
		 reversiBoard.draw();
		 reversiBoard.drawOptions(this.options());
	}
	 
	 /**
	  * find the legal options of the current player
	  * @return a list of the options
	  */
	 public ArrayList<Point> options() {
		 ArrayList<Point> arr = this.gameLogic.findPoints(this.currentPlayer.getDisk());
		 return arr;
	}
	 
	 /**
	  * Do one move of the game, according to the chosen square of the player
	  * @param corrdinate the point of the square
	  * @return false- if the game is over. true- otherwise
	  */
	 public boolean playOneTurn(Point corrdinate) {
		 ArrayList<Point> n1 = this.gameLogic.checking(
				 corrdinate.getY(), corrdinate.getX(), currentPlayer.getDisk());
		 int points = n1.size();
		 // check if it legal move
		 boolean legalMove = this.gameLogic.possibleMoves(new Point(corrdinate.getY(), corrdinate.getX()),
				 this.currentPlayer.getDisk());
		 if (legalMove) {
			 this.gameLogic.oneMove(corrdinate.getY(), corrdinate.getX(), this.currentPlayer.getDisk());
			 // change the player
			 if (firstPlayer) {
				 player1.setPoint(1 + points);
			     player2.setPoint(-points);
				 this.currentPlayer = this.player2;
				 firstPlayer = false;
			 } else {
				 player2.setPoint(1 + points);
			     player1.setPoint(-points);
				 this.currentPlayer = this.player1;
				 firstPlayer = true;
			 }
			 if (this.options().isEmpty()) {
				 if (firstPlayer) {
					 this.currentPlayer = this.player2;
					 firstPlayer = false;
				 } else {
					 this.currentPlayer = this.player1;
					 firstPlayer = true;
				 }
			 }
			 // check if the game is over
			 if (this.gameLogic.findPoints(player1.getDisk()).isEmpty() && 
					 this.gameLogic.findPoints(player2.getDisk()).isEmpty()) {
					drawPoints();

				 return false;
			 }
		}
		drawPoints();
		return true;
	}
	 
	 /**
	  * draw the points of the players on the screen
	  */
	 public void drawPoints() {
		 this.firstPlayerPoints.setText("First Player Points: " + player1.getPoint());
		 this.secondPlayerPoints.setText("Second Player Points: " + player2.getPoint());
		 this.currPlayer.setText("Current Player: " + this.currentPlayer.getDisk()); 
	 }
	 
	 /**
	  * check who is the winner and return it
	  * @return the winner player
	  */
	 public char getTheWinner() {
		 if (this.player1.getPoint() > this.player2.getPoint()) {
			 return player1.getDisk();
		 } else if (this.player2.getPoint() > this.player1.getPoint()) {
			 return player2.getDisk();
		 } else {
			 return ' ';
		 }
	 }
	 
	 public void goHome() {
		 main.showHome();
	 }
}