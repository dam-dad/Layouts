package dad.javafx.layouts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class LoremIpsumApp extends Application {
	
	// model
	
	private StringProperty contenido = new SimpleStringProperty();
	
	// view
	
	private TextArea contenidoText;
	private Button cargarButton, limpiarButton;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		contenidoText = new TextArea();
		contenidoText.setWrapText(true);
		
		cargarButton = new Button("Cargar");
		cargarButton.setOnAction(e -> onCargarButtonAction(e));
		cargarButton.setDefaultButton(true);

		limpiarButton = new Button("Limpiar");
		limpiarButton.setOnAction(e -> onLimpiarButtonAction(e));
		
		FlowPane botonesPane = new FlowPane(5, 5);
		botonesPane.setPadding(new Insets(5, 0, 0, 0));
		botonesPane.setAlignment(Pos.BASELINE_RIGHT);
		botonesPane.getChildren().addAll(cargarButton, limpiarButton);
		
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(5));
		root.setCenter(contenidoText);
		root.setBottom(botonesPane);
		
		Scene scene = new Scene(root, 640, 480);
		
		primaryStage.setTitle("LorenIpsum");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		contenido.bindBidirectional(contenidoText.textProperty());
		
	}

	private void onCargarButtonAction(ActionEvent e) {
		try {
			contenido.set(FileUtils.readFileToString(new File("lorenipsum.txt")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void onLimpiarButtonAction(ActionEvent e) {
		contenido.set("");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
