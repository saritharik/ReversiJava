package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class firstApp extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Reversi");
		Label lbl = new Label("Hello World!");
		lbl.setFont(new Font("Arial", 30));
		Button btn = new Button("Click me");
		btn.setOnAction(event -> {
			lbl.setText("Button clicked!");
		});
		VBox root = new VBox();
		//root.getChildren().add(lbl);
		root.getChildren().add(btn);
		
		//StackPane root = new StackPane();
		root.getChildren().add(lbl);
		primaryStage.setScene(new Scene(root, 400, 400));
		primaryStage.show();	
	}

	public static void main(String[] args) {
		launch(args);
	}
}
