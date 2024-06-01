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
    private final int accountNumber;
    private final LocalDate dateActivated; //when opened
    private final Customer customer;
    private final HashSet<Transaction> transactions;
    public double getBalance;  //is this required here or elsewhere DAWN
    private int balance;
    private boolean active; //is it open
    private LocalDate dateClosed;//when closed

    /**
     * Constructs a new Account with the specified customer
     * Initialises the account with a balance of 0, inactive status, and no activation or closure date
     *
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
    public void addBalance(int numBalance) {
        this.balance += numBalance; // Ensure this line updates the balance not working yet 1st June
    }


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


    public int getBalance() {
        return this.balance;
    }

    /**
     * Uses the specified amount from the account balance if sufficient funds are available.
     *
     * @param numBalance the amount to use from the account balance
     */
    public void useBalance(int numBalance) {
        if (numBalance <= this.balance) {
            this.balance -= numBalance;
        } else {
            System.out.println("Insufficient Funds");  //error if not enough funds
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
        System.out.println(this);
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public Customer getCustomer() {
        return this.customer;
    }

}

