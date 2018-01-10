package game;

import java.util.ArrayList;

public class Game {
	private HumanPlayer p1;
	private HumanPlayer p2;
	private Board board;
	private GameLogic game;
	public static final int START_POINT = 2;
	
	public Game(HumanPlayer p1, HumanPlayer p2, Board b, GameLogic game) {
		this.p1 = p1;
		this.p2 = p2;
		this.board = b;
		this.game = game;
	}

	public void playGame() {
	    boolean player1 = true;
	    p1.setPoint(START_POINT);
	    p2.setPoint(START_POINT);
	    int sum = ((this.board.getDimensions() - 1) * (this.board.getDimensions() - 1));
	    HumanPlayer currentPlayer = p1;
	    Point point = new Point(-7, -7);
	    while (p1.getPoint() + p2.getPoint() < sum) {
	        //userInter->startMove();
	        this.board.printBoard();
	        if (player1) {
	            currentPlayer = p1;
	        } else {
	            currentPlayer = p2;
	        }
	        //Point point = new Point(-7, -7);
	        ArrayList<Point> vecPoints = new ArrayList<Point>();
	        
	        //userInter->currentPlayerMsg(currentPlayer->getDisk());
	        vecPoints = game.findPoints(currentPlayer.getDisk());
	        //userInter->optionsToMove(vecPoints);
	        if (vecPoints.isEmpty()) {
	        	ArrayList<Point> v1 = game.findPoints(this.p1.getDisk());
	        	ArrayList<Point> v2 = game.findPoints(this.p2.getDisk());

	            player1 = !player1;
	            if (v1.isEmpty() && v2.isEmpty()) {
	                break;
	            }
	            continue;
	        }
	        point = currentPlayer.chooseSquare(vecPoints);
	        while ((!game.possibleMoves(point, currentPlayer.getDisk()))
	               || (point.getY() == 0 && point.getX() == 0)) {
	                //userInter.uncorrectMoves(vecPoints);
	        	point = currentPlayer.chooseSquare(vecPoints);
	        	}
	        }

	    ArrayList<Point> n1 = game.checking(point.getX(), point.getY(), currentPlayer.getDisk());
	    ArrayList<Point> n2 = game.checking(point.getX(), point.getY(), currentPlayer.getDisk());
	    game.oneMove(point.getX(), point.getY(), currentPlayer.getDisk());
	    if (player1) {
	    	p1.setPoint(1 + n1.size());
	    	game.setPlayerPoints(p1.getDisk(), p1.getPoint());
	    	p2.setPoint(-n1.size());
	    	game.setPlayerPoints(p2.getDisk(), p2.getPoint());
	    } else {
	    	p2.setPoint(1 + n2.size());
	    	game.setPlayerPoints(p2.getDisk(), p2.getPoint());
	    	p1.setPoint(-n2.size());
	    	game.setPlayerPoints(p1.getDisk(), p1.getPoint());
	    }
	    System.out.println();
	    player1 = !player1;
	    
	    this.board.printBoard();
	    if (p1.getPoint() > p2.getPoint()) {
	    	//userInter.endOfGame(p1.getDisk());
	    	
	    } else if (p2.getPoint() > p1.getPoint()) {
	    	//userInter.endOfGame(p2.getDisk());
	    } else {
	    	//userInter.endOfGame(' ');
	    }
	}
}
