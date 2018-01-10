package game;

import java.util.ArrayList;

public class HumanPlayer {
	private char disk;
	private int points;
	
	public HumanPlayer(char p) {
	    this.disk = p;
		this.points = 0;
	}
	
	public Point chooseSquare(ArrayList<Point> vecPoints) {
	    int x = 0, y = 0;
	    /*char a;
	    System.in.
	    cin >> x >> a >> y;
	    if(!x || !y) {
	        cin.clear();
	        cin.ignore(numeric_limits<streamsize>::max(), '\n');
	        return Point(0, 0);
	    }*/
	    return new Point(x, y);
	}
	
	public char getDisk() {
	    return this.disk;
	}
	
	public void setDisk(char d) {
	    this.disk = d;
	}
	
	public int getPoint() {
	    return this.points;
	}
	
	public void setPoint(int newPoints) {
	    this.points += newPoints;
	}
}
