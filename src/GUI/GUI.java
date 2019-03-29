package GUI;

import Data.*;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

        VBox componentVbox = new VBox();
        BorderPane addWorkerBorderPane = new BorderPane();

        //Components ID
        Label IDLabel = new Label("Worker ID: ");
        TextField IDTextField = new TextField();
        HBox IDHbox = new HBox();
        textFields.add(IDTextField);
        IDHbox.setSpacing(200);
        IDHbox.getChildren().addAll(IDLabel, IDTextField);

        //components first name
        Label firstNameLabel = new Label("First name: ");
        TextField firstNameTextField = new TextField();
        HBox firstNameHbox = new HBox();
        textFields.add(firstNameTextField);
        firstNameHbox.setSpacing(200);
        firstNameHbox.getChildren().addAll(firstNameLabel, firstNameTextField);

        //components last name
        Label lastNameLabel = new Label("Last name: ");
        TextField lastNameTextField = new TextField();
        HBox lastNameHbox = new HBox();
        textFields.add(lastNameTextField);
        lastNameHbox.setSpacing(200);
        lastNameHbox.getChildren().addAll(lastNameLabel, lastNameTextField);

        //components salary
        Label salaryLabel = new Label("Salary: ");
        TextField salaryTextField = new TextField();
        HBox salaryHbox = new HBox();
        textFields.add(salaryTextField);
        salaryHbox.setSpacing(225);
        salaryHbox.getChildren().addAll(salaryLabel, salaryTextField);

        //components position
        Label positionLabel = new Label("Position: ");
        ComboBox positionComboBox = new ComboBox();
        HBox positionHbox = new HBox();
        positionComboBox.getItems().addAll("Chef", "Commission worker", "Hour worker", "Piece worker");
        positionHbox.setSpacing(213);
        positionHbox.getChildren().addAll(positionLabel, positionComboBox);

        //components extra
        Label extraInfoLabel = new Label("Bonus: " + "\n" +
                                        "Amount of commissions: " + "\n" +
                                        "Hours Worked: " + "\n" +
                                        "Amount of Pieces: ");
        TextField extraInfoTextField = new TextField();
        HBox extraInfoHbox = new HBox();
        textFields.add(extraInfoTextField);
        extraInfoHbox.setSpacing(113);
        extraInfoHbox.getChildren().addAll(extraInfoLabel, extraInfoTextField);

        //components bonus
        Label bonusAssignedLabel = new Label("Bonus assigned: ");
        CheckBox bonusAssignedCheckbox = new CheckBox();
        HBox bonusAssignedHbox = new HBox();
        bonusAssignedHbox.setSpacing(200);
        bonusAssignedHbox.getChildren().addAll(bonusAssignedLabel, bonusAssignedCheckbox);

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

            switch (positionComboBox.getValue().toString()) {
                case "Chef":
                    Boolean idInUse = false;
                    for (Employee employee : employees) {
                        if(employee.getID() == Integer.parseInt(IDTextField.getText())){
                            idInUse = true;
                            break;
                        }
                    }

                    if(!idInUse){
                        employees.add(new Chef(Integer.parseInt(IDTextField.getText()),
                                firstNameTextField.getText(),
                                lastNameTextField.getText(),
                                Double.parseDouble(salaryTextField.getText()),
                                "Chef",
                                Double.valueOf(extraInfoTextField.getText()),
                                bonusAssignedCheckbox.isSelected()));
                    } else {
                        System.out.println("in use");
                    }

                    //TODO assign text field value to bonus and assigned bonus

                    break;

                case "Commission worker":
                    idInUse = false;
                    for (Employee employee : employees) {
                        if(employee.getID() == Integer.parseInt(IDTextField.getText())){
                            idInUse = true;
                            break;
                        }
                    }

                    if(!idInUse){
                        employees.add(new CommissionWorker(Integer.parseInt(IDTextField.getText()),
                                firstNameTextField.getText(),
                                lastNameTextField.getText(),
                                Double.parseDouble(salaryTextField.getText()),
                                "Commission worker",
                                Integer.valueOf(extraInfoTextField.getText())
                        ));
                    } else {
                        System.out.println("in use");
                    }
                    //TODO assign text field value to amountOfCommissions
                    break;
                case "Hour worker":
                    idInUse = false;
                    for (Employee employee : employees) {
                        if(employee.getID() == Integer.parseInt(IDTextField.getText())){
                            idInUse = true;
                            break;
                        }
                    }

                    if(!idInUse){
                        employees.add(new HourWorker(Integer.parseInt(IDTextField.getText()),
                                firstNameTextField.getText(),
                                lastNameTextField.getText(),
                                Double.parseDouble(salaryTextField.getText()),
                                "Hour worker",
                                Integer.valueOf(extraInfoTextField.getText())
                        ));
                    } else {
                        System.out.println("in use");
                    }
                    //TODO assign text field value to hoursWorked

                    break;
                case "Piece worker":
                    idInUse = false;
                    for (Employee employee : employees) {
                        if(employee.getID() == Integer.parseInt(IDTextField.getText())){
                            idInUse = true;
                            break;
                        }
                    }

                    if(!idInUse){
                        employees.add(new PieceWorker(Integer.parseInt(IDTextField.getText()),
                                firstNameTextField.getText(),
                                lastNameTextField.getText(),
                                Double.parseDouble(salaryTextField.getText()),
                                "Piece worker",
                                Integer.valueOf(extraInfoTextField.getText())
                        ));
                    } else {
                        System.out.println("in use");
                    }
                    //TODO assign text field value to amountOfPieces
                    break;
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
        componentVbox.setSpacing(5);
        componentVbox.getChildren().addAll( positionHbox, IDHbox, firstNameHbox, lastNameHbox, salaryHbox, extraInfoHbox, bonusAssignedHbox, confirmData);

        addWorkerBorderPane.setLeft(componentVbox);

        addWorker.setContent(addWorkerBorderPane);

        /**
         *  Salary Info
         */


        BorderPane salaryInfoBorderPane = new BorderPane();
        ObservableList<Employee> salaryList = FXCollections.observableArrayList();
        HBox salaryInfoHbox = new HBox();
        Label salaryInfoIdLabel = new Label("Enter employee id");
        Label salaryInfoWeekLabel = new Label("Amount of weeks");
        TextField salaryInfoWeeks = new TextField();
        TextField salaryInfoId = new TextField();

        Button salaryInfoButton = new Button("Add employee");


        salaryInfoHbox.getChildren().addAll(salaryInfoIdLabel, salaryInfoId, salaryInfoWeekLabel, salaryInfoWeeks, salaryInfoButton);
        salaryInfoBorderPane.setLeft(salaryInfoHbox);
        salaryInfo.setContent(salaryInfoBorderPane);

        /**
         *  Worker info
         */

        BorderPane workerInfoBorderpane = new BorderPane();

        TableView workerInfoTableView = new TableView();

        TableColumn workerIdColumn = new TableColumn("Worker id");
        TableColumn workerLastNameColumn = new TableColumn("Last name");
        TableColumn workerSalaryColumn = new TableColumn("Salary");

        workerIdColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("ID"));
        workerLastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
        workerSalaryColumn.setCellValueFactory(new PropertyValueFactory<Employee, Double>("salary"));

        workerInfoTableView.getColumns().addAll(workerIdColumn, workerLastNameColumn, workerSalaryColumn);

        workerInfoTableView.setItems(employees);

        workerInfoBorderpane.setCenter(workerInfoTableView);

        workerInfo.setContent(workerInfoBorderpane);

        /**
         * search tab
         */
        BorderPane searchBorderpane = new BorderPane();
        HBox searchHbox = new HBox();
        searchHbox.setSpacing(25);
        TextField searchTextfield = new TextField();
        Button searchButton = new Button("Search");
        ComboBox searchComboBox = new ComboBox();
        searchComboBox.getItems().addAll("First name", "Last name", "ID");

        ObservableList<Employee> searchResults = FXCollections.observableArrayList();

        searchHbox.getChildren().addAll(searchTextfield, searchComboBox, searchButton);

        TableView searchResultTable = new TableView();
        TableColumn searchTableColumnId = new TableColumn("ID");
        TableColumn searchTableColumnFirstName = new TableColumn("First name");
        TableColumn searchTableColumnLastName = new TableColumn("Last name");

        searchTableColumnFirstName.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
        searchTableColumnLastName.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
        searchTableColumnId.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("ID"));
        searchResultTable.getColumns().addAll(searchTableColumnId, searchTableColumnFirstName, searchTableColumnLastName);

        searchButton.setOnAction(event -> {
            searchResults.clear();
            switch ((String)searchComboBox.getValue()){
                case "First name":
                    for(Employee employee : employees){
                        if (employee.getFirstName().toLowerCase().equals(searchTextfield.getText().toLowerCase())){
                            searchResults.add(employee);
                        }
                    }
                    break;
                case "Last name":
                    for (Employee employee : employees){
                        if(employee.getLastName().toLowerCase().equals(searchTextfield.getText().toLowerCase())){
                            searchResults.add(employee);
                        }
                    }
                    break;
                case  "ID":
                    for (Employee employee : employees){
                        if (String.valueOf(employee.getID()).equals(searchTextfield.getText())){
                            searchResults.add(employee);
                        }
                    }
                    break;
            }
            for (Employee employee : searchResults) {
                System.out.println(employee.toString());
            }
        });

        searchResultTable.setItems(searchResults);

        searchBorderpane.setCenter(searchResultTable);
        searchBorderpane.setTop(searchHbox);
        searchWorker.setContent(searchBorderpane);

        /**
         *  File reader tab
         */

        DataReader dataReader = new DataReader();
        BorderPane fileReaderBorderpane = new BorderPane();

        //Text io
        Button textReadButton = new Button("Read data from text file");
        Button textSaveButton = new Button("Save data to text file");
        Button objectIoReadButton = new Button("Read data from object file");
        Button objectIoSaveButton = new Button("Save data to object file");

        Label fileRead = new Label("Read data");
        Label fileSave = new Label("Save data");

        VBox readFileVbox = new VBox();
        VBox saveFileVbox = new VBox();
        readFileVbox.setSpacing(15);
        saveFileVbox.setSpacing(15);

        readFileVbox.getChildren().addAll(fileRead, textReadButton, objectIoReadButton);
        saveFileVbox.getChildren().addAll(fileSave, textSaveButton, objectIoSaveButton);

        FileChooser fileChooser = new FileChooser();
        textReadButton.setOnAction(event -> {
            File file = fileChooser.showOpenDialog(null);
            dataReader.readDataFromTextfile(file, employees);
        });

        objectIoReadButton.setOnAction(event -> {
            File file = fileChooser.showOpenDialog(null);
        });

        textSaveButton.setOnAction(event -> {
            String filename = "Employees" + LocalDate.now();
            dataReader.saveDataToTextfile(filename,employees);
        });

        objectIoSaveButton.setOnAction(event -> {
        });

        fileReaderBorderpane.setRight(readFileVbox);
        fileReaderBorderpane.setLeft(saveFileVbox);

        fileReader.setContent(fileReaderBorderpane);

        /**
         *  Finalizing scene
         */

        Scene scene = new Scene(tabPane);
        stage.setScene(scene);
        stage.show();
    }

}
