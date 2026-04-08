import java.util.ArrayList;

public class BankService {

    public static void displayCustomerAccounts(ArrayList<Customer> customers, ArrayList<Account> accounts) {

        for (Customer cust : customers) {
            System.out.println("\n==== CUSTOMER DETAILS ====");
            cust.displayCustomer();

            double totalBalance = 0;
            int count = 0;

            System.out.println("---- ACCOUNTS ----");

            for (Account acc : accounts) {
                if (acc.customer.customerID.equals(cust.customerID)) {
                    acc.displayAccount();
                    totalBalance += acc.balance;
                    count++;
                }
            }

            System.out.println("Total Accounts: " + count);
            System.out.println("Total Balance: " + totalBalance);
        }
    }
}