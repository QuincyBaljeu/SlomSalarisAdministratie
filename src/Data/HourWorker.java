package Data;

public class HourWorker extends Employee {

    public int hoursWorked;

    public HourWorker(int ID, String firstName, String lastName, double salary, String position, int hoursWorked) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
        this.hoursWorked = hoursWorked;
    }

    public double getMonthlySalary(){
        double monthlySalary = this.hoursWorked * salary;
        return monthlySalary;
    }
}
