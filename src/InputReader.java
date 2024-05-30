import java.util.Scanner;

/**
 * A util class to read user input from the command line
 * Handles user input for the banking application
 *
 * @Author Dawn Whitla
 * @Version 24/05/2024
 */

public class InputReader {
    private Scanner scanner;

    /**
     * *Constructs a new InputReader
     */
    public InputReader(){
        scanner = new Scanner(System.in); //system in users input
    }

    /**
     * Returns the line of input entered by the user at the command line
     * @return the line of input entered by the user at the command line as a string
     */
    public String getInput() {
        return scanner.nextLine();
    }
    /**
     * Closes the scanner resource
     */
    public void close(){
        scanner.close();
    }


}
