package Data;

public class CommissionWorker extends Employee {

    public int amountOfCommissions;

    public CommissionWorker(int ID, String firstName, String lastName, double salary, String position, int amountOfCommissions) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
        this.amountOfCommissions = amountOfCommissions;
    }

    public double getMonthlySalary(){
        double bonus = Math.floor((amountOfCommissions /100)) * (0.10 * salary);
        double monthlySalary = salary + bonus;
        return (double)monthlySalary;
    }
}
