import java.util.Date;

public abstract class Employee {
    protected String name;
    protected String panNo;
    protected Date joiningDate;
    protected String designation;
    protected int empId;

    public Employee(String name, String panNo, Date joiningDate,
                    String designation, int empId) {
        this.name = name;
        this.panNo = panNo;
        this.joiningDate = joiningDate;
        this.designation = designation;
        this.empId = empId;
    }

    // Abstract Method
    public abstract double calcCTC();

    public void display() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Name: " + name);
        System.out.println("PAN: " + panNo);
        System.out.println("Designation: " + designation);
        System.out.println("Employee ID: " + empId);
    }
}