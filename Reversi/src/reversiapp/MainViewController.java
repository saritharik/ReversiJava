package reversiapp;

import javafx.fxml.FXML;

public class MainViewController {
	private Main main;
	
	/**
	 * plat the game
	 */
	@FXML
	private void goToGame() {
		main.showGameScene();
	}
	
	/**
	 * open the settings frame
	 */
	@FXML
	private void goToSettings() {
		main.showSettings();
	}
	
	/**
	 * return to the menu
	 */
	@FXML
	private void goHome() {
		main.showHome();
	}
}
