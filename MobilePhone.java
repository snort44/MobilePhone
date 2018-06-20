import java.util.Scanner;

public class MobilePhone{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        int input;
        boolean quit = false;

        while(!quit) {
            System.out.println("Please insert an option.  0 for the menu");
            while (true)
                try {
                    input = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException nfe) {
                    System.out.println("Try again: ");
                    printInstructions();
                }
            switch (input) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    quit = true;
                    break;
                case 2:
                    Logic.printContactList();
                    break;
                case 3:
                    getContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    System.out.println("Enter a name you would like to remove: ");
                    Logic.removeContactFromList(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("Print a contact name to search: ");
                    Logic.printContact(scanner.nextLine());
                    break;
                default:
                    System.out.println("Please enter a number between 0 - 6");
                    printInstructions();
            }
        }

    }

    public static void printInstructions() {
        System.out.println("0 - print menu");
        System.out.println("1 - Quit");
        System.out.println("2 - Print out the contact list");
        System.out.println("3 - Add a contact");
        System.out.println("4 - Update contact");
        System.out.println("5 - Remove contact");
        System.out.println("6 - Search cantacts");
    }

    public static void getContact() {
        System.out.println("Enter the contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the phone number: ");
        String number = scanner.nextLine();
        Logic.addToContacts(name, number);

    }

    public static void updateContact() {
        System.out.println("Enter a contact to update: ");
        String existingContact = scanner.nextLine();
        System.out.println("Enter the updated contact name: ");
        String updatedContact = scanner.nextLine();
        System.out.println("Enter an updated phone number: ");
        Logic.updateContactList(existingContact, updatedContact,  scanner.nextLine());
    }
}
