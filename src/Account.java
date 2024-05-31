import java.time.LocalDate;
import java.util.HashSet;

/***
 * Represents an abstract bank account
 * Each account has a unique account number, balance, activation status, activation date,
 * closure date, customer who owns the account, and set of transactions.
 *
 * @Author Dawn Whitla
 * @Version 24/05/2024
 */
public abstract class Account {
    public static int NEXT_ACCOUNT_NUMBER = 1000; //starting number of first account opened
    private int accountNumber;
    private int balance;
    private boolean active; //is it open
    private LocalDate dateActivated; //when opened
    private LocalDate dateClosed;//when closed
    private Customer customer;
    private HashSet<Transaction> transactions;

    /**
     * Constructs a new Account with the specified customer
     * Initialises the account with a balance of 0, inactive status, and no activation or closure date
     * @param aCustomer the customer who owns this account
     */
    public Account(Customer aCustomer) {
        this.customer = aCustomer;
        this.balance = 0;
        this.active = false;
        this.dateActivated = null;
        this.dateClosed = null;
        this.transactions = new HashSet<>();
        this.accountNumber = Account.NEXT_ACCOUNT_NUMBER++;
    }

    /// check out the savings accounts
    public abstract void addBalance(int numBalance);

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
                ", Balance: " + balance +
                ", Active: " + active +
                ", Date Activated: " + (dateActivated != null ? dateActivated : "N/A") +
                ", Date Closed: " + (dateClosed != null ? dateClosed : "N/A") +
                ", Customer ID: " + customer.getCustomerID();
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public double getBalance() {
        return balance;
    }

    public void useBalance(int amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public void showTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void deactivate() {
        this.active = false;
        this.dateClosed = LocalDate.now();
    }

    public void displayDetails() {
        System.out.println(this.toString());
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public Customer getCustomer() {
        return this.customer;
    }
}
