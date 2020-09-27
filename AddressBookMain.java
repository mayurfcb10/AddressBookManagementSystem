/* Welcome to the Address Book Management System */

import java.util.*;
public class AddressBookMain {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Welcome to the Address Book Program");
		AddressBook addressBook = new AddressBook();

		int choice;
		do {
			System.out.println("Enter the choice");
			choice = sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter the number of persons to be added");
				int noOfContacts = sc.nextInt();
				if(noOfContacts > 0) {
					for(int i1 = 0; i1 < noOfContacts; i1++) {
						System.out.println("Enter the contact details:");
						String firstName = sc.next();
						String lastName = sc.next();
						String address = sc.next();
						String city = sc.next();
						String state = sc.next();
						String email = sc.next();
						int phoneNumber = sc.nextInt();
						int zip = sc.nextInt();
						ContactDetails cd = new ContactDetails(firstName, lastName, address, city, state, zip, phoneNumber, email);

					}
				}
				System.out.println("Contact Added Successfully");
				break;
			case 2:
				System.out.println("Enter the firstName of the contact to be edited:");
				String fName = sc.next();
				boolean listEdited = addressBook.editContactDetails(fName);
				if(listEdited == true) {
					System.out.println("List Edited Successfully");
				}else {
					System.out.println("List Cannot be Edited");
				}
				break;

			case 3:
				System.out.println("Exit");
				break;
			}
		}
		while(choice != 3);

	}

}
		