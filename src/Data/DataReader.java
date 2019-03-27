package Data;

import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DataReader {

    public void readDataFromTextfile(File file, ArrayList<Employee> employees){

        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        while(scanner.hasNextLine()){
            Scanner employeeScanner = new Scanner(scanner.nextLine());
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

//
//        for (Employee employee : employees){
//            System.out.println(employee.getReaderString());
//            printWriter.println(employee.getReaderString());
//        }


    }

    public void readDataFromObjectfile(File file, ArrayList<Employee> employees){

    }

    public void saveDataToObjectfile(String filename, ArrayList<Employee> employees){

    }
}
