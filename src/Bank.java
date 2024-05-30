import java.util.HashSet;

/**
 * Represents a Bank that manages customers, accounts, and transactions.
 *
 * @Author Dawn Whitla
 * @version 24/05/2024
 */
public class Bank {
    private HashSet<Account> accounts;
    private HashSet<Customer> customers;
    private HashSet<Transaction> transactions;

    /**
     * Constructs a new Bank with empty sets of accounts, customers, and transactions.
     */
    public Bank() {
        this.accounts = new HashSet<>();
        this.customers = new HashSet<>();
        this.transactions = new HashSet<>();
    }

    /**
     * Adds a new account to the bank.
     * @param account the account to add
     */
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    /**
     * Adds a new customer to the bank.
     * @param customer the customer to add
     */
    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    /**
     * Adds a new transaction to the bank.
     * @param transaction the transaction to add
     */
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    /**
     * Returns the number of accounts in the bank.
     * @return the number of accounts
     */
    public int numberOfAccounts() {
        return this.accounts.size();
    }

    /**
     * Returns the number of customers in the bank.
     * @return the number of customers
     */
    public int numberOfCustomers() {
        return this.customers.size();
    }

    /**
     * Returns the number of transactions in the bank.
     * @return the number of transactions
     */
    public int numberOfTransactions() {
        return this.transactions.size();
    }

    /**
     * Lists all customers in the bank.
     */
    public void listCustomers() {
        System.out.println("Customer ID\tName\tAddress\tPostcode\tPhone number\tDate of Birth");
        for (Customer customer : this.customers) {
            customer.displayDetails();
        }
    }

    /**
     * Lists all accounts in the bank.
     */
    public void listAccounts() {
        System.out.println("Customer ID\tAmount\tStatus");
        for (Account account : this.accounts) {
            account.displayDetails();
        }
    }

    /**
     * Returns a customer by their customer number.
     * @param customerNumber the customer number
     * @return the customer with the given customer number, or null if not found
     */
    public Customer getCustomerByNumber(int customerNumber) {
        for (Customer customer : this.customers) {
            if (customer.getNumber() == customerNumber) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Returns an account by its account number.
     * @param accountNumber the account number
     * @return the account with the given account number, or null if not found
     */
    public Account getAccountByNumber(int accountNumber) {
        for (Account account : this.accounts) {
            if (account.getNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
    //DAWN

    public HashSet<Customer> getCustomers() {
        return customers;
    }
}

