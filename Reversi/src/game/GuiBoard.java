package game;

public class GuiBoard implements Board {
	private int dimention;
	private char[][] board;
	
	public GuiBoard(int dim) {
		this.dimention = dim;
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
		for (int i = 0; i < this.dimention; i++) {
	        for (int j = 0; j < this.dimention; j++) {
	            if (i == 0 && j != 0) {
	            	System.out.print(j  + " | ");
	            } else if (j == 0 && i != 0) {
	            	System.out.print(i  + " | ");
	            } else {
	                System.out.print(this.board[i][j] + " | ");
	            }
	        }
	        System.out.println();
	        for (int k = 0; k < (this.dimention * 4) - 1; k++) {
	            System.out.print("-");
	        }
	        System.out.println();
	    }
		
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
