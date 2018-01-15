package reversiapp;

import java.io.BufferedReader;
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
	private HumanPlayer player1;
	private HumanPlayer player2;
	private GameLogic gameLogic;
	private HumanPlayer currentPlayer;
	private boolean firstPlayer = true;
	
	 
	 @Override
	 public void initialize(URL location, ResourceBundle resources) {
		 BufferedReader r = new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().
                 getResourceAsStream("reversiapp/Settings.txt")));
		 Settings settings = new Settings(r);
		 settings.readFromFile();
		 this.board = new GuiBoard(settings.getSizeBoard());
		 gameLogic = new GameLogic(board);
		 player1 = new HumanPlayer(settings.getFirstPlayer());
		 char p2Disk;
		 if (settings.getFirstPlayer() == 'X') {
			 p2Disk = 'O';
		 } else {
			 p2Disk = 'X';
		 }
		 player2 = new HumanPlayer(p2Disk);
		 this.currentPlayer = player1;
		 
		 player1.setPoint(START_POINT);
		 player2.setPoint(START_POINT);
		 this.firstPlayerPoints.setText("First Player Points: " + player1.getPoint());
		 this.secondPlayerPoints.setText("Second Player Points: " + player2.getPoint());
		 this.currPlayer.setText("Current Player: " + this.currentPlayer.getDisk());
		 BoardReversiController reversiBoard = new BoardReversiController(board, this);
		 
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
		 reversiBoard.drawOptions(this.options());
	}
	 
	 public ArrayList<Point> options() {
		 ArrayList<Point> arr = this.gameLogic.findPoints(this.currentPlayer.getDisk());
		 return arr;
	}
	 
	 public boolean playOneTurn(Point corrdinate) {
		 ArrayList<Point> n1 = this.gameLogic.checking(
				 corrdinate.getY(), corrdinate.getX(), currentPlayer.getDisk());
		 int points = n1.size();
		 boolean legalMove = this.gameLogic.possibleMoves(new Point(corrdinate.getY(), corrdinate.getX()),
				 this.currentPlayer.getDisk());
		 if (legalMove) {
			 this.gameLogic.oneMove(corrdinate.getY(), corrdinate.getX(), this.currentPlayer.getDisk());
			 
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
			 if (this.gameLogic.findPoints(player1.getDisk()).isEmpty() && 
					 this.gameLogic.findPoints(player2.getDisk()).isEmpty()) {
					drawPoints();

				 return false;
			 }
		}
		drawPoints();
		return true;
	}
	 
	 public void drawPoints() {
		 this.firstPlayerPoints.setText("First Player Points: " + player1.getPoint());
		 this.secondPlayerPoints.setText("Second Player Points: " + player2.getPoint());
		 this.currPlayer.setText("Current Player: " + this.currentPlayer.getDisk()); 
	 }
	 
	 public char getTheWinner() {
		 if (this.player1.getPoint() > this.player2.getPoint()) {
			 return player1.getDisk();
		 } else if (this.player2.getPoint() > this.player1.getPoint()) {
			 return player2.getDisk();
		 } else {
			 return ' ';
		 }
	 }
}
