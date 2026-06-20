import java.util.*;
import java.time.*;
import java.time.format.DateTimeParseException;
public class iFriendContact{
    static Scanner input = new Scanner(System.in);
    static String[] ids = new String[100];
    static String[] names = new String[100];
    static String[] phones = new String[100];
    static String[] companies = new String[100];
    static double[] salaries = new double[100];
    static String[] birthdays = new String[100];
    static int count = 0;
    public static void main(String[] args){
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
                    System.out.println("Program terminated.");
                    System.exit(0);
                    break;
            }
        }
    }
    public static String generateId(){
        return String.format("C%04d", count + 1);
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

    public static void addContact(){
        while (true){
			System.out.println("+-----------------------------------------+");
            System.out.println("|        Add Contact to the list          |");
			System.out.println("+-----------------------------------------+");
            String id = generateId();
            System.out.println(id);
            System.out.print("Name    : ");
            String name = input.nextLine();
            String phone;
            while (true){
                System.out.print("Phone Number : ");
                phone = input.nextLine();
                if (validPhone(phone)){
                    break;
                }else{
                    System.out.println("Invalid Phone Number...");
                }
            }
            System.out.print("Company Name : ");
            String company = input.nextLine();
            double salary;
            while (true){
                System.out.print("Salary : ");
                salary = input.nextDouble();
                input.nextLine();
                if (salary > 0){
                    break;
                }else{
                    System.out.println("Invalid Salary...");
                }
            }
            String birthday;
            while (true){
                System.out.print("Birthday (YYYY-MM-DD) : ");
                birthday = input.nextLine();
                if (validBirthday(birthday)){
                    break;
                }else{
                    System.out.println("Invalid Birthday...");
                }
            }
            ids[count] = id;
            names[count] = name;
            phones[count] = phone;
            companies[count] = company;
            salaries[count] = salary;
            birthdays[count] = birthday;
            count++;
            System.out.println("Contact has been added Successfully...");
            System.out.print("Do you want to add another contact? (Y/N) : ");
            String choice = input.nextLine();
            if (!choice.equalsIgnoreCase("Y")){
                break;
            }
        }
    }
    public static int searchIndex(String value){
        for (int i = 0; i < count; i++){
            if (phones[i].equals(value) || names[i].equalsIgnoreCase(value)){
                return i;
            }
        }
        return -1;
    }
    public static void printContact(int i){
        System.out.println("Contact ID          : " + ids[i]);
        System.out.println("Name                : " + names[i]);
        System.out.println("Phone               : " + phones[i]);
        System.out.println("Company             : " + companies[i]);
        System.out.println("Salary              : " + salaries[i]);
        System.out.println("B'Day(YYYY-MM-DD)   : " + birthdays[i]);
    }

    public static void updateContact(){
		System.out.println("+-----------------------------------------+");
        System.out.println("|             UPDATE Content              |");
		System.out.println("+-----------------------------------------+");
        System.out.print("Enter Name or Phone Number : ");
        String value = input.nextLine();
        int index = searchIndex(value);
        printContact(index);
        System.out.println("What do you want to update...");
        System.out.println("[1] Name");
        System.out.println("[2] Phone Number");
        System.out.println("[3] Company");
        System.out.println("[4] Salary");
        System.out.print("Enter an Option to continue -> ");
        int option = input.nextInt();
        input.nextLine();
        switch (option){
            case 1:
                System.out.print("Enter New Name : ");
                names[index] = input.nextLine();
                break;
            case 2:
                while (true){
                    System.out.print("Enter New Phone Number : ");
                    String newPhone = input.nextLine();
                    if (validPhone(newPhone)){
                        phones[index] = newPhone;
                        break;
                    }else{
                        System.out.println("Invalid Phone Number...");
                    }
                }
                break;
            case 3:
                System.out.print("Enter New Company : ");
                companies[index] = input.nextLine();
                break;
            case 4:
                while (true){
                    System.out.print("Enter New Salary : ");
                    double newSalary = input.nextDouble();
                    input.nextLine();
                    if (newSalary > 0){
                        salaries[index] = newSalary;
                        break;
                    }else{
                        System.out.println("Invalid Salary...");
                    }
                }
                break;
        }
        System.out.println("Contact has been Update Successfully...");
    }
    
    public static void deleteContact(){
		System.out.println("+-----------------------------------------+");
        System.out.println("|            DELETE CONTACT               |");
		System.out.println("+-----------------------------------------+");
        System.out.print("Enter Name or Phone Number : ");
        String value = input.nextLine();
        int index = searchIndex(value);
        printContact(index);
        System.out.print("Do you want to delete this contact? (Y/N) : ");
        String choice = input.nextLine();
        if (choice.equalsIgnoreCase("Y")) {
            for (int i = index; i < count - 1; i++) {
                ids[i] = ids[i + 1];
                names[i] = names[i + 1];
                phones[i] = phones[i + 1];
                companies[i] = companies[i + 1];
                salaries[i] = salaries[i + 1];
                birthdays[i] = birthdays[i + 1];
            }
            count--;
            System.out.println("Customer has been deleted Successfully...");
        } else {
            System.out.println("Delete Cancelled...");
        }
    }

    public static void searchContact(){
    System.out.println("+-----------------------------------------+");
    System.out.println("|             SEARCH CONTACT              |");
    System.out.println("+-----------------------------------------+");
    System.out.print("Enter Name or Phone Number : ");
    String value = input.nextLine();
    int index = searchIndex(value);
    if (index == -1) {
        System.out.println("No Contact found for " + value + "...");
        return;
    }
    printContact(index);
}
	public static void listContacts(){
		System.out.println("+-----------------------------------------+");
		System.out.println("|              LIST CONTACTS              |");
		System.out.println("+-----------------------------------------+");
		System.out.println("[1] Sort by Name");
		System.out.println("[2] Sort by Salary");
		System.out.println("[3] Sort by Birthday");
		System.out.print("Enter an Option to continue -> ");
		int option = input.nextInt();
		input.nextLine();
		String r ="";
		int[] temp = new int[count];
			for (int i = 0; i < count; i++) {
			temp[i] = i;
		}
		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count - 1 - i; j++) {
				boolean swap = false;
				switch (option) {
					case 1:
						if (names[temp[j]].compareToIgnoreCase(names[temp[j + 1]]) > 0) {
							swap = true;
							r = "Name";
						}
						break;
					case 2:
						if (salaries[temp[j]] > salaries[temp[j + 1]]) {
							swap = true;
							r = "Salary";
						}
						break;
					case 3:
						if (birthdays[temp[j]].compareTo(birthdays[temp[j + 1]]) > 0) {
							swap = true;
							r = "Birthday";
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
		System.out.println("                 +-----------------------------------------+               ");
		System.out.println("                 |          List Contact by "+ r + "          |               ");
		System.out.println("                 +-----------------------------------------+               ");
		System.out.println("---------------------------------------------------------------------------");
		System.out.printf("%-8s %-15s %-12s %-15s %-10s %-12s\n",
				"ID", "NAME", "PHONE", "COMPANY", "SALARY", "BIRTHDAY");

		System.out.println("---------------------------------------------------------------------------");
		for (int i = 0; i < count; i++) {
			int k = temp[i];
			System.out.printf("%-8s %-15s %-12s %-15s %-10.2f %-12s\n",
                ids[k],
                names[k],
                phones[k],
                companies[k],
                salaries[k],
                birthdays[k]);
		}
		}
	
}
