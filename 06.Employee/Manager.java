import java.util.Date;

public class Manager extends FullTimeEmployee {

    private double travelAllowance;
    private double educationAllowance;

    public Manager(String name, String panNo, Date joiningDate,
                   String designation, int empId,
                   double baseSalary, double perfBonus, String role,
                   double travelAllowance, double educationAllowance)
            throws InvalidSalaryException {

        super(name, panNo, joiningDate, designation, empId,
              baseSalary, perfBonus, role);

        if (travelAllowance < 0 || educationAllowance < 0) {
            throw new InvalidSalaryException("Allowances cannot be negative!");
        }

        this.travelAllowance = travelAllowance;
        this.educationAllowance = educationAllowance;
    }

    @Override
    public double calcCTC() {
        return baseSalary + perfBonus + travelAllowance + educationAllowance;
    }
}