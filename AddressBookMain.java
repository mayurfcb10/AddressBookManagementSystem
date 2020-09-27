/* Welcome to the Address Book Management System */

import java.util.*;
public class AddressBookMain {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Welcome to the Address Book Management System");
		AddressBook addressBook = new AddressBook();
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
		addressBook.contactList(cd);

		ArrayList<ContactDetails> addedContactDetails = new ArrayList<>();
		addedContactDetails = addressBook.viewAddedContact();

		for(ContactDetails m1 : addedContactDetails) {
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
