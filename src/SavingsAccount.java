/**
 * Represents a Savings Account in a banking application
 * Extends the Account superclass to inherit common account properties and behaviours.
 * Adds functionality specific to savings accounts and applies interest on deposits at a
 * rate of 5 % for savings accounts
 *
 * @Author Dawn Whitla
 * @Version 24/05/2024
 */
public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.05; //5% interest rate

    /**
     * Constructs a new SavingsAccount with the specified customer.
     * Calls the superclass constructor to initialise the account with the given customer.
     *
     * @param aCustomer the customer who owns this account
     */
    public SavingsAccount(Customer aCustomer) {
        super(aCustomer);
    }

    /**
     * Adds the specific amount to the account balance and applies 5% interest
     * Overides the addBalance method from the Account superclass.
     *
     * @param numBalance the amount to add to the account balance
     */

    @Override   /// check out the savings accounts
    public void addBalance(int numBalance) {
        //alternative way to set the interest rate in the class, so it can be easily changed
        // int interestRate = numBalance / 100 * 5; //5 percent calculation
        //super.addBalance(numBalance + interestRate);

        int interest = (int) (numBalance * INTEREST_RATE); //calculate 5% interest
        //add principal interest to balance
    }

    @Override
    public String toString() {
        return "Savings Account: " + super.toString() + ", Interest Rate: " + INTEREST_RATE;
    }
}
