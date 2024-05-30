import java.time.LocalDateTime;

/**
 * Represents a transaction in the banking application
 * A transaction is associated with an account and can be either a deposit or withdrawal to the account
 * @Author Dawn Whitla
 * @Version 24/05/2024
 */
public class Transaction {
    private static int NEXT_TRANSACTION_ID = 1;
    private int id;
    private int amount;
    private LocalDateTime dateTime;
    private TransactionType type;

    /**
     * Constructs a new Transaction with the specified type and amount
     * The transaction date and time is set to the current date and time LocalDateTime
     *
     * @param aType the type of transaction (Deposit or Withdrawal)
     * @param numAmount the amount of the transaction
     */
    public Transaction(TransactionType aType, int numAmount)
    {
        this.type = aType;
        this.amount = numAmount;
        this.dateTime = LocalDateTime.now();  //creates the time and date to now
        this.id=NEXT_TRANSACTION_ID; //increases the transaction ID by 1 each time
        NEXT_TRANSACTION_ID++;
    }

    /**
     * Returns the ID of the transaction
     * @return the transaction ID
     */
    public int getId()
    {
        return this.id;
    }

    /**
     * Returns the amount of the transaction
     * @return the transaction amount
     */
    public int getAmount()
    {
        return this.amount;
    }

    /**
     * Returns the date and time of the transaction
     * @return the transaction date and time
     */
    public LocalDateTime getDateTime()
    {
        return this.dateTime;
    }

    /**
     * Returns the type of transaction
     * @return the transaction type
     */
    public TransactionType getType()
    {
        return this.type;
    }

    /**
     * Displays the details of the transaction to user
     */
    public void showDetails()
    {
        System.out.println(this.type.toString() + "\t" + this.amount+ "\t" + this.dateTime.toString() + "\t" + id);
    }
}
 