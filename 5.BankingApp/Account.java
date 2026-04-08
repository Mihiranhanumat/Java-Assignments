public class Account {
    protected int accountNumber;
    protected double balance;
    protected Customer customer;

    public Account(int accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    public void displayAccount() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}