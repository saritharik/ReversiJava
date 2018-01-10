package game;

public class Point {
	private int xVal;
	private int yVal;
	
	public Point(int x, int y) {
		this.xVal = x;
		this.yVal = y;
	}
	
	public int getX() {
	    return this.xVal;
	}
	
	public int getY() {
	    return this.yVal;
	}

	public void setX(int x) {
	    this.xVal = x;
	}

	public void setY(int y) {
	    this.yVal = y;
	}
}
