package reversiapp;

import javafx.fxml.FXML;

public class MainViewController {
	
	private Main main;
	
	@FXML
	private void goToGame() {
		main.showGameScene();
	}
	
	
	@FXML
	private void goToSettings() {
		main.showSettings();
	}
	
	@FXML
	private void goHome() {
		main.showHome();
	}
}
