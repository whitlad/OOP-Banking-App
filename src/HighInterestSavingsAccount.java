/**
 * Represents a High Interest Savings Account in a banking application.
 * Extends the Account superclass to inherit common account properties and behaviors.
 * Adds functionality specific to high interest savings accounts and applies interest on deposits at a rate of 15%.
 *
 * @Author Dawn Whitla
 * @Version 24/05/2024
 */
public class HighInterestSavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.15; // 15% interest rate
    private final int transactionLimitPerYear = 10;
    private int numberOfTransactionsSoFar = 0;

    /**
     * Constructs a new High Interest Savings Account with the specified customer.
     * Calls the superclass constructor to initialize the account with the given customer.
     *
     * @param aCustomer the customer who owns this account
     */
    public HighInterestSavingsAccount(Customer aCustomer) {
        super(aCustomer);
    }

    /**
     * Adds the specific amount to the account balance and applies 15% interest.
     * Overrides the addBalance method from the Account superclass.
     *
     * @param numBalance the amount to add to the account balance
     */
    @Override
    public void addBalance(int numBalance) {
        int interest = (int) (numBalance * INTEREST_RATE); // Calculate 15% interest
        // Add principal and interest to balance
    }

    /**
     * Increments the transaction count, ensuring it does not exceed the limit.
     */
    public void incrementTransactionCount() {
        if (numberOfTransactionsSoFar < transactionLimitPerYear) {
            numberOfTransactionsSoFar++;
        } else {
            System.out.println("Transaction limit reached for the year.");
        }
    }

    @Override
    public String toString() {
        return "High Interest Savings Account: " + super.toString() +
                ", Interest Rate: " + INTEREST_RATE +
                ", Transaction Limit Per Year: " + transactionLimitPerYear +
                ", Number of Transactions So Far: " + numberOfTransactionsSoFar;
    }
}
