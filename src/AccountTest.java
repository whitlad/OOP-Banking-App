import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
  * Test class for the Account class.
 * This class contains unit tests for the showTransactions method in the Account class.
 *
 * @Author Dawn Whitla
 * @Version 01/06/2024
 */
class AccountTest {  //just test the account creation and transactions code
    /**
     * Sets up a new Account object and some transactions
     */
    Account account = new CurrentAccount(new Customer("Gerard", "Butler", "123 Holywood St", "123345", "1234567890", "11-11-1969"));
Transaction transaction1 = new Transaction(TransactionType.DEPOSIT, 100);
Transaction transaction2 = new Transaction(TransactionType.WITHDRAWAL, 50);


    /**
     * Tests the showTransactions method.
     */
    @Test
    void showTransactions() {
        // Capture the showTransactions output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        account.showTransactions();

        String actualOutput = outContent.toString().trim(); // Remove any trailing new lines or spaces
        String expectedOutput = transaction1.toString() + "\n" + transaction2.toString();
        
        assertEquals(expectedOutput, actualOutput);

    }


}