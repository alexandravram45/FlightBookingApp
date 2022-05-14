package org.loose.fis.sre.model;

import java.util.Date;

public class Flight {

    private int flightId;
    private String cityA, cityB;
    private Date takeOffDate;
    private Date takeOffBackDate;
    private int takeOffHour, takeOffMinutes;
    private int price;

    public Flight(){
    }

    public Flight(int flightId, String cityA, String cityB, Date takeOffDate, Date takeOffBackDate, int takeOffHour, int takeOffMinutes, int price){
        this.flightId = flightId;
        this.cityA = cityA;
        this.cityB = cityB;
        this.takeOffDate = takeOffDate;
        this.takeOffBackDate = takeOffBackDate;
        this.takeOffHour = takeOffHour;
        this.takeOffMinutes = takeOffMinutes;
        this.price = price;
    }
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
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

    public int getTakeOffHour() {
        return takeOffHour;
    }

    public void setTakeOffHour(int takeOffHour) {
        this.takeOffHour = takeOffHour;
    }

    public int getTakeOffMinutes() {
        return takeOffMinutes;
    }

    public void setTakeOffMinutes(int takeOffMinutes) {
        this.takeOffMinutes = takeOffMinutes;
    }

    public Date getTakeOffDate() {
        return takeOffDate;
    }

    public void setTakeOffDate(Date takeOffDate) {
        this.takeOffDate = takeOffDate;
    }

    public Date getTakeOffBackDate() {
        return takeOffBackDate;
    }

    public void setTakeOffBackDate(Date takeOffBackDate) {
        this.takeOffBackDate = takeOffBackDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
