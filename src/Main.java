import Data.Chef;
import Data.CommissionWorker;
import Data.HourWorker;
import Data.PieceWorker;

import static javafx.application.Application.launch;

public class Main {

    public static void main(String [] args){
        CommissionWorker commissionWorker = new CommissionWorker(123,"Jeff", "Hanneman", 2000.0, "commisioner", 0);
        Chef chef = new Chef(456, "Tom", "Araya", 3000, "chef", 500, false);
        HourWorker hourWorker = new HourWorker(678,"Dave", "Lombardo",5,"hourwoeker", 20);
        PieceWorker pieceWorker = new PieceWorker(901, "Kerry", "King", 10, "piecer", 10);

        System.out.println(chef.toString());
        System.out.println();
        System.out.println(commissionWorker.toString());
        System.out.println();
        System.out.println(hourWorker.toString());
        System.out.println();
        System.out.println(pieceWorker.toString());

        //launch(GUI.GUI.class);
    }
}
