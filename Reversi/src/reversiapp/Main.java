package reversiapp;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	@Override
	public void start(Stage primaryStage) {
		/*try {
			HBox root = (HBox)FXMLLoader.load(getClass().getResource("ReversiGame.fxml"));
			Scene scene = new Scene(root,550,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setTitle("Reversi Game");
			primaryStage.setScene(scene);
			ReversiGameController gameController = new ReversiGameController();
			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		this.primaryStage = primaryStage;
		this.showHome();
		
	}
	
	public static void showHome() {
		primaryStage.setTitle("Reversi Game");
		try {
			mainLayout = (BorderPane)FXMLLoader.load(Main.class.getResource("MainView.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void showGameScene() {
		try {
			HBox game = (HBox)FXMLLoader.load(Main.class.getResource("ReversiGame.fxml"));
			mainLayout.setCenter(game);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void showSettings() {
		try {
			BorderPane game = (BorderPane)FXMLLoader.
					load(Main.class.getResource("SettingsDefinitions.fxml"));
			mainLayout.setCenter(game);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
