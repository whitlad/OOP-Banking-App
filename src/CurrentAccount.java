/**
 * Represents a Current Account in a banking application
 * Extends the Account superclass to inherit common account properties and behaviours.
 *
 * @Author Dawn Whitla
 * @Version 24/05/2024
 */
public class CurrentAccount extends Account {
    /**
     * Constructs a new Current Account with the specified customer.
     * Calls the superclass constructor to initialise the account with the given customer.
     *
     * @param aCustomer the customer who owns this account
     */
    public CurrentAccount(Customer aCustomer) {
        super(aCustomer);
    }

    @Override
    public void addBalance(int numBalance) {

    }

    @Override
    public String toString() {
        return "Current Account: " + super.toString();
    }
}

