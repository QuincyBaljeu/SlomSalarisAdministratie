package Data;

public class Chef extends Employee {

    protected double bonus;
    protected boolean bonusAssigned;

    public Chef(int ID, String firstName, String lastName, double salary, String position, double bonus, Boolean bonusAssigned) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
        this.bonus = bonus;
        this.bonusAssigned = bonusAssigned;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Bonus: " + this.bonus + "\n"
                + "Bonus assigned: " + this.bonusAssigned;
    }

    public double getMonthlySalary() {
        double monthlySalary;
        if (this.bonusAssigned) {
            monthlySalary = this.salary + this.bonus;
        } else {
            monthlySalary = this.salary;
        }
        return monthlySalary;
    }


}
