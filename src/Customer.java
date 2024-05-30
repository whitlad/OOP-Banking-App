import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/***
 * Represents a customer in a banking application.
 * Each customer has a unique customer ID, first name, last name, address, postcode, phone number, and date of birth.
 *
 * @Author Dawn Whitla
 * @Version 24/05/2024
 */
public class Customer {
    private static int NEXT_CUSTOMER_NUMBER = 1;
    private int customerID; // Customer ID number
    private String firstName; // First name of customer
    private String lastName; // Last name of customer
    private String address; // Address of customer
    private String postCode; // Postcode of customer
    private String phoneNumber; // Phone number of customer
    private String dateOfBirth; // Date of birth of customer
    private List<Account> accounts;

    /**
     * Constructs a new Customer with the specified details.
     *
     * @param firstName   the first name of the customer
     * @param lastName    the last name of the customer
     * @param address     the address of the customer
     * @param postCode    the postcode of the customer
     * @param phoneNumber the phone number of the customer
     * @param dateOfBirth the date of birth of the customer
     */
    public Customer(String firstName, String lastName, String address, String postCode, String phoneNumber, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postCode = postCode;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>();
        this.customerID = NEXT_CUSTOMER_NUMBER++;
    }

    // Overloaded constructor to create a customer with just first and last name
    public Customer(String firstName, String lastName) {
        this(firstName, lastName, "", "", "", ""); // Default values for other fields
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumber() {
        return this.customerID;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    // Setters
    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.trim().isEmpty()) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
    }

    public void setAddress(String address) {
        if (address != null && !address.trim().isEmpty()) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }
    }

    public void setPostCode(String postCode) {
        if (postCode != null && !postCode.trim().isEmpty()) {
            this.postCode = postCode;
        } else {
            throw new IllegalArgumentException("Postcode cannot be null or empty.");
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        String phoneStr = String.valueOf(phoneNumber);
        if (phoneStr.length() >= 10 && phoneStr.length() <= 15) {
            this.phoneNumber = phoneNumber;
        } else { System.out.println ("Phone number must be between 10 and 15 digits long.");
        }
    }

    /**
     * Displays the details of the customer.
     */
    public void displayDetails() {
        System.out.println(this.getNumber() + "\t" + this.getFirstName() + "\t" + this.getLastName() + "\t" + this.getAddress() + "\t" + this.getPostCode()
                + "\t" + "\t" + this.getPhoneNumber() + "\t" + this.getDateOfBirth().toString());
    }

    /**
     * Checks if this customer is equal to another object.
     * Two customers are considered equal if their customer ID numbers are the same.
     * @param obj the object to compare
     * @return true if the customers have the same ID number, false if they don't
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return customerID == customer.customerID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerID);
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerID +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nAddress: " + address +
                "\nPostcode: " + postCode +
                "\nPhone Number: " + phoneNumber +
                "\nDate of Birth: " + dateOfBirth;
    }
}
