import java.time.LocalDate;


/**
 * Provides a user interface for the Banking Application.
 * Handles interactions with the user through a simple menu system.
 * Users can create customers, update customer information, display customer details,
 * manage bank accounts, and handle transactions.
 *
 * @Author Dawn Whitla
 * @version 24/05/2024
 */
public class UserInterface {

    // Use public for testing and change to private when finished
    private InputReader reader;
    private Bank bank; // Main bank object

    /**
     * Constructs a new UserInterface and initializes the InputReader and Bank.
     */
    public UserInterface() {
        reader = new InputReader();
        bank = new Bank();
    }

    /**
     * Shows the main menu for the application until the user chooses to quit.
     */
    public void showMainMenu() {
        boolean quit = false;

        while (!quit) {
            System.out.println("\n*********************************" +
                    "           \nWelcome to Kilmaine Credit Union" +
                    "\n*********************************");
            System.out.println("Please choose an option: ");
            System.out.println("1. Create Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Display Customer Details");
            System.out.println("4. Open Bank Account");
            System.out.println("5. Close Bank Account");
            System.out.println("6. Deposit to Account");
            System.out.println("7. Withdraw from Account");
            System.out.println("8. Display All Customers");
            System.out.println("9. Display All Customers and Associated Accounts");
            System.out.println("10. Display Transactions on Account");
            System.out.println("0. Exit");
            System.out.println("-------------------------------------------------");

            String userInput = reader.getInput();

            switch (userInput) {
                case "1":
                    createCustomer();
                    break;
                case "2":
                    updateCustomer();
                    break;
                case "3":
                    displayCustomerDetails();
                    break;
                case "4":
                    openBankAccount();
                    break;
                case "5":
                    closeBankAccount();
                    break;
                case "6":
                    depositToAccount();
                    break;
                case "7":
                    withdrawFromAccount();
                    break;
                case "8":
                    displayAllCustomers();
                    break;
                case "9":
                    displayCustomerAndAccounts();
                    break;
                case "10":
                    displayTransactionsOnAccount();
                    break;
                case "0":
                    quit = true;
                    System.out.println("********************************\n" +
                            "Exiting application. Thank you.\n" + "********************************\n");
                    break;
                default:
                    System.out.println("That is not a valid choice, please try again.\n");
                    break;
            }
        }
    }

    /**
     * Allows a user to create a new customer.
     */
    private void createCustomer() {
        System.out.println("Please enter first name:");
        String firstName = reader.getInput();

        System.out.println("Please enter last name:");
        String lastName = reader.getInput();

        System.out.println("Please enter address:");
        String address = reader.getInput();

        System.out.println("Please enter postcode:");
        String postcode = reader.getInput();

        System.out.println("Please enter phone number:");
        String phoneNumber = reader.getInput();

        System.out.println("Please enter date of birth (DD-MM-YYYY):");
        String dateOfBirth = reader.getInput();

        Customer customer = new Customer(firstName, lastName, address, postcode, phoneNumber, dateOfBirth);
        bank.addCustomer(customer);
        System.out.println("**** New customer added ****\n" + customer);
    }

    /**
     * Allows a user to update existing customer information.
     */
    private void updateCustomer() {
        System.out.println("Please enter customer ID to update:");
        int customerId = Integer.parseInt(reader.getInput());

        Customer customer = bank.getCustomerByNumber(customerId);
        if (customer != null) {
            System.out.println("Please enter new first name:");
            String firstName = reader.getInput();
            System.out.println("Please enter new last name:");
            String lastName = reader.getInput();

            customer.setFirstName(firstName);
            customer.setLastName(lastName);

            System.out.println("****** Customer details updated ******\n" + customer);
        } else {
            System.out.println("***************** Customer not found. *****************");
        }
    }

    /**
     * Displays details of a specific customer.
     */
    private void displayCustomerDetails() {
        System.out.println("Please enter customer ID to display details:");
        int customerID = Integer.parseInt(reader.getInput());

        Customer customer = bank.getCustomerByNumber(customerID);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("***************** Customer not found. *****************");
        }
    }

    /**
     * Allows a user to open a new bank account for a customer.
     */
    private void openBankAccount() {
        System.out.println("Please enter customer ID to open an account:");
        int customerId = Integer.parseInt(reader.getInput());

        Customer customer = bank.getCustomerByNumber(customerId);
        if (customer != null) {
            System.out.println("Choose account type: 1 for Current, 2 for Savings, 3 for High Interest Savings");
            int accountType = Integer.parseInt(reader.getInput());

            Account account;
            switch (accountType) {
                case 1:
                    account = new CurrentAccount(customer);
                    break;
                case 2:
                    account = new SavingsAccount(customer);
                    break;
                case 3:
                    account = new HighInterestSavingsAccount(customer);
                    break;
                default:
                    System.out.println("Invalid account type.");
                    return;
            }
            bank.addAccount(account);
            System.out.println("****** New account opened for customer " + customer.getFirstName() + " " + customer.getLastName() + " \n" + account + "******");
        } else {
            System.out.println("Customer not found.");
        }
    }

    /**
     * Allows a user to close an existing bank account.
     */
    private void closeBankAccount() {
        System.out.println("Please enter account number to close:");
        int accountNumber = Integer.parseInt(reader.getInput());

        Account account = bank.getAccountByNumber(accountNumber);
        if (account != null) {
            account.deactivate();
            Customer customer = account.getCustomer();  // Get the customer associated with the account
            System.out.println("Account " + accountNumber + " closed for Customer ID: " + customer.getCustomerID() + ", Name: " + customer.getFirstName() + " " + customer.getLastName() + ".");
        } else {
            System.out.println("Account not found.");
        }
    }

    /**
     * Allows a user to deposit money into an account.
     */
    private void depositToAccount() {
        System.out.println("Please enter account number to deposit to:");
        int accountNumber = Integer.parseInt(reader.getInput());

        Account account = bank.getAccountByNumber(accountNumber);
        if (account != null) {
            Customer customer = account.getCustomer();
            System.out.println("Please enter amount to deposit:");
            int amount = Integer.parseInt(reader.getInput());

            account.addBalance(amount);
            account.addTransaction(new Transaction(TransactionType.DEPOSIT, amount));
            System.out.println("Deposited " + amount + " to account "+ accountNumber + " " + "Customer ID: "  + customer.getCustomerID() +
                    "\nName: " + customer.getFirstName() + " " + customer.getLastName() +" " + "Updated Balance: " + (account.getBalance + amount));  //will this add the deposit to the balance
        } else {
            System.out.println("Account not found.");
        }
    }

    /**
     * Allows a user to withdraw money from an account.
     */
    private void withdrawFromAccount() {
        System.out.println("Please enter account number to withdraw from:");
        int accountNumber = Integer.parseInt(reader.getInput());

        Account account = bank.getAccountByNumber(accountNumber);
        if (account != null) {
            System.out.println("Please enter amount to withdraw:");
            int amount = Integer.parseInt(reader.getInput());

            if (amount <= account.getBalance()) {
                account.useBalance(amount);
                account.addTransaction(new Transaction(TransactionType.WITHDRAWAL, amount));
                System.out.println("Withdrew " + amount + " from account " + accountNumber);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    /**
     * Displays a list of all customers.
     */
    private void displayAllCustomers() {
        for (Customer customer : bank.getCustomers()) {
            System.out.println(customer);
        }
    }

    /**
     * Displays all customers and their associated accounts.
     */
    private void displayCustomerAndAccounts() {
        for (Customer customer : bank.getCustomers()) {
            System.out.println(customer);
            for (Account account : customer.getAccounts()) {
                System.out.println("  " + account);
            }
        }
    }

    /**
     * Displays transactions for a specific account.
     */
    private void displayTransactionsOnAccount() {
        System.out.println("Please enter account number to display transactions:");
        int accountNumber = Integer.parseInt(reader.getInput());

        Account account = bank.getAccountByNumber(accountNumber);
        if (account != null) {
            account.showTransactions();
        } else {
            System.out.println("Account not found.");
        }
    }
}