package game;

import java.util.ArrayList;

public class GameLogic {
	private Board board;
	private int oPoints;
	private int xPoints;
	private ArrayList<Point> list = new ArrayList<Point>();
	public static final int START_POINT = 2;
	 
	/**
     * Constructor.
     * @param p1 first player.
     * @param p2 second player.
     */
	public GameLogic(Board b) {
		this.board = b;
	    this.oPoints = START_POINT;
	    this.xPoints = START_POINT;
	}

	/**
     * Check if the player choose right location.
     * @param p the selected point.
     * @param a the disk.
     * @return true or false.
     */
	public boolean possibleMoves(Point p, char a) {
		boolean b = false;
	    ArrayList<Point> v = this.findPoints(a);
	    for(int i = 0; i < v.size(); i++) {
	        if ((v.get(i).getX() == p.getX()) && 
	        		(v.get(i).getY() == p.getY())) {
	            b = true;
	            break;
	        }
	    }
	    return b;

	}
	
	/**
     * Flip one disk in other.
     * @param i the row.
     * @param j the col.
     */
	public void flip(int i, int j) {
	    char a = board.getSquare(i,j);
	    if (a == 'X') {
	        board.setSquare(i, j, 'O');
	    }
	    if (a == 'O') {
	        board.setSquare(i, j, 'X');
	    }
	}
	
	/**
     * Make one move in the game.
     * @param i the row.
     * @param j the col.
     * @param a the disk.
     */
	public void oneMove(int i, int j, char a) {
	    this.board.setSquare(i, j, a);
	    ArrayList<Point> vec = this.checking(i, j, a);
	    int size = vec.size();
	    for(int m = 0; m < size ; m++) {
	        this.flip(vec.get(m).getX(),vec.get(m).getY());
	    }
	    list.clear();
	}

	/**
     * Find the possible locations to put disks.
     * @param a the disk.
     * @return list of points.
     */
	public ArrayList<Point> findPoints(char a) {
		ArrayList<Point> points = new ArrayList<Point>();
		ArrayList<Point> check = new ArrayList<Point>();
		
		int dimention = board.getDimensions();

	    for (int i = 0; i < dimention; i++) {
	        for (int j = 0; j < dimention; j++) {
	            if (board.getSquare(i, j) == ' ') {
	                check.addAll(this.checking(i, j, a));
	                if (check.size() != 0) {
	                    points.add(new Point(i, j));
	                    check.clear();
	                    list.clear();
	                }

	            }
	        }
	    }
	    return points;
	}

	/**
     * Checking which points need to replace.
     * @param i the row.
     * @param j the col.
     * @param a the disk.
     * @return vector of all points.
     */
	public ArrayList<Point> checking(int i, int j, char a) {
	    int row = i;
	    int col = j;
	    char self = a, other;
	    ArrayList<Point> vecTemp = new ArrayList<Point>();
	    if (self == 'X') {
	        other = 'O';
	    } else {
	        other = 'X';
	    }
	    while (i - 1 >= 0) {
	        if (board.getSquare(i-1, j) != ' ' &&
	            board.getSquare(i-1, j) == other) {
	            vecTemp.add(new Point(i-1, j));
	            i--;
	        } else {
	            if (board.getSquare(i - 1,j) == self) {
	                list.addAll(vecTemp);// v.end(), vecTemp.begin(), vecTemp.end());
	            }
	            break;
	        }
	    }
	    vecTemp.clear();
	    i = row; j = col;
	    while (j - 1 >= 0) {
	        if (board.getSquare(i, j-1) != ' ' &&
	            board.getSquare(i, j-1) == other) {
	        	vecTemp.add(new Point(i, j-1));
	            j--;
	        } else {
	            if (board.getSquare(i,j - 1) == self) {
	            	list.addAll(vecTemp); //(v.end(), vecTemp.begin(), vecTemp.end());
	            }
	            break;
	        }
	    }
	    vecTemp.clear();
	    i = row; j = col;
	    int dimention = board.getDimensions();
	    while (i + 1 < dimention) {
	        if (board.getSquare(i+1, j) != ' ' &&
	        	board.getSquare(i+1, j) == other) {
	        	vecTemp.add(new Point(i+1, j));
	            i++;
	        } else {
	            if (board.getSquare(i + 1,j) == self) {
	            	list.addAll(vecTemp); //(v.end(), vecTemp.begin(), vecTemp.end());
	            }
	            break;
	        }
	    }
	    vecTemp.clear();
	    i = row; j = col;
	    while (j + 1 < dimention) {
	        if (this.board.getSquare(i, j+1) != ' ' &&
	            this.board.getSquare(i, j+1) == other) {
	            vecTemp.add(new Point(i, j+1));
	            j++;
	        } else {
	            if (this.board.getSquare(i,j + 1) == self) {
	            	this.list.addAll(vecTemp); //list.insert(v.end(), vecTemp.begin(), vecTemp.end());
	            }
	            break;
	        }
	    }
	    vecTemp.clear();
	    i = row; j = col;
	    while (j + 1 < dimention &&
	            i + 1 < dimention) {
	        if (this.board.getSquare(i+1, j+1) != ' ' &&
	            this.board.getSquare(i+1, j+1) == other) {
	            vecTemp.add(new Point(i+1, j+1));
	            j++; i++;
	        } else {
	            if (this.board.getSquare(i + 1,j + 1) == self) {
	            	this.list.addAll(vecTemp); //this.list.insert(v.end(), vecTemp.begin(), vecTemp.end());
	            }
	            break;
	        }
	    }
	    vecTemp.clear();
	    i = row; j = col;
	    while (j + 1 < dimention &&
	           i - 1 >= 0) {
	        if (this.board.getSquare(i-1, j+1) != ' ' &&
	            this.board.getSquare(i-1, j+1) == other) {
	            vecTemp.add(new Point(i-1, j+1));
	            j++; i--;
	        } else {
	            if (this.board.getSquare(i - 1,j + 1) == self) {
	            	this.list.addAll(vecTemp);//this.list.insert(v.end(), vecTemp.begin(), vecTemp.end());
	            }
	            break;
	        }
	    }
	    vecTemp.clear();
	    i = row; j = col;
	    while (j - 1 >= 0 && i - 1 >= 0) {
	        if (this.board.getSquare(i-1, j-1) != ' ' &&
	            this.board.getSquare(i-1, j-1) == other) {
	            vecTemp.add(new Point(i-1, j-1));
	            j--; i--;
	        } else {
	            if (this.board.getSquare(i - 1,j - 1) == self) {
	            	this.list.addAll(vecTemp); //this.list.insert(v.end(), vecTemp.begin(), vecTemp.end());
	            }
	            break;
	        }
	    }
	    vecTemp.clear();
	    i = row; j = col;
	    while (j - 1 >= 0 &&
	           i + 1 < dimention) {
	        if (this.board.getSquare(i+1, j-1) != ' ' &&
	            this.board.getSquare(i+1, j-1) == other) {
	            vecTemp.add(new Point(i+1, j-1));
	            j--; i++;
	        } else {
	            if (this.board.getSquare(i + 1,j - 1) == self) {
	            	this.list.addAll(vecTemp);//this.list.insert(v.end(), vecTemp.begin(), vecTemp.end());
	            }
	            break;
	        }
	    }
	    vecTemp.clear();
	    return this.list;
	}

	/**
     * Set points to player.
     * @param player - to which player set points.
     * @param points - the number of points.
     */
	public void setPlayerPoints(char player, int points) {
	    if (player == 'X') {
	        xPoints = points;
	    } else if (player == 'O') {
	        oPoints = points;
	    }
	}

	/**
     * Returns points of each player.
     * @param player - to return him points.
     * @return points.
     */
	public int getPointsByPlayer(char player) {
	    if (player == 'X') {
	        return xPoints;
	    } else {
	        return oPoints;
	    }
	}
}
