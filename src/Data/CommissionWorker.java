package Data;

public class CommissionWorker extends Employee {

    protected int amountOfCommissions;

    public CommissionWorker(int ID, String firstName, String lastName, double salary, String position, int amountOfCommissions) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
        this.amountOfCommissions = amountOfCommissions;
        this.monthlySalary = getMonthlySalary();
    }

    @Override
    public String getReaderString(){
        return super.getReaderString() + "#" + this.amountOfCommissions;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Amount of commissions: " + this.amountOfCommissions;
    }

    @Override
    public double getMonthlySalary() {
        double bonus = Math.floor((amountOfCommissions / 100)) * (0.10 * salary);
        double monthSalary = salary + bonus;
        return monthSalary;
    }
}
