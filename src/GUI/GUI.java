package GUI;

import Data.Employee;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Main menu");
        ArrayList<TextField> textFields = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();

        VBox labelVbox = new VBox();
        VBox textFieldVbox = new VBox();
        HBox hBox = new HBox();

        BorderPane borderPane = new BorderPane();

        //Components ID
        Label IDLabel = new Label("Worker ID: ");
        TextField IDTextField = new TextField();
        textFields.add(IDTextField);

        //components first name
        Label firstNameLabel = new Label("First name: ");
        TextField firstNameTextField = new TextField();
        textFields.add(firstNameTextField);

        //components last name
        Label lastNameLabel = new Label("Last name: ");
        TextField lastNameTextField = new TextField();
        textFields.add(lastNameTextField);

        //components salary
        Label salaryLabel = new Label("Salary: ");
        TextField salaryTextField = new TextField();
        textFields.add(salaryTextField);

        //components position
        Label positionLabel = new Label("Position: ");
        ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll("Chef", "Commission worker", "Hour Worker", "Piece Worker");

        //components general
        Button confirmData = new Button("Confirm data");

        Alert emptyFieldAlert = new Alert(Alert.AlertType.ERROR);
        emptyFieldAlert.setTitle("Error");
        emptyFieldAlert.setHeaderText(null);
        emptyFieldAlert.setContentText("Please enter all text fields");

        Alert IDInvalidIntAlert = new Alert(Alert.AlertType.ERROR);
        IDInvalidIntAlert.setTitle("Error");
        IDInvalidIntAlert.setHeaderText(null);
        IDInvalidIntAlert.setContentText("Please enter a number in ID field");

        Alert salaryInvalidIntAlert = new Alert(Alert.AlertType.ERROR);
        salaryInvalidIntAlert.setTitle("Error");
        salaryInvalidIntAlert.setHeaderText(null);
        salaryInvalidIntAlert.setContentText("Please enter a number in salary field");

        Alert firstNameInvalidStringAlert = new Alert(Alert.AlertType.ERROR);
        firstNameInvalidStringAlert.setTitle("Error");
        firstNameInvalidStringAlert.setHeaderText(null);
        firstNameInvalidStringAlert.setContentText("Please enter a name in first name field");

        Alert lastNameInvalidStringAlert = new Alert(Alert.AlertType.ERROR);
        lastNameInvalidStringAlert.setTitle("Error");
        lastNameInvalidStringAlert.setHeaderText(null);
        lastNameInvalidStringAlert.setContentText("Please enter a name in last name field");

        confirmData.setOnAction(event -> {

            for(TextField textField : textFields){
                if(textField.getText().isEmpty()){
                    emptyFieldAlert.showAndWait();
                    return;
                }
            }
        });

        //finalizing scene
        labelVbox.getChildren().addAll(IDLabel, firstNameLabel, lastNameLabel, salaryLabel);
        textFieldVbox.getChildren().addAll(IDTextField, firstNameTextField, lastNameTextField, salaryTextField, confirmData, comboBox);

        hBox.getChildren().addAll(labelVbox, textFieldVbox);

        labelVbox.setSpacing(8);
        hBox.setSpacing(50);

        borderPane.setLeft(hBox);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

}
