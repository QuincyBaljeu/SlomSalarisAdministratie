package GUI;

import Data.*;
import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class GUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        TabPane tabPane = new TabPane();

        Tab addWorker = new Tab("Add worker");
        Tab salaryInfo = new Tab("Salary information");
        Tab workerInfo = new Tab("Worker information");
        Tab searchWorker = new Tab("Search worker");
        Tab fileReader = new Tab("Read or load file");

        tabPane.getTabs().addAll(addWorker, salaryInfo, workerInfo, searchWorker, fileReader);

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        stage.setTitle("Main menu");
        ArrayList<TextField> textFields = new ArrayList<>();
        ObservableList<Employee> employees = FXCollections.observableArrayList();


        /**
         * add Worker
         */

        VBox labelVbox = new VBox();
        VBox textFieldVbox = new VBox();
        HBox hBox = new HBox();

        BorderPane addWorkerBorderPane = new BorderPane();

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
        comboBox.getItems().addAll("Chef", "Commission worker", "Hour worker", "Piece worker");

        //components general
        Button confirmData = new Button("Confirm data");
        Button print = new Button("Print");

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
            //TODO Add invalid input type errors
            for (TextField textField : textFields) {
                if (textField.getText().isEmpty()) {
                    emptyFieldAlert.showAndWait();
                    return;
                }
            }

            if (comboBox.getValue().toString().equals("Chef")) {
                //TODO assign text field value to bonus and assigned bonus
                employees.add(new Chef(Integer.parseInt(IDTextField.getText()),
                        firstNameTextField.getText(),
                        lastNameTextField.getText(),
                        Double.parseDouble(salaryTextField.getText()),
                        "Chef",
                        10.0,
                        true));
            } else if (comboBox.getValue().toString().equals("Commission worker")) {
                //TODO assign text field value to amountOfCommissions
                employees.add(new CommissionWorker(Integer.parseInt(IDTextField.getText()),
                        firstNameTextField.getText(),
                        lastNameTextField.getText(),
                        Double.parseDouble(salaryTextField.getText()),
                        "Commission worker",
                        10
                ));
            } else if (comboBox.getValue().toString().equals("Hour worker")) {
                //TODO assign text field value to hoursWorked
                employees.add(new HourWorker(Integer.parseInt(IDTextField.getText()),
                        firstNameTextField.getText(),
                        lastNameTextField.getText(),
                        Double.parseDouble(salaryTextField.getText()),
                        "Hour worker",
                        123
                ));
            } else if (comboBox.getValue().toString().equals("Piece worker")) {
                //TODO assign text field value to amountOfPieces
                employees.add(new PieceWorker(Integer.parseInt(IDTextField.getText()),
                        firstNameTextField.getText(),
                        lastNameTextField.getText(),
                        Double.parseDouble(salaryTextField.getText()),
                        "Piece worker",
                        123
                ));
            }

            for (TextField textField : textFields){
                textField.setText("");
            }

            print.setOnAction(event1 -> {
                double totalSalary = 0;
                for (Employee employee : employees) {
                    System.out.println(employee.toString() + "\n");
                    totalSalary += employee.getSalary();
                }
                System.out.println("Total monthly salary: " + totalSalary);
            });
        });

        //finalizing scene
        labelVbox.getChildren().addAll(IDLabel, firstNameLabel, lastNameLabel, salaryLabel, positionLabel);
        textFieldVbox.getChildren().addAll(IDTextField, firstNameTextField, lastNameTextField, salaryTextField, comboBox, confirmData, print);

        hBox.getChildren().addAll(labelVbox, textFieldVbox);

        labelVbox.setSpacing(8);
        hBox.setSpacing(50);

        addWorkerBorderPane.setLeft(hBox);

        addWorker.setContent(addWorkerBorderPane);


        /**
         *  Salary info
         */

        BorderPane salaryInfoBorderpane = new BorderPane();

        TableView salaryInfoTableView = new TableView();

        TableColumn idColumn = new TableColumn("Worker id");
        TableColumn lastNameColumn = new TableColumn("Last name");
        TableColumn salaryColumn = new TableColumn("Salary");

        idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("ID"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Employee, Double>("salary"));

        salaryInfoTableView.getColumns().addAll(idColumn, lastNameColumn, salaryColumn);

        salaryInfoTableView.setItems(employees);

        salaryInfoBorderpane.setCenter(salaryInfoTableView);

        salaryInfo.setContent(salaryInfoBorderpane);


        /**
         *  Finalizing scene
         */

        Scene scene = new Scene(tabPane);
        stage.setScene(scene);
        stage.show();
    }

}
