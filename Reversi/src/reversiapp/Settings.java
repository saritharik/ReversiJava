package reversiapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class Settings {
	
	private char firstPlayer;
	private String firstPlayerColor;
	private String secondPlayerColor;
	private int sizeBoard;
	private BufferedReader reader;
	
	public Settings(Reader reader) {
		this.reader = (BufferedReader) reader;
	}
	
	public void readFromFile() {
		try {
			this.firstPlayer = this.reader.readLine().charAt(0);
			this.firstPlayerColor = this.reader.readLine();
			this.secondPlayerColor = this.reader.readLine();
			this.sizeBoard = Integer.parseInt(this.reader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public void writeToFile() {
		try {
			this.firstPlayer = this.reader.readLine().charAt(0);
			this.firstPlayerColor = this.reader.readLine();
			this.secondPlayerColor = this.reader.readLine();
			this.sizeBoard = Integer.parseInt(this.reader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} */
	
	public char getFirstPlayer() {
		return this.firstPlayer;
	}
	
	public String getFirstPlayerColor() {
		return this.firstPlayerColor;
	}
	
	public String getSecondPlayerColor() {
		return this.secondPlayerColor;
	}
	
	public int getSizeBoard() {
		return this.sizeBoard;
	}
}
