public class LoanAccount extends Account {

    private double loanAmount;

    public LoanAccount(int accountNumber, double balance, Customer customer, double loanAmount) {
        super(accountNumber, balance, customer);
        this.loanAmount = loanAmount;
    }

    @Override
    public void deposit(double amount) {
        loanAmount -= amount;
        System.out.println("Loan repaid: " + amount);
        System.out.println("Remaining Loan: " + loanAmount);
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawal not allowed from Loan Account");
    }
}