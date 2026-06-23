import java.util.*;
import java.time.*;
import java.time.format.DateTimeParseException;
class Contact {
    private String id;
    private String name;
    private String phone;
    private String company;
    private double salary;
    private String birthday;

    public Contact(String id, String name, String phone,
                   String company, double salary, String birthday) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.company = company;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCompany() {
        return company;
    }

    public double getSalary() {
        return salary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public String toString() {
        return "ID: " + id +
               "\nName: " + name +
               "\nPhone: " + phone +
               "\nCompany: " + company +
               "\nSalary: " + salary +
               "\nBirthday: " + birthday;
    }
}
class ContactManager {

    private Contact[] contacts = new Contact[100];
    private int count = 0;
    private int nextId = 1;

    public String generateId() {
        return "C" + String.format("%04d", nextId++);
    }

    public void addContact(Contact contact) {
        contacts[count] = contact;
        count++;
    }
    
    public static boolean validPhone(String phone){
        return phone.length() == 10 && phone.charAt(0) == '0';
    }
    public static boolean validBirthday(String birthday){
        try{
            LocalDate date = LocalDate.parse(birthday);
            return !date.isAfter(LocalDate.now());
        } catch (DateTimeParseException e){
            return false;
        }
    }

    public Contact search(String key) {

        for (int i = 0; i < count; i++) {

            if (contacts[i].getName().equalsIgnoreCase(key) ||
                contacts[i].getPhone().equals(key)) {

                return contacts[i];
            }
        }

        return null;
    }

    public boolean delete(String key) {

        for (int i = 0; i < count; i++) {

            if (contacts[i].getName().equalsIgnoreCase(key) ||
                contacts[i].getPhone().equals(key)) {

                for (int j = i; j < count - 1; j++) {
                    contacts[j] = contacts[j + 1];
                }

                contacts[count - 1] = null;
                count--;

                return true;
            }
        }

        return false;
    }

    public Contact[] getContacts() {
        return contacts;
    }

    public int getCount() {
        return count;
    }
}

public class iFriendContact {
    static Scanner input = new Scanner(System.in);
    static ContactManager manager = new ContactManager();

    public static void main(String[] args) {
		while (true) {
			System.out.println("    ");
			System.out.println("    ");
            System.out.println("            /$$ /$$$$$$$$ /$$$$$$$$$ /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$     ");
            System.out.println("            |__/| $$_____/| $$__  $$/|_  $$_/| $$_____/| $$$ | $$| $$__  $$   ");
            System.out.println("             /$$| $$      | $$  \\ $$   | $$  | $$      | $$$$| $$| $$  \\ $$   ");
            System.out.println("            | $$| $$$$$   | $$$$$$$/   | $$  | $$$$$   | $$ $$ $$| $$  | $$   ");
            System.out.println("            | $$| $$__/   | $$__  $$   | $$  | $$__/   | $$  $$$$| $$  | $$   ");
            System.out.println("            | $$| $$      | $$  \\ $$   | $$  | $$      | $$\\  $$$| $$  | $$   ");
            System.out.println("            | $$| $$      | $$  | $$ /$$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/   ");
			System.out.println("             __/|__/      |__/  |__/|_______/|________/|__/  \\__/|_______/    ");
            System.out.println(" ");
			System.out.println("  _____            _             _         ____                            _                   ");
			System.out.println(" / ____|          | |           | |       / __ \\                          (_)                 ");
			System.out.println("| |     ___  _ __ | |_ __ _  ___| |_ ___ | |  | |_ __ __ _  __ _ _ __  ___ _ _______ _ __        ");
			System.out.println("| |    / _ \\| '_ \\| __/ _` |/ __| __/ __|| |  | | '__/ _` |/ _` | '_ \\/_  / |_  / _ \\ '__|   ");
			System.out.println("| |___| (_) | | | | || (_| | (__| |_\\__ \\| |__| | | | (_| | (_| | | | |/ /| |/ /  __/ |             ");
			System.out.println(" \\_____\\___/|_| |_|\\__\\__,_|\\___|\\__|___/ \\____/|_|  \\__, |\\__,_|_| |_/___|_/___\\___|_|     ");
			System.out.println("                                                      __/ |                                       ");
			System.out.println("                                                     |___/                                        ");
			System.out.println(" ");
			System.out.println("======================================================================================================");
			System.out.println(" ");
            System.out.println("[01] Add Contacts");
			System.out.println("[02] Update Contacts");
			System.out.println("[03] Delete Contacts");
			System.out.println("[04] Search Contacts");
			System.out.println("[05] List Contacts");
			System.out.println("[06] Exit");
			System.out.print("Enter an Option to continue ->");

            int option = input.nextInt();
            input.nextLine();

            switch (option) {

                case 1:
                    addContact();
                    break;
                    
				case 2:
                    updateContact();
                    break;
                    
                 case 3:
                    deleteContact();
                    break;  
                                     
                case 4:
                    searchContact();
                    break;

				case 5:
                    listContacts();
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }

    static void addContact() {

    while (true) {

        System.out.println("+-----------------------------------------+");
        System.out.println("|        Add Contact to the list          |");
        System.out.println("+-----------------------------------------+");

        String id = manager.generateId();

        System.out.print("Name : ");
        String name = input.nextLine();

        String phone;
        while (true) {

            System.out.print("Phone : ");
            phone = input.nextLine();

            if (manager.validPhone(phone)) {
                break;
            } else {
                System.out.println("Invalid Phone Number...");
            }
        }

        System.out.print("Company : ");
        String company = input.nextLine();

        double salary;
        while (true) {

            System.out.print("Salary : ");
            salary = input.nextDouble();
            input.nextLine();

            if (salary > 0) {
                break;
            } else {
                System.out.println("Invalid Salary...");
            }
        }

        String birthday;
        while (true) {

            System.out.print("Birthday : ");
            birthday = input.nextLine();

            if (manager.validBirthday(birthday)) {
                break;
            } else {
                System.out.println("Invalid Birthday...");
            }
        }

        Contact contact =
            new Contact(id, name, phone, company, salary, birthday);

        manager.addContact(contact);

        System.out.println("Contact has been added Successfully...");

        System.out.print("Do you want to add another contact? (Y/N) : ");
        String choice = input.nextLine();

        if (!choice.equalsIgnoreCase("Y")) {
            break;
        }
    }
}
    static void searchContact() {
		System.out.println("+-----------------------------------------+");
		System.out.println("|             SEARCH CONTACT              |");
		System.out.println("+-----------------------------------------+");
        System.out.print("Enter Name or Phone : ");
        String key = input.nextLine();

        Contact contact = manager.search(key);

        if (contact != null) {
            System.out.println(contact);
        } else {
            System.out.println("Contact Not Found");
        }
    }
    
    public static void updateContact() {
    System.out.println("+-----------------------------------------+");
    System.out.println("|            UPDATE CONTACT               |");
    System.out.println("+-----------------------------------------+");
    System.out.print("Enter Name or Phone Number : ");
    String value = input.nextLine();
    Contact contact = manager.search(value);
    if (contact == null) {
        System.out.println("Contact Not Found...");
        return;
    }
    System.out.println(contact);
    System.out.println("What do you want to update?");
    System.out.println("[1] Name");
    System.out.println("[2] Phone Number");
    System.out.println("[3] Company");
    System.out.println("[4] Salary");
    System.out.print("Enter an Option -> ");

    int option = input.nextInt();
    input.nextLine();

    switch (option) {

        case 1:
            System.out.print("Enter New Name : ");
            contact.setName(input.nextLine());
            break;

        case 2:
            while (true) {
                System.out.print("Enter New Phone Number : ");
                String newPhone = input.nextLine();

                if (manager.validPhone(newPhone)) {
                    contact.setPhone(newPhone);
                    break;
                }

                System.out.println("Invalid Phone Number...");
            }
            break;
            
        case 3:
            System.out.print("Enter New Company : ");
            contact.setCompany(input.nextLine());
            break;

        case 4:
            while (true) {
                System.out.print("Enter New Salary : ");
                double newSalary = input.nextDouble();
                input.nextLine();
                if (newSalary > 0) {
                    contact.setSalary(newSalary);
                    break;
                }
                System.out.println("Invalid Salary...");
            }
            break;
        default:
            System.out.println("Invalid Option...");
            return;
    }
    System.out.println("Contact Updated Successfully...");
}

    static void deleteContact() {
		System.out.println("+-----------------------------------------+");
        System.out.println("|            DELETE CONTACT               |");
		System.out.println("+-----------------------------------------+");
        System.out.print("Enter Name or Phone : ");
        String key = input.nextLine();

        if (manager.delete(key)) {
            System.out.println("Deleted Successfully");
        } else {
            System.out.println("Contact Not Found");
        }
    }
    
    static void listContacts() {
    System.out.println("+-----------------------------------------+");
    System.out.println("|              LIST CONTACTS              |");
    System.out.println("+-----------------------------------------+");
    System.out.println("[1] Sort by Name");
    System.out.println("[2] Sort by Salary");
    System.out.println("[3] Sort by Birthday");
    System.out.print("Enter an Option -> ");

    int option = input.nextInt();
    input.nextLine();

    Contact[] contacts = manager.getContacts();
    int count = manager.getCount();

    int[] temp = new int[count];

    for (int i = 0; i < count; i++) {
        temp[i] = i;
    }

    String title = "";

    for (int i = 0; i < count - 1; i++) {

        for (int j = 0; j < count - 1 - i; j++) {

            boolean swap = false;

            switch (option) {

                case 1:
                    if (contacts[temp[j]].getName()
                        .compareToIgnoreCase(
                         contacts[temp[j + 1]].getName()) > 0) {
                        swap = true;
                        title = "Name";
                        System.out.println("List Contact By " + title);
                    }
                    break;
                    
                case 2:
                    if (contacts[temp[j]].getSalary() >
                        contacts[temp[j + 1]].getSalary()) {
                        swap = true;
                        title = "Salary";
                        System.out.println("List Contact By " + title);
                    }
                    break;
                    
                case 3:
                    if (contacts[temp[j]].getBirthday()
                        .compareTo(
                         contacts[temp[j + 1]].getBirthday()) > 0) {
                        swap = true;
                        title = "Birthday";
                        System.out.println("List Contact By " + title);
                    }
                    break;
            }
            
            if (swap) {
                int t = temp[j];
                temp[j] = temp[j + 1];
                temp[j + 1] = t;
            }
        }
    }

    System.out.println("----------------------------------------------------------------------------");
    System.out.printf("%-8s %-15s %-12s %-15s %-10s %-12s\n",
            "ID", "NAME", "PHONE", "COMPANY", "SALARY", "BIRTHDAY");
    System.out.println("----------------------------------------------------------------------------");

    for (int i = 0; i < count; i++) {
        Contact c = contacts[temp[i]];
        System.out.printf("%-8s %-15s %-12s %-15s %-10.2f %-12s\n",
                c.getId(),
                c.getName(),
                c.getPhone(),
                c.getCompany(),
                c.getSalary(),
                c.getBirthday());
    }
}
}
