/**
 * Represents a High Interest Savings Account in a banking application
 * Extends the Account superclass to inherit common account properties and behaviours.
 *Adds functionality specific to savings accounts and applies interest on deposits at a
 * rate of 15 % for high interest savings accounts
 *
 * @Author Dawn Whitla
 * @Version 24/05/2024
 */    public class HighInterestSavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.15; //15% interest rate
    /**
     * Constructs a new High Interest Savings Account with the specified customer.
     * Calls the superclass constructor to initialise the account with the given customer.
     *
     * @param aCustomer the customer who owns this account
     */
    public HighInterestSavingsAccount(Customer aCustomer)
    {

        super(aCustomer);
    }
    /**
     *
     * Adds the specific amount to the account balance and applies 15% interest
     * Overides the addBalance method from the Account superclass.
     *
     * @param numBalance the amount to add to the account balance
     */
    @Override   /// check out the savings accounts
    public void addBalance (int numBalance)
    {
        //change this method to a simpler version with a final variable INTEREST_RATE
        //int interestRate = numBalance / 100 * 20; //20 percent calculation
        //super.addBalance(numBalance + interestRate); //adds interest rate to balance of account

        int interest = (int)(numBalance * INTEREST_RATE); //calculate 5% interest
        super.addBalance(numBalance + interest);//add principal interest to balance

    }
}
