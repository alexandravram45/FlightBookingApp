package org.loose.fis.sre.model;

public class Booking {

    private String cityA, cityB, flightDate;

    private int flightHour, price;
    private String firstName, lastName, email, tel, address;

    public Booking(String firstName, String lastName, String tel, String address, String email, String cityA, String cityB, String flightDate, int flightHour, int price){
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.address = address;
        this.email = email;
        this.cityA = cityA;
        this.cityB = cityB;
        this.flightDate = flightDate;
        this.flightHour = flightHour;
        this.price = price;
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
