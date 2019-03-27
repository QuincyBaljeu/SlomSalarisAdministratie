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
            String employeeString = scanner.nextLine();
            Scanner employeeScanner = new Scanner(employeeString);
            employeeScanner.useDelimiter("#");

            while (employeeScanner.hasNext()){
                String position = employeeScanner.next();
                int ID = employeeScanner.nextInt();
                String firstName = employeeScanner.next();
                String lastName = employeeScanner.next();
                double salary = employeeScanner.nextDouble();

                switch(position){
                    case "Chef":
//                        int ID = employeeScanner.nextInt();
//                        String firstName = employeeScanner.next();
//                        String lastName = employeeScanner.next();
//                        double salary = employeeScanner.nextDouble();
                        double bonus = employeeScanner.nextDouble();
                        boolean bonusAssigned = employeeScanner.hasNextBoolean();

                        employees.add(new Chef(ID, firstName, lastName, salary, position, bonus, bonusAssigned));
                        break;

                    case "Commission worker":
//                        ID = employeeScanner.nextInt();
//                        firstName = employeeScanner.next();
//                        lastName = employeeScanner.next();
//                        salary = employeeScanner.nextDouble();
//                        int amountOfCommissions = scanner.nextInt();
                        System.out.println(scanner.next());
//
//                        employees.add(new CommissionWorker(ID, firstName, lastName, salary, position, amountOfCommissions));
                        break;

                    case "Hour worker":
//                        ID = employeeScanner.nextInt();
//                        firstName = employeeScanner.next();
//                        lastName = employeeScanner.next();
//                        salary = employeeScanner.nextDouble();
                        int hoursWorked = employeeScanner.nextInt();

                        employees.add(new HourWorker(ID, firstName, lastName, salary, position, hoursWorked));
                        break;

                    case "Piece worker":
//                        ID = employeeScanner.nextInt();
//                        firstName = employeeScanner.next();
//                        lastName = employeeScanner.next();
//                        salary = employeeScanner.nextDouble();
                        int amountOfPieces = employeeScanner.nextInt();

                        employees.add(new PieceWorker(ID, firstName, lastName, salary, position, amountOfPieces));
                        break;
                }
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
