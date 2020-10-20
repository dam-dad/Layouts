package dad.javafx.layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AboutEclipse extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button b1 = new Button();
		b1.setGraphic(new ImageView("images/eclipse-icon-24px.png"));

		HBox pluginsBox = new HBox();
		pluginsBox.setAlignment(Pos.BASELINE_LEFT);
		pluginsBox.setSpacing(5);
		pluginsBox.getChildren().addAll(b1, new Button("B1"), new Button("B2"), new Button("B3"), new Button("B1"), new Button("B2"), new Button("B3"));
		
		BorderPane botonesBox = new BorderPane();
		botonesBox.setLeft(new Button("Installation Details"));
		botonesBox.setRight(new Button("Close"));

		VBox bottomPane = new VBox(50, pluginsBox, botonesBox);
		bottomPane.setPadding(new Insets(5));
		
		TextArea infoText = new TextArea();
		infoText.setWrapText(true);
		infoText.setText("Eclipse IDE for Java Developers\r\n" + 
				"\r\n" + 
				"Version: 2019-12 (4.14.0)\r\n" + 
				"Build id: 20191212-1212\r\n" + 
				"(c) Copyright Eclipse contributors and others 2000, 2019.  All rights reserved. Eclipse and the Eclipse logo are trademarks of the Eclipse Foundation, Inc., https://www.eclipse.org/. The Eclipse logo cannot be altered without Eclipse's permission. Eclipse logos are provided for use under the Eclipse logo and trademark guidelines, https://www.eclipse.org/logotm/. Oracle and Java are trademarks or registered trademarks of Oracle and/or its affiliates. Other names may be trademarks of their respective owners.\r\n" + 
				"\r\n" + 
				"This product includes software developed by other open source projects including the Apache Software Foundation, https://www.apache.org/."
			);
		
		BorderPane root = new BorderPane();
		root.setCenter(infoText);
		root.setBottom(bottomPane);
		
		Scene scene = new Scene(root, 640, 480);
		
		primaryStage.setTitle("Aboud Eclipse IDE");
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image("images/eclipse-icon-24px.png"));
		primaryStage.getIcons().add(new Image("images/eclipse-icon-32px.png"));
		primaryStage.getIcons().add(new Image("images/eclipse-icon-48px.png"));
		primaryStage.getIcons().add(new Image("images/eclipse-icon-64px.png"));
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
