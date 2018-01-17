package reversiapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class Settings {
	
	private char firstPlayer;
	private String firstPlayerColor;
	private String secondPlayerColor;
	private int sizeBoard;
	private BufferedReader reader;
	@FXML
	private ComboBox firstPlayerOptions;
	@FXML
	private ComboBox firstPlayerColorOptions;
	@FXML
	private ComboBox secondPlayerColorOptions;
	@FXML
	private ComboBox SizeBoardOptions;
	
	/**
	 * Constructor
	 * @param reader buffered reader
	 */
	public Settings(Reader reader) {
		this.reader = (BufferedReader) reader;
		SettingsController controller = new SettingsController();
	}
	
	/**
	 * read the settings from file and set them to the variables
	 */
	public void readFromFile() {
		try {
			this.firstPlayer = this.reader.readLine().charAt(0);
			this.firstPlayerColor = this.reader.readLine();
			this.secondPlayerColor = this.reader.readLine();
			this.sizeBoard = Integer.parseInt(this.reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * return the start player
	 * @return the char of the start player
	 */
	public char getFirstPlayer() {
		return this.firstPlayer;
	}
	
	/**
	 * return the color of the first player
	 * @return a string of the color of the first player
	 */
	public String getFirstPlayerColor() {
		return this.firstPlayerColor;
	}
	
	/**
	 * return the color of the second player
	 * @return a string of the color of the second player
	 */
	public String getSecondPlayerColor() {
		return this.secondPlayerColor;
	}
	
	/**
	 * return the size of the board
	 * @return the size of the board
	 */
	public int getSizeBoard() {
		return this.sizeBoard;
	}
}
