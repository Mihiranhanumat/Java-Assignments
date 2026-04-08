import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try {
            ArrayList<Customer> customers = new ArrayList<>();
            ArrayList<Account> accounts = new ArrayList<>();

            // Customers
            Customer c1 = new Customer("101", "Aarav", "aarav@gmail.com");
            Customer c2 = new Customer("102", "Meera", "meera@gmail.com");

            customers.add(c1);
            customers.add(c2);

            // Accounts
            Account a1 = new SavingsAccount(1001, 5000, c1);
            Account a2 = new LoanAccount(2001, 0, c1, 10000);
            Account a3 = new SavingsAccount(1002, 8000, c2);

            accounts.add(a1);
            accounts.add(a2);
            accounts.add(a3);

            // Transactions
            a1.deposit(1000);
            a1.withdraw(2000);

            a2.deposit(3000);

            // Display
            BankService.displayCustomerAccounts(customers, accounts);

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}