package Data;

public class HourWorker extends Employee {

    protected int hoursWorked;

    public HourWorker(int ID, String firstName, String lastName, double salary, String position, int hoursWorked) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
        this.hoursWorked = hoursWorked;
        this.monthlySalary = getMonthlySalary();
    }

    @Override
    public String getReaderString(){
        return super.getReaderString() + "#" + this.hoursWorked;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Hours worked: " + this.hoursWorked;
    }

    @Override
    public double getMonthlySalary() {
        double monthlySalary = this.hoursWorked * salary;
        return monthlySalary;
    }

    public int getHoursWorked(){
        if(this.hoursWorked < 144){
            return this.hoursWorked;
        } else {
            return 144;
        }
    }

    public int getOvertimeHours(){
        if(this.hoursWorked < 144){
            return -1;
        } else {
            return (this.hoursWorked-144);
        }
    }
}
