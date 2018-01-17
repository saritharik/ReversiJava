package reversiapp;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class SettingsController  implements Initializable {
	@FXML
	private ComboBox firstPlayer;
	@FXML
	private ComboBox firstPlayerColor;
	@FXML
	private ComboBox secondPlayerColor;
	@FXML
	private ComboBox SizeBoard;
	@FXML
	private Button finishSet;
	
	private Main main;
	ObservableList<String> firstPlayerOptions = FXCollections.observableArrayList("X", "O");
	ObservableList<String> firstPlayerColorOptions = FXCollections.observableArrayList(
			"Black", "White", "Red", "Blue", "Yellow", "Green", "Gray", "Light Blue", "Purple");
	ObservableList<String> secondPlayerColorOptions = FXCollections.observableArrayList(
			"Black", "White", "Red", "Blue", "Yellow", "Green", "Gray", "Light Blue", "Purple");
	ObservableList<String> SizeBoardOptions = FXCollections.observableArrayList("4", "6", "8", "10", "12", "14"
			,"16" , "18", "20");
	
	/**
	 * init the 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.firstPlayer.setValue("X");
		this.firstPlayer.setItems(firstPlayerOptions);
		this.firstPlayerColor.setValue("Black");
		this.firstPlayerColor.setItems(firstPlayerColorOptions);
		this.secondPlayerColor.setValue("White");
		this.secondPlayerColor.setItems(secondPlayerColorOptions);
		this.SizeBoard.setValue("8");
		this.SizeBoard.setItems(SizeBoardOptions);
		try {
			write();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * write the settings to a file
	 * @throws IOException
	 */
	public void write() throws IOException {
		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("settings.txt"),"utf-8"));
			writer.write(this.firstPlayer.getValue().toString());
			writer.write("\n");
			writer.write(this.firstPlayerColor.getValue().toString());
			writer.write("\n");
			writer.write(this.secondPlayerColor.getValue().toString());
			writer.write("\n");
			writer.write(this.SizeBoard.getValue().toString());
			writer.write("\n");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
		
	}
	
	public void goHome() {
		main.showHome();
	}
}
