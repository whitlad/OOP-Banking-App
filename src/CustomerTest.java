import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for the Customer class.
 * This class contains unit tests for the displayDetails method in the Customer class.
 *
 * @Author Dawm Whitla
 * @Version 01/06/2024
 */
public class CustomerTest {
    /**
     * Sets up a new Customer object for testing.
     */
    Customer customer = new Customer ("Gerard", "Butler", "123 Holywood St", "12345", "1234567890", "13-11-1969");

    /**
     * Tests the displayDetails method.
     */
    @Test
    void displayDetails() {
        String expectedDetails = "First Name: Gerard\nLast Name: Butler\nAddress: 123 Holywood St\nPostcode: 12345" +
                "\nPhone Number: 1234567890\nDate of Birth: 13-11-1969";

        // Capture the displayDetails output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        customer.displayDetails();

        //Compare the captured output with the expected output

        String actualDetails = outContent.toString().trim(); //trim removes any trailing lines or spaces

        assertEquals(expectedDetails, actualDetails);

    }
}