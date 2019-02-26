package Data;

public class PieceWorker extends Employee {

    public int amountOfPieces;

    public PieceWorker(int ID, String firstName, String lastName, double salary, String position, int amountOfPieces) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
        this.amountOfPieces = amountOfPieces;
    }

    public double getMonthlySalary(){
        double monthlySalary = this.salary + (5 * this.amountOfPieces);
        return monthlySalary;
    }
}
