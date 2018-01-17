package game;

import java.util.ArrayList;

public class HumanPlayer {
	private char disk;
	private int points;
	
	/**
     * Constructor.
     * @param p the disk.
     */
	public HumanPlayer(char p) {
	    this.disk = p;
		this.points = 0;
	}
	
	/**
     * Choose square.
     * @return the location of the square.
     */
	public Point chooseSquare(ArrayList<Point> vecPoints) {
	    int x = 0, y = 0;
	    return new Point(x, y);
	}
	
	/**
     * Return the disk.
     * @return the disk.
     */
	public char getDisk() {
	    return this.disk;
	}
	
	/**
     * Set disk.
     * @param d the char of the disk.
     */
	public void setDisk(char d) {
	    this.disk = d;
	}
	
	/**
     * Returns the points.
     * @return the points.
     */
	public int getPoint() {
	    return this.points;
	}
	
	/**
     * Set points to player.
     * @param newPoints thr points to set.
     */
	public void setPoint(int newPoints) {
	    this.points += newPoints;
	}
}
