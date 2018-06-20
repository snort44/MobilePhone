import java.util.ArrayList;

public class Logic {

    private static ArrayList<Contacts> mobileContacts = new ArrayList<Contacts>();

    public static void addToContacts(String name, String number) {
        if(getContactIndex(name) == -1) mobileContacts.add( new Contacts(name, number));
        else System.out.println(name + " already in the list");
    }

    public static void printContactList() {
        for(int i = 0; i< mobileContacts.size(); i++) {
            System.out.println(i + ":  Name: " + mobileContacts.get(i).getName() + "  Number: " + mobileContacts.get(i).getNumber());
        }
    }

    public static int getContactIndex(String contactToSearch) {
        for(int i= 0; i< mobileContacts.size(); i++) {
            if(contactToSearch.equals(mobileContacts.get(i).getName())) return i;
        }
        System.out.println(contactToSearch + " is NOT in the Contact(s) list");
        return -1;
    }

    public static void printContact(String contact) {
        int index = getContactIndex(contact);
        if(index != -1)
            System.out.println(index + ":  Name: " + mobileContacts.get(index).getName() + "  Number: " + mobileContacts.get(index).getNumber());
    }

    public static void removeContactFromList(String contact) {
        if(getContactIndex(contact) != -1)
            mobileContacts.remove(getContactIndex(contact));
    }

    public static void updateContactList(String existingContact, String updatedContact, String updatedPhone) {
        int index = getContactIndex(existingContact);
        int doesUpdatedContactExhist = getContactIndex(updatedContact);
        if(index != -1 && doesUpdatedContactExhist == -1)
            mobileContacts.set(index, new Contacts(updatedContact, updatedPhone));
        else System.out.println("The contact already exhists.  Please update if you want to change the contact");
        printContact(updatedContact);
    }

}
