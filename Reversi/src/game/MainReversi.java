package game;



public class MainReversi {
	public static final int DEFAULT_SIZE = 8;

public static void main(String[] args) {
	
    //int const defaultSizeBoard = 4;
    Board bC = new BoardConsole(DEFAULT_SIZE, DEFAULT_SIZE);
    GameLogic gameLogic = new GameLogic(bC);
    HumanPlayer p1 = new HumanPlayer('X');
    //UserPrinterConsole printer;
    //printer.chooseRival();
    HumanPlayer p2 = new HumanPlayer('O');
    Game game = new Game(p1, p2, bC, gameLogic);
    game.playGame();
    }
}

