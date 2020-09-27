/* Welcome to the Address Book Management System */

import java.util.*;
public class AddressBookMain {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Welcome to the Address Book Program");

		AddressBook addressBook = new AddressBook();

		System.out.println("Enter the Address Book size");
		int enterAddressBookSize = sc.nextInt();

		for(int i = 0; i < enterAddressBookSize; i++) { 
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
							cd.setAddress(address);
							cd.setCity(city);
							cd.setEmail(email);
							cd.setFirstName(firstName);
							cd.setLastName(lastName);
							cd.setZip(zip);
							cd.setPhoneNumber(phoneNumber);
							cd.setState(state);
							addressBook.addContact(cd);
						}
					}
					System.out.println("Contact Added Successfully");
					break;

				case 2:
					System.out.println("Enter the firstName of the contact is to be edited:");
					String fName = sc.next();
					boolean listEdited = addressBook.editContactDetails(fName);
					if(listEdited == true) {
						System.out.println("List Edited Successfully");
					}else {
						System.out.println("List Cannot be Edited");
					}
					break;

				case 3:
					System.out.println("Enter the firstName of the contact to be deleted:");
					String deleteContact = sc.next();
					boolean listDeleted = addressBook.deleteContact(deleteContact);
					if(listDeleted == true) {
						System.out.println("Deleted Contact from the List");
					}else {
						System.out.println("List Cannot be Deleted");
					}
					break;

				case 4:
					System.out.println("Exit");
					break;

				}
			}
			while(choice != 4);

		}

		ArrayList<ContactDetails> viewContact = new ArrayList<>();
		viewContact = addressBook.viewAddedContact();

		for(ContactDetails m1 : viewContact) {
			System.out.println(m1.getFirstName());
			System.out.println(m1.getLastName());
			System.out.println(m1.getAddress());
			System.out.println(m1.getCity());
			System.out.println(m1.getState());
			System.out.println(m1.getEmail());
			System.out.println(m1.getPhoneNumber());
			System.out.println(m1.getZip());

		}
	}
}
