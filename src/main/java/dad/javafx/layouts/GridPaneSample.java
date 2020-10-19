package dad.javafx.layouts;

import java.time.LocalDate;
import java.time.Period;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class GridPaneSample extends Application {
	
	// model
	
	private IntegerProperty edad = new SimpleIntegerProperty();
	private ObjectProperty<LocalDate> fechaNacimiento = new SimpleObjectProperty<>();
	
	// view
	
	private TextField nombreText;
	private TextField apellidosText;
	private TextField dniText;
	private DatePicker fechaNacPicker;
	private TextField [] ibanText;
	private RadioButton hombreRadio;
	private RadioButton mujerRadio;
	private Label edadLabel;

	@Override
	public void start(Stage primaryStage) throws Exception {

		nombreText = new TextField();
		nombreText.setPromptText("Nombre del alumno");

		apellidosText = new TextField();
		apellidosText.setPromptText("Apellidos del alumno");

		dniText = new TextField();
		dniText.setPromptText("DNI del alumno");
		
		fechaNacPicker = new DatePicker();
		fechaNacPicker.setPromptText("Fecha de nacimiento");
		
		ibanText = new TextField[6]; 
		for (int i = 0; i < ibanText.length; i++) {
			ibanText[i] = new TextField();
			ibanText[i].setPrefColumnCount(4);
		}
		
		edadLabel = new Label("X años");
		
		hombreRadio = new RadioButton("Hombre");
		mujerRadio = new RadioButton("Mujer");
		
		ToggleGroup sexoGroup = new ToggleGroup();
		sexoGroup.getToggles().addAll(hombreRadio, mujerRadio);
		
		GridPane root = new GridPane();
		root.setPadding(new Insets(5));
		root.setHgap(5);
		root.setVgap(5);
//		root.setGridLinesVisible(true);
//		root.setStyle("-fx-background-color: orange;");
		root.addRow(0, new Label("Nombre:"), nombreText);
		root.addRow(1, new Label("Apellidos:"), apellidosText);
		root.addRow(2, new Label("DNI:"), dniText);
		root.addRow(3, new Label("Fecha de nacimiento:"), fechaNacPicker);
		root.addRow(4, new Label("IBAN:"), new HBox(5, ibanText));
		root.addRow(5, new Label("Sexo:"), new HBox(5, hombreRadio, mujerRadio));
		root.add(edadLabel, 2, 3);
		
		ColumnConstraints [] cols = {
			new ColumnConstraints(),	
			new ColumnConstraints(),	
		};
		root.getColumnConstraints().setAll(cols);
		
		cols[0].setHalignment(HPos.RIGHT);
		cols[1].setHgrow(Priority.ALWAYS);
		cols[1].setFillWidth(true);
		
		GridPane.setFillWidth(dniText, false);
		
		
		Scene scene = new Scene(root, 640, 480);
		
		primaryStage.setTitle("Ejemplo de GridPane");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// bindeos
		
		fechaNacimiento.bind(fechaNacPicker.valueProperty());
		
		edadLabel.textProperty().bind(Bindings.concat(edad).concat(" años"));
		
		fechaNacimiento.addListener((o, ov, nv) -> onFechaNacimientoChanged(nv));
		
	}

	private void onFechaNacimientoChanged(LocalDate nv) {
		edad.set(Period.between(nv, LocalDate.now()).getYears());
	}

	public static void main(String[] args) {
		launch(args);
	}

}
