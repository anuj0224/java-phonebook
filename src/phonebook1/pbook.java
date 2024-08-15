package phonebook1;
import java.util.ArrayList;
import java.util.Scanner;

class contact{
    int contactId;
    String contactName;
    String phoneNumber;
    
    public contact(int contactId,String contactName,String phoneNumber){
        this.contactId= contactId;
        this.contactName = contactName;
        this.phoneNumber= phoneNumber;
    }
    
    public int getContactId(){
        return contactId;
    }
    public String getContactName(){
        return contactName;
    }
    public String getphoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    } 
    public String toString(){
        return "ID : "+contactId+" Name : "+contactName+" Phone : "+phoneNumber;
    }
}
class PhoneBook{
    private ArrayList<contact> contacts;
    public PhoneBook (){
        contacts = new ArrayList<>();
    }
    public void addContact(contact contact){
        contacts.add(contact);
    }
    public void removeContact (int contactId){
        contacts.removeIf (contact -> contact.getContactId()==contactId);
    }
    public void modifyContact (int contactId,String newPhoneNumber){
        for (contact contact : contacts){
            if (contact.getContactId()== contactId){
                contact.setPhoneNumber(newPhoneNumber);
            break;
            }
        }
    }
    public void showContacts(){
        System.out.println("PhoneBook Contacts:");
        for(contact contact: contacts){
            System.out.println(contact);
        }
    }   
}

public class pbook {

    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        Scanner s1 = new Scanner(System.in);
        while (true) {
            System.out.println("Phone Book");
            System.out.println("1.Add Contact");
            System.out.println("2.Remove Contact");
            System.out.println("3. Modify Contact");
            System.out.println("4.Show Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice:");
            int choice = s1.nextInt();
            
            
            switch (choice){
                case 1:
                    System.out.print("Enter Contact ID: ");
                    int contactId = s1.nextInt ();
                    s1.nextLine();
                    System.out.print("Enter Contact Name: ");
                    String contactName = s1.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = s1.nextLine();
                    contact newContact = new contact(contactId,contactName,phoneNumber);                
                    pb.addContact (newContact);
                    break;
                case 2:
                    System.out.print("Enter Contact ID to Remove: ");
                    int removeId = s1.nextInt();
                    pb.removeContact (removeId);
                    break;
                case 3:
                    System.out.print("Enter Contact ID to Modify: ");
                    int modifyId = s1.nextInt();
                    s1.nextLine(); // Consume newline
                    System.out.print("Enter New Phone Number: ");
                    String newPhoneNumber = s1.nextLine();
                    pb.modifyContact(modifyId , newPhoneNumber);
                    break;
                case 4:
                    pb.showContacts();
                    break;
                case 5:
                    System.out.println("Existing....");
                    s1.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice....");
            }
        }
    }
}