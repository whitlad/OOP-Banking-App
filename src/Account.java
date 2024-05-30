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
    public static int NEXT_ACCOUNT_NUMBER = 1;
    private int number;
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
        this.number = Account.NEXT_ACCOUNT_NUMBER;
        NEXT_ACCOUNT_NUMBER++;
    }

    /**
     * Returns the customer who owns this account
     * @return the customer who owns this account (associated)
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * Returns the unique account number
     * @return the unique account number
     */
    public int getNumber(){
        return this.number;
    }

    /**
     * Checks if the account is active
     * @return true if account is active, false if not active
     */
    public boolean isActive()
    {
        return this.active;
    }
    /**
     * Activates the account and records the date account was activated
     */
    public void activate() {
        this.active = true;
        this.dateActivated = LocalDate.now();
    }
    /**
     * deactivates the account and records the date account was deactivated
     */
    public void deactivate()
    {
        this.active =false;
        this.dateClosed=LocalDate.now();
    }
    /**
     * returns the date on which the account was activated as a String
     * @return the date on which the account was activated as a String
     */
    public String getDateActivated()
    {
        String date;
        if (this.dateActivated != null) {
            date = this.dateActivated.toString();
        }
        else {
            date = "The Account has not been activated";
        }
        return date;
    }
    /**
     * Returns the date on which the account was deactivated as a String
     * @return the date on which the account was deactivated as a String
     */
    public String getDateDeactivated()
    {
        String date;
        if(this.dateActivated == null)
        {
            date = "The Account has not been activated";
        }
        else if (this.dateActivated != null && this.dateClosed == null)
        {
            date = "the Account is still active";
        }
        else
        {
            date = this.dateClosed.toString();
        }
        return date;
    }

    /**
     * Returns the current balance of the account
     * @return the current balance of the account
     */
    public int getBalance()
    {
        return this.balance;
    }

    /**
     * Adds the specified amount to the account balance.
     * @param numBalance the amount to add to the account balance
     */
    public void addBalance(int numBalance)
    {
        this.balance+=numBalance;
    }

    /**
     * Uses the specified amount from the account balance if sufficient funds available
     * @param numBalance the amount to ue from the account balance
     */
    public void useBalance(int numBalance)
    {
        if (numBalance <= this.balance)
        {
            this.balance -= numBalance;
        }
    }

    /**
     * Returns the number of transactions associated with this acocunt.
     * @return the number of transactions
     */
    public int numberOfTransactions()
    {
        return this.transactions.size();
    }
    /**
     * Adds a transaction to the account's transaction set
     * @param t the transaction to add
     */
    public void addTransaction(Transaction t)
    {
        this.transactions.add(t);
    }

    /**
     * Displays the details of the account, including customer number, balance, status and relevant dates.
     */

    public void displayDetails()
    {
        String status;
        String date;
        if(this.isActive())
        {
            status= " Account Active ";
            date = this.getDateActivated();
        }
        else
        {
            status = "Account Closed ";
            date = this.getDateDeactivated();
        }
        System.out.println(this.customer.getNumber() + "Balance: " + this.getBalance() + " , " + status + ", " + date);
    }

    /**
     * Displays the details of all transactions associated with this account
     */
    public void showTransactions()
    {
        System.out.println("Type\tBalance\tDate/Time\tID");
        for(Transaction t: this.transactions)
        {
            t.showDetails();
        }
    }


}

