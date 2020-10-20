package dad.javafx.layouts;


import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FlowPaneSample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FlowPane root = new FlowPane();
		root.setHgap(2);
		root.setVgap(15);
		root.setAlignment(Pos.CENTER);
		root.setOrientation(Orientation.HORIZONTAL);

		for (int i = 0; i < 50; i++) {
			
			Button button = new Button("" + i);
			button.setStyle("-fx-background-color: lightgreen;");
			button.setPrefSize(60, 40);
			
			root.getChildren().add(button);
			
		}
		
		Scene scene = new Scene(root, 640, 480);
		
		primaryStage.setTitle("Ejemplo de FlowPane");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
