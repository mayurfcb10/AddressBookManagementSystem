package com.addressbook;
/* Welcome to the Address Book Management System */

import java.util.*;

public class AddressBookMain {
    public static Scanner sc = new Scanner(System.in);
    public static HashMap<String, ContactDetails> contactListMap;
    private static final AddressBook addressBook = new AddressBook();
    public static HashMap<String, HashMap<String, ContactDetails>> addressBookListMap;
    ContactDetails contactDetails = new ContactDetails();

    AddressBookMain() {
        contactListMap = new HashMap<String, ContactDetails>();
        addressBookListMap = new HashMap<String, HashMap<String, ContactDetails>>();
    }

    public void SearchPersonsBasedOnState(String state) {
        for (String key1 : addressBookListMap.keySet()) {
            HashMap<String, ContactDetails> contactListMap = addressBookListMap.get(key1);
            for (String key2 : contactListMap.keySet()) {
                ContactDetails cd = contactListMap.get(key2);

                if (state.equals(cd.getCity())) {
                    System.out.println(cd.getFirstName() + " " + cd.getLastName() + " " + cd.getAddress() + " " + cd.getPhoneNumber() + " " + cd.getZip() + " " + cd.getState() + " " + cd.getEmail());
                }

            }

        }
    }

    public void SearchPersonBasedOnCity(String city) {
        for (String key1 : addressBookListMap.keySet()) {
            HashMap<String, ContactDetails> contactListMap = addressBookListMap.get(key1);
            for (String key2 : contactListMap.keySet()) {
                ContactDetails cd = contactListMap.get(key2);

                if (city.equals(cd.getCity())) {
                    System.out.println(cd.getFirstName() + " " + cd.getLastName() + " " + cd.getAddress() + " " + cd.getPhoneNumber() + " " + cd.getZip() + " " + cd.getState() + " " + cd.getEmail());
                }

            }

        }
    }

    public void AddContactDetails() {
        System.out.println("Enter the Address Book size");
        int enterAddressBookSize = sc.nextInt();
        for (int i = 0; i < enterAddressBookSize; i++) {
            int choice;
            System.out.println("Enter the name of the Address Book");
            String addressBookName = sc.next();
            do {
                System.out.println("Enter the choice 1:Add  2:Edit  3:Delete  4:Exit ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the number of persons to be added");
                        int noOfContacts = sc.nextInt();
                        if (noOfContacts > 0) {
                            for (int i1 = 0; i1 < noOfContacts; i1++) {
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
                        if (listEdited) {
                            System.out.println("List Edited Successfully");
                        } else {
                            System.out.println("List Cannot be Edited");
                        }
                        break;
                    case 3:
                        System.out.println("Enter the firstName of the contact to be deleted:");
                        String deleteContact = sc.next();
                        boolean listDeleted = addressBook.deleteContact(deleteContact);
                        if (listDeleted) {
                            System.out.println("Deleted Contact from the List");
                        } else {
                            System.out.println("List Cannot be Deleted");
                        }
                        break;
                    case 4:
                        System.out.println("Exit");
                        break;
                }

            }
            while (choice != 4);

            if (!addressBookListMap.containsKey(addressBookName)) {
                addressBookListMap.putIfAbsent(addressBookName, contactListMap);
            }
            
            Collection<ContactDetails> values = contactListMap.values();
            for (ContactDetails value : values) {
                System.out.println(value.getFirstName() + " " + value.getLastName() + " " + value.getEmail() + " " + value.getCity() + " " +
                        value.getAddress() + value.getState() + " " + value.getPhoneNumber() + " " + value.getZip());
            }


            for (String key1 : addressBookListMap.keySet()) {
                HashMap<String, ContactDetails> contactListMap = addressBookListMap.get(key1);
                for (String key2 : contactListMap.keySet()) {
                    ContactDetails cd = contactListMap.get(key2);
                    System.out.println(cd.getFirstName() + " " + cd.getLastName() + " " + cd.getAddress() + " " + cd.getPhoneNumber() + " " + cd.getZip() + " " + cd.getState() + " " + cd.getEmail());
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Program");
        AddressBookMain addressBookMain = new AddressBookMain();
        int choice;
        do {
            System.out.println("1. Add New Address Book");
            System.out.println("2. Search contact By State");
            System.out.println("3. Search Contact by city");
            System.out.println("4. Exit");
            System.out.println("Enter your Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    addressBookMain.AddContactDetails();
                }
                case 2: {
                    System.out.println("Enter Name of State: ");
                    String StateName = sc.next();
                    addressBookMain.SearchPersonBasedOnCity(StateName);
                    break;
                }
                case 3: {
                    System.out.println("Enter Name of City: ");
                    String CityName = sc.next();
                    addressBookMain.SearchPersonBasedOnCity(CityName);
                    break;
                }
                case 4: {
                    System.out.println("Enter Name of State: ");
                    String StateName = sc.next();
                    addressBookMain.SearchPersonByStateUsingHashMap(StateName);
                    break;
                }
                case 5: {
                    System.out.println("Enter Name of City: ");
                    String CityName = sc.next();
                    addressBookMain.SearchPersonByCityUsingHashmap(CityName);
                    break;
                }

                case 6:
                    System.out.println("Exit");
                    break;
            }
        } while (choice != 6);

    }
    
    private void SearchPersonByStateUsingHashMap(String stateName) {
        for (Map.Entry<String, HashMap<String, ContactDetails>> entry1 : addressBookListMap.entrySet()) {
            HashMap<String, ContactDetails> a2 = entry1.getValue();
            System.out.println("Address book: " + entry1.getKey());
            for (String key2 : contactListMap.keySet()) {
                ContactDetails cd = contactListMap.get(key2);
                if (stateName.equals(cd.getState())) {
                    System.out.println(cd.getFirstName() + " " + cd.getLastName() + " " + cd.getAddress() + " " + cd.getPhoneNumber() + " " + cd.getZip() + " " + cd.getState() + " " + cd.getEmail());
                }

            }

        }
    }

    private void SearchPersonByCityUsingHashmap(String cityName) {
        for(Map.Entry<String, HashMap<String, ContactDetails>> entry: addressBookListMap.entrySet()) {
            HashMap<String, ContactDetails> a1 = entry.getValue();
            System.out.println("Address book: " + entry.getKey());
            // ContactDetails cd = a1.get(City);
            for (String key2 : contactListMap.keySet()) {
                ContactDetails cd = contactListMap.get(key2);

                if (cityName.equals(cd.getState())) {
                    System.out.println(cd.getFirstName() + " " + cd.getLastName() + " " + cd.getAddress() + " " + cd.getPhoneNumber() + " " + cd.getZip() + " " + cd.getState() + " " + cd.getEmail());
                }

            }
        }
    }

}