package Data;

import java.time.LocalDate;

public class Chef extends Employee {

    public double bonus;
    public boolean assignedBonus;

    public Chef(int ID, String firstName, String lastName, double salary, String position, double bonus, Boolean assignedBonus) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
        this.bonus = bonus;
        this.assignedBonus = assignedBonus;
    }

    public double getMonthlySalary(){
        double monthlySalary;
        if(this.assignedBonus){
            monthlySalary = this.salary + this.bonus;
        } else {
            monthlySalary = this.salary;
        }
        return monthlySalary;
    }


}
