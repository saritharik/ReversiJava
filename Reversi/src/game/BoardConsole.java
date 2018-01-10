package game;


public class BoardConsole implements Board {
	public static final int DEFAULT_SIZE = 9;
	private int boardRow;
	private int boardCol;
	private char[][] board;
	
	public BoardConsole(int row, int col) {
		this.boardRow = row + 1;
		this.boardCol = col + 1;
		this.board = new char[this.boardRow][this.boardCol];
	    for (int i = 0; i < this.boardRow; i++) {
	        for (int j = 0; j < this.boardCol; j++) {
	            this.board[i][j] = ' ';
	        }
	    }
	    this.board[(this.boardRow - 1) / 2][(this.boardCol - 1) / 2] = 'O';
	    this.board[(this.boardRow + 1) / 2][(this.boardCol + 1) / 2] = 'O';
	    this.board[(this.boardRow - 1) / 2][(this.boardCol + 1) / 2] = 'X';
	    this.board[(this.boardRow + 1) / 2][(this.boardCol - 1) / 2] = 'X';
	}

	public BoardConsole() {
		this.boardRow = DEFAULT_SIZE;
		this.boardCol = DEFAULT_SIZE;
	}

	public char getSquare(int i, int j) {
	    return this.board[i][j];
	}

	public void setSquare(int i, int j, char sign) {
	    this.board[i][j] = sign;
	}

	public int getDimensions() {
	    return this.boardRow;
	}

	public void printBoard() {
	    for (int i = 0; i < this.boardRow; i++) {
	        for (int j = 0; j < this.boardCol; j++) {
	            if (i == 0 && j != 0) {
	            	System.out.print(j  + " | ");
	            } else if (j == 0 && i != 0) {
	            	System.out.print(i  + " | ");
	            } else {
	                System.out.print(this.board[i][j] + " | ");
	            }
	        }
	        System.out.println();
	        for (int k = 0; k < (this.boardRow * 4) - 1; k++) {
	            System.out.print("-");
	        }
	        System.out.println();
	    }
	}
}
