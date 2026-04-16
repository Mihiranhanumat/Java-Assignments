public class SavingsAccount extends Account {

    private double minBalance = 500;

    public SavingsAccount(int accountNumber, double balance, Customer customer) {
        super(accountNumber, balance, customer);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance - amount < minBalance) {
            throw new InsufficientBalanceException("Minimum balance 500 required");
        }
        balance -= amount;
        System.out.println("Savings Withdrawal: " + amount);
    }
}