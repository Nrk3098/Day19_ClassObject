package Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program!");

        // Create a new address book
        AddressBook addressBook = new AddressBook();

        // Read user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter state: ");
        String state = scanner.nextLine();
        System.out.print("Enter zip: ");
        String zip = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        // Create a new contact
        Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);

        // Add the contact to the address book
        addressBook.addContact(contact);

        System.out.println("Contact added successfully!");

        // Read user input to edit or delete contacts
        System.out.print("Enter the name of the contact to edit or delete: ");
        String contactName = scanner.nextLine();

        // Find the contact in the address book
        Contact foundContact = addressBook.findContactByName(contactName);
        if (foundContact != null) {
            System.out.println("Contact found: " + foundContact);
            System.out.print("Do you want to edit (E) or delete (D) the contact? ");
            String option = scanner.nextLine();

            if (option.equalsIgnoreCase("E")) {
                // Read user input to edit contact details
                System.out.print("Enter new address: ");
                String newAddress = scanner.nextLine();
                System.out.print("Enter new city: ");
                String newCity = scanner.nextLine();
                System.out.print("Enter new state: ");
                String newState = scanner.nextLine();
                System.out.print("Enter new zip: ");
                String newZip = scanner.nextLine();
                System.out.print("Enter new phone number: ");
                String newPhoneNumber = scanner.nextLine();
                System.out.print("Enter new email: ");
                String newEmail = scanner.nextLine();

                // Update the contact details
                foundContact.setAddress(newAddress);
                foundContact.setCity(newCity);
                foundContact.setState(newState);
                foundContact.setZip(newZip);
                foundContact.setPhoneNumber(newPhoneNumber);
                foundContact.setEmail(newEmail);

                System.out.println("Contact updated successfully!");
            } else if (option.equalsIgnoreCase("D")) {
                // Delete the contact from the address book
                addressBook.deleteContact(foundContact);
                System.out.println("Contact deleted successfully!");
            }
        } else {
            System.out.println("Contact not found!");
        }

        // Perform other address book operations as required

        // Close the scanner
        scanner.close();
    }
}

class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zip,
                   String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and Setters for the Contact fields

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void deleteContact(Contact contact) {
        contacts.remove(contact);
    }

    public Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(name) || contact.getLastName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }
}
