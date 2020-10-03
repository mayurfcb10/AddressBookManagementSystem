package com.addressbook;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static com.addressbook.AddressBookMain.addressBookListMap;
import static com.addressbook.AddressBookMain.contactListMap;

public class AddressBook {
    private final HashMap<String, ContactDetails> contactList;
    ContactDetails contactDetails1 = new ContactDetails();
    AddressBookMain addressBookMain = new AddressBookMain();
    private final Scanner sc = new Scanner(System.in);
    private String city;

    AddressBook(){
        contactList = new HashMap<String, ContactDetails>();
    }

    public HashMap<String, ContactDetails> addContact(String firstName, ContactDetails contactAdded){
        if(!contactListMap.containsKey(firstName)){
            contactList.putIfAbsent(firstName, contactAdded);
        }
        return contactList;
    }

    public boolean editContactDetails(String contactName) {
        boolean flag = false;
        for (Map.Entry<String, ContactDetails> stringContactDetailsEntry : contactList.entrySet()) {
            Map.Entry m = (Map.Entry) stringContactDetailsEntry;
            if ((m.getKey().equals(contactName))) {
                System.out.println("Select the index for the contact detail you want to edit ");
                System.out.println("1 : First Name of the contact to be edited");
                System.out.println("2 : Last Name of the contact to be edited");
                System.out.println("3 : Address of the contact to be edited");
                System.out.println("4 : City of the contact to be edited");
                System.out.println("5 : State of the contact to be edited");
                System.out.println("6 : Email of the contact to be edited");
                System.out.println("7 : Phone Number of the contact to be edited");
                System.out.println("8 : Zip of the contact to be edited");
                int selectContactIndex = sc.nextInt();
                switch (selectContactIndex) {
                    case 1:
                        System.out.println("Enter the new First Name");
                        contactDetails1.setFirstName(sc.next());
                        break;
                    case 2:
                        System.out.println("Enter the new Last Name");
                        contactDetails1.setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Enter the new Address Name");
                        contactDetails1.setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Enter the new City Name");
                        contactDetails1.setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Enter the new State Name");
                        contactDetails1.setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Enter the new Email");
                        contactDetails1.setEmail(sc.next());
                        break;
                    case 7:
                        System.out.println("Enter the new Phone Number");
                        contactDetails1.setPhoneNumber(sc.next());
                        break;
                    case 8:
                        System.out.println("Enter the new Zip Code");
                        contactDetails1.setZip(sc.next());
                        break;

                }
                flag = true;
                break;
            }
        }

        return (flag==true);
    }

    public boolean deleteContact(String deleteContact) {
        int flag = 0;
        Iterator itr = contactList.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry m = (Map.Entry)itr.next();
            if(m.getKey().equals(deleteContact)) {
                System.out.println(m.getKey()+"---"+m.getValue());
                contactList.remove(deleteContact);
                flag = 1;
            }
        }
        return flag == 1;
    }


}
