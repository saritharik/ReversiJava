package game;

public class Point {
	private int xVal;
	private int yVal;
	
	/**
     * Constuctor.
     * @param x the x value.
     * @param y the y value.
     */
	public Point(int x, int y) {
		this.xVal = x;
		this.yVal = y;
	}
	
	/**
     * Return the x value.
     * @return the x.
     */
	public int getX() {
	    return this.xVal;
	}
	
	/**
     * Return the y value.
     * @return the y.
     */
	public int getY() {
	    return this.yVal;
	}

	/**
     * Set x value.
     * @param x - new value.
     */
	public void setX(int x) {
	    this.xVal = x;
	}

	/**
     * Set y value.
     * @param y - new value.
     */
	public void setY(int y) {
	    this.yVal = y;
	}
}
