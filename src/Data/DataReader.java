package Data;

import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {

    public void readDataFromTextfile(File file, ObservableList<Employee> employees){

        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()){
                String employeeString = scanner.nextLine();
                Scanner employeeScanner = new Scanner(employeeString);
                employeeScanner.useDelimiter("#");

                while (employeeScanner.hasNext()){
                    String position = employeeScanner.next();
                    switch(position){
                        case "Chef":
                            int ID = employeeScanner.nextInt();
                            String firstName = employeeScanner.next();
                            String lastName = employeeScanner.next();
                            double salary = employeeScanner.nextDouble();
                            double bonus = employeeScanner.nextDouble();
                            boolean bonusAssigned = employeeScanner.hasNextBoolean();

                            employees.add(new Chef(ID, firstName, lastName, salary, position, bonus, bonusAssigned));
                            break;

                        case "CommissionWorker":

                            break;

                        case "HourWorker":

                            break;

                        case "PieceWorker":

                            break;
                    }
                }
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
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
