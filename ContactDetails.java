package com.addressbook;


public class ContactDetails {
    private String firstName, lastName, address, city, state, email, zip, phoneNumber ;


    public ContactDetails(String firstName2, String lastName2, String address2, String city2, String state2,
                          String email2, String zip2, String phoneNumber2) {
        setFirstName(firstName2);
        setLastName(lastName2);
        setAddress(address2);
        setCity(city2);
        setState(state2);
        setZip(zip2);
        setPhoneNumber(phoneNumber2);
        setEmail(email2);
    }

    public ContactDetails() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
