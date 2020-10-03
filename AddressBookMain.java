package com.addressbook;
/* Welcome to the Address Book Management System */

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AddressBookMain {
    public static Scanner sc = new Scanner(System.in);
    public static HashMap<String, ContactDetails> contactListMap;
    private static final AddressBook addressBook = new AddressBook() ;
    public static HashMap<String, HashMap<String, ContactDetails>> addressBookListMap;

    AddressBookMain() {
        contactListMap = new HashMap<String, ContactDetails>();
        addressBookListMap = new HashMap<String, HashMap<String, ContactDetails>>();
    }

    public void AddressContactDetails() {
        System.out.println("Enter the Address Book size");
        int enterAddressBookSize = sc.nextInt();
        for(int i = 0; i < enterAddressBookSize; i++) {
            int choice;
            System.out.println("Enter the name of the Address Book");
            String addressBookName = sc.next();
            do {
                System.out.println("Enter the choice 1:Add  2:Edit  3:Delete  4:Exit ");
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
                                String phoneNumber = sc.next();
                                String zip = sc.next();
                                ContactDetails contactDetails = new ContactDetails(firstName, lastName, address, city, state, email, zip, phoneNumber);
                                contactListMap = addressBook.addContact(firstName, contactDetails);

                            }
                        }
                        System.out.println("Contact Added Successfully");
                        break;
                    case 2:
                        System.out.println("Enter the firstName of the contact is to be edited:");
                        String fName = sc.next();
                        boolean listEdited = addressBook.editContactDetails(fName);
                        if(listEdited) {
                            System.out.println("List Edited Successfully");
                        }else {
                            System.out.println("List Cannot be Edited");
                        }
                        break;
                    case 3:
                        System.out.println("Enter the firstName of the contact to be deleted:");
                        String deleteContact = sc.next();
                        boolean listDeleted = addressBook.deleteContact(deleteContact);
                        if(listDeleted) {
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

            if(!addressBookListMap.containsKey(addressBookName)){
                addressBookListMap.put(addressBookName, contactListMap);
            }


            Collection<ContactDetails> values = contactListMap.values();
            for(ContactDetails value : values) {
                    System.out.println(value.getFirstName()+" "+value.getLastName()+" "+value.getEmail()+" "+value.getCity()+" "+
                            value.getAddress()+ value.getState()+" "+value.getPhoneNumber()+" "+value.getZip());
                }


            for (String key1 : addressBookListMap.keySet()) {
                HashMap<String, ContactDetails> contactListMap = addressBookListMap.get(key1);
                for ( String key2: contactListMap.keySet()) {
                    ContactDetails cd = contactListMap.get(key2);
                    System.out.println(cd.getFirstName() + " " + cd.getLastName() + " " + cd.getAddress() + " " + cd.getPhoneNumber() + " " + cd.getZip() + " " + cd.getState() + " " + cd.getEmail());
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Program");
        AddressBookMain addressBookMain = new AddressBookMain();
        addressBookMain.AddressContactDetails();

    }
}

