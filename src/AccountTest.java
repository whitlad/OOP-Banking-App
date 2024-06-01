import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Test class for the Account class.
 * This class contains unit tests for the showTransactions method in the Account class.
 *
 * @Author Dawn Whitla
 * @Version 01/06/2024
 */
class AccountTest {  //just test the account creation and transactions code

    private Account account;
    private Transaction transaction1;
    private Transaction transaction2;

    /**
     * Sets up a new Account object and some transactions before each test.
     */
    @BeforeEach
    void setUp() {
        Customer customer = new Customer("Gerard", "Butler", "123 Holywood St", "12345", "1234567890", "11-11-1969");
        account = new CurrentAccount(customer);
        transaction1 = new Transaction(TransactionType.DEPOSIT, 100);
        transaction2 = new Transaction(TransactionType.WITHDRAWAL, 50);
        account.addTransaction(transaction1);
        account.addTransaction(transaction2);
    }

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

    }
}