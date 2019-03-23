package Data;

public abstract class Employee {

    protected int ID;
    protected String firstName;
    protected String lastName;
    protected double salary;
    protected String position;

    public String toString() {
        return "ID: " + this.ID + "\n"
                + "First name: " + this.firstName + "\n"
                + "Last name: " + this.lastName + "\n"
                + "Salary: " + this.salary + "\n"
                + "Position: " + this.salary;
    }

    public String getReaderString(){
        return this.position + "#" + this.ID + "#" + this.firstName + "#" + this.lastName + "#" + this.salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
