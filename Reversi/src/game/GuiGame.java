package game;

import java.util.ArrayList;

public class GuiGame {
	private HumanPlayer player1;
	private HumanPlayer player2;
	private Board board;
	private GameLogic gameLogic;
	private static final int START_POINT = 2;
	private HumanPlayer currentPlayer;
	private boolean firstPlayer;
	
	public GuiGame(HumanPlayer p1, HumanPlayer p2, Board b, GameLogic game) {
		this.player1 = p1;
		this.player2 = p2;
		player1.setPoint(START_POINT);
		player2.setPoint(START_POINT);
		this.board = b;
		this.gameLogic = game;
		this.currentPlayer = player1;
		this.firstPlayer = true;
	}
	
	public ArrayList<Point> options() {
		return this.gameLogic.findPoints(this.currentPlayer.getDisk());
	}

	public boolean playOneTurn(Point corrdinate) {
		boolean legalMove = this.gameLogic.possibleMoves(new Point(corrdinate.getY(), corrdinate.getX()),
				this.currentPlayer.getDisk());
		if (legalMove) {
			this.gameLogic.oneMove(corrdinate.getY(), corrdinate.getX(), this.currentPlayer.getDisk());
			if (firstPlayer) {
				this.currentPlayer = this.player2;
				firstPlayer = false;
			} else {
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
				return false;
			}
		}
		
		
		return true;
	}
}
