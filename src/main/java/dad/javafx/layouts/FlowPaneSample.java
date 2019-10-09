package dad.javafx.layouts;


import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FlowPaneSample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FlowPane root = new FlowPane();
		root.setHgap(5);
		root.setVgap(5);
		root.setAlignment(Pos.CENTER);
		root.setOrientation(Orientation.HORIZONTAL);

		for (int i = 0; i < 50; i++) {
			
			Pane pane = new Pane();
			pane.setStyle("-fx-background-color: lightgreen;");
			pane.setPrefSize(60, 40);
			
			root.getChildren().add(pane);
			
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
