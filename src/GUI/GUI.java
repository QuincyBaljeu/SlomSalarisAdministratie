package GUI;

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

        //components general
        Button confirmData = new Button("Confirm data");

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Please enter all text fields");

        confirmData.setOnAction(event -> {
            for(TextField textField : textFields){
                if(textField.getText().isEmpty()){
                    System.out.println("Leeg vak");
                    alert.showAndWait();
                    return;
                }
            }
        });

        //finalizing scene
        labelVbox.getChildren().addAll(IDLabel, firstNameLabel, lastNameLabel, salaryLabel);
        textFieldVbox.getChildren().addAll(IDTextField, firstNameTextField, lastNameTextField, salaryTextField, confirmData);

        hBox.getChildren().addAll(labelVbox, textFieldVbox);

        labelVbox.setSpacing(8);
        hBox.setSpacing(50);

        borderPane.setLeft(hBox);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
    }

}
