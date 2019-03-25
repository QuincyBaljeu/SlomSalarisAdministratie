package Data;

import java.io.File;
import java.io.FileNotFoundException;
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


    public void saveDataToTextfile(){

    }

    public void readDataFromObjectfile(File file, ArrayList<Employee> employees){

    }

    public void saveDataToObjectfile(){
        
    }
}
