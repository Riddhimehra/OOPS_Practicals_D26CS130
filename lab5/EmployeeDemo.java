abstract class Employee {
    String name;
    int id;

    abstract double monthlySalary();

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Parttime extends Employee {
    private int hour;
    private double rate;

    Parttime(String name, int id, int hour, double rate) {
        super(name, id);
        this.hour = hour;
        this.rate = rate;
    }

    double monthlySalary() {
        return (hour * rate);
    }

}

class FullTime extends Employee {
    private double fixed;

    FullTime(String name, int id, double fixed) {
        super(name, id);
        this.fixed = fixed;
    }

    double monthlySalary() {
        return fixed;
    }
}

class Interns extends Employee {
    private double stipend;

    Interns(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    double monthlySalary() {
        return stipend;
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee[] employees = {new Parttime("krishna", 1, 4, 5000), new FullTime("ayushi", 2, 5000), new Interns("harvi", 3, 5000)};

        double total=0;
        String label = "";

        for (Employee e : employees) {
            label = e.getClass().getSimpleName();
        
            if (e instanceof Interns) {
                System.out.println("Only for Interns");
                System.out.println("Name:-" + e.name + " Id:- "+ e.id +" and Salary: " + e.monthlySalary());
            }
            else{
                System.out.println("Name:-" + e.name + " Id:- "+ e.id +" Salary of " + label + "is:- " + e.monthlySalary());
            }
        
            total += e.monthlySalary();
        }
    }
}