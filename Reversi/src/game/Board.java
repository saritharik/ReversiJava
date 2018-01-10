package game;

public interface Board {
	    /**
	     * Print the board.
	     */
	    public void printBoard();
	    /**
	     * Return the specific square.
	     * @param i the row.
	     * @param j the col.
	     * @return the square.
	     */
	    public char getSquare(int i, int j);
	    /**
	     * Set square in the specific location.
	     * @param i the row.
	     * @param j the col.
	     * @param p the char.
	     */
	    public void setSquare(int i, int j, char p);
	    /**
	     * Return the dimensions of the board.
	     * @return the dimensions.
	     */
	    public int getDimensions();
}
