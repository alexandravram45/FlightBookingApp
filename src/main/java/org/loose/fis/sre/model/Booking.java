package org.loose.fis.sre.model;

public class Booking {
    private String firstName, lastName, email, tel, address;

    public Booking(String firstName, String lastName, String tel, String address, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.address = address;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTel() {
        return tel;
    }
}
