package game;

public class GuiBoard implements Board {
	private int dimention;
	private char[][] board;
	
	public GuiBoard(int dim) {
		this.dimention = dim + 1;
		this.board = new char[this.dimention][this.dimention];
	    for (int i = 0; i < this.dimention; i++) {
	        for (int j = 0; j < this.dimention; j++) {
	            this.board[i][j] = ' ';
	        }
	    }
	    this.board[(this.dimention - 1) / 2][(this.dimention - 1) / 2] = 'O';
	    this.board[(this.dimention + 1) / 2][(this.dimention + 1) / 2] = 'O';
	    this.board[(this.dimention - 1) / 2][(this.dimention + 1) / 2] = 'X';
	    this.board[(this.dimention + 1) / 2][(this.dimention - 1) / 2] = 'X';
	}

	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char getSquare(int i, int j) {
	    return this.board[i][j];
	}

	@Override
	public void setSquare(int i, int j, char sign) {
	    this.board[i][j] = sign;
	}

	@Override
	public int getDimensions() {
	    return this.dimention;
	}

}
