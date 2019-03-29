package Data;

public class SalaryCalculation extends Employee{

    private int ID;
    private String lastName;
    private double salary;

    public SalaryCalculation(int ID, String lastName, double salary) {
        this.ID = ID;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
