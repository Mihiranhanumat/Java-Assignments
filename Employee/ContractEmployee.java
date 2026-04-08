import java.util.Date;

public class ContractEmployee extends Employee {

    private int noOfHours;
    private double hourlyRate;

    public ContractEmployee(String name, String panNo, Date joiningDate,
                            String designation, int empId,
                            int noOfHours, double hourlyRate)
            throws InvalidSalaryException {

        super(name, panNo, joiningDate, designation, empId);

        if (noOfHours < 0 || hourlyRate < 0) {
            throw new InvalidSalaryException("Invalid hours or rate!");
        }

        this.noOfHours = noOfHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calcCTC() {
        return noOfHours * hourlyRate;
    }
}