import java.util.Date;

public class Main {

    public static void main(String[] args) {

        try {
            // Full Time Employee
            FullTimeEmployee emp1 = new FullTimeEmployee(
                    "John", "ABCDE1234F", new Date(),
                    "Software Engineer", 101,
                    50000, 10000, "SWE"
            );

            // Contract Employee
            ContractEmployee emp2 = new ContractEmployee(
                    "Alice", "XYZAB5678K", new Date(),
                    "Consultant", 102,
                    160, 200
            );

            // Manager
            Manager mgr = new Manager(
                    "Bob", "LMNOP4321Z", new Date(),
                    "Project Manager", 103,
                    80000, 20000, "SWE",
                    5000, 7000
            );

            // Display + CTC
            emp1.display();
            System.out.println("CTC: " + emp1.calcCTC());

            emp2.display();
            System.out.println("CTC: " + emp2.calcCTC());

            mgr.display();
            System.out.println("CTC: " + mgr.calcCTC());

        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}