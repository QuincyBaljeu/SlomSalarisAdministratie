package Data;

public class PieceWorker extends Employee {

    protected int amountOfPieces;

    public PieceWorker(int ID, String firstName, String lastName, double salary, String position, int amountOfPieces) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
        this.amountOfPieces = amountOfPieces;
    }

    @Override
    public String getReaderString(){
        return super.getReaderString() + "#" + this.amountOfPieces;
    }

    @Override
    public String toString(){
        return super.toString() + "\n"
                + "Amount of pieces: " + this.amountOfPieces;
    }

    public double getMonthlySalary(){
        double monthlySalary = this.salary + (5 * this.amountOfPieces);
        return monthlySalary;
    }
}
