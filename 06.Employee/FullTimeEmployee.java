import java.util.Date;

public class FullTimeEmployee extends Employee {

    protected double baseSalary;
    protected double perfBonus;
    protected String role;

    public FullTimeEmployee(String name, String panNo, Date joiningDate,
                            String designation, int empId,
                            double baseSalary, double perfBonus, String role)
            throws InvalidSalaryException {

        super(name, panNo, joiningDate, designation, empId);

        if (baseSalary < 0 || perfBonus < 0) {
            throw new InvalidSalaryException("Salary or bonus cannot be negative!");
        }

        this.baseSalary = baseSalary;
        this.perfBonus = perfBonus;
        this.role = role;
    }

    @Override
    public double calcCTC() {
        if (role.equalsIgnoreCase("SWE")) {
            return baseSalary + perfBonus;
        } else if (role.equalsIgnoreCase("HR")) {
            return baseSalary + (0.1 * baseSalary); // hiring commission
        }
        return baseSalary;
    }
}