package Data;

import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {

    public void readDataFromTextfile(File file, ObservableList<Employee> employees){

        Scanner scanner = null;

        try{
            scanner = new Scanner(file);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        while (scanner.hasNextLine()){
            String employee = scanner.nextLine();
            String[] employeeDetails = employee.split("#");
            String position = employeeDetails [0];
                switch(position){
                    case "Chef":
                        int ID = Integer.valueOf(employeeDetails[1]);
                        String firstName = employeeDetails[2];
                        String lastName = employeeDetails[3];
                        Double salary = Double.valueOf(employeeDetails[4]);
                        Double bonus = Double.valueOf(employeeDetails[5]);
                        Boolean bonusAssigned = Boolean.valueOf(employeeDetails[6]);

                        employees.add(new Chef(ID, firstName, lastName, salary, position, bonus, bonusAssigned));
                        break;
                    case "Commission worker":
                        ID = Integer.valueOf(employeeDetails[1]);
                        firstName = employeeDetails[2];
                        lastName = employeeDetails[3];
                        salary = Double.valueOf(employeeDetails[4]);
                        int amountOfCommissions = Integer.valueOf(employeeDetails[5]);

                        employees.add(new CommissionWorker(ID, firstName, lastName, salary, position, amountOfCommissions));
                        break;

                    case "Hour worker":
                        ID = Integer.valueOf(employeeDetails[1]);
                        firstName = employeeDetails[2];
                        lastName = employeeDetails[3];
                        salary = Double.valueOf(employeeDetails[4]);
                        int hoursWorked = Integer.valueOf(employeeDetails[5]);

                        employees.add(new HourWorker(ID, firstName, lastName, salary, position, hoursWorked));
                        break;

                    case "Piece worker":
                        ID = Integer.valueOf(employeeDetails[1]);
                        firstName = employeeDetails[2];
                        lastName = employeeDetails[3];
                        salary = Double.valueOf(employeeDetails[4]);
                        int amountOfPieces = Integer.valueOf(employeeDetails[5]);


                        employees.add(new PieceWorker(ID, firstName, lastName, salary, position, amountOfPieces));
                        break;
            }
        }
    }


    public void saveDataToTextfile(String filename, ObservableList<Employee> employees){

        File file = new File(filename + ".txt");

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(file))){
            for (Employee employee : employees) {
                writer.println(employee.getReaderString());
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void readDataFromObjectfile(File file, ArrayList<Employee> employees){

    }

    public void saveDataToObjectfile(String filename, ArrayList<Employee> employees){

    }
}
