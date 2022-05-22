package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

public class Flight {

    @Id
    private int id;
    private static int currentid = 0;

    private String cityA, cityB;
    private String flightDate;
    private int flightTime;
    private int price;

    private int capacity = 0;

    public Flight(){}
    public Flight(String cityA, String cityB, String flightDate, int flightTime, int price){
        this.cityA = cityA;
        this.cityB = cityB;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
        this.price = price;
        currentid++;
        this.id = currentid;
    }

    public String getCityA() {
        return cityA;
    }

    public void setCityA(String cityA) {
        this.cityA = cityA;
    }

    public String getCityB() {
        return cityB;
    }

    public void setCityB(String cityB) {
        this.cityB = cityB;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public static void setCurrentid(int currentid) {
        Flight.currentid = currentid;
    }
}
