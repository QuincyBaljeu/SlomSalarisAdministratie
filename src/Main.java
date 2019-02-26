import Data.CommissionWorker;

import static javafx.application.Application.launch;

public class Main {

    public static void main(String [] args){
        CommissionWorker commissionWorker = new CommissionWorker(123,"karel", "anker", 2000.0, "commisioner", 0);
        System.out.println(commissionWorker.getMonthlySalary());
        //launch(GUI.GUI.class);
    }
}
