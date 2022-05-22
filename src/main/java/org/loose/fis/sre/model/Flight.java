package org.loose.fis.sre.model;

import java.sql.Date;

public class Flight {
    private String cityA, cityB;
    private Date flightDate;
    private Date takeOffBackDate;
    private int flightTime;
    private int price;

    public Flight(){
    }

    public Flight(String cityA, String cityB, Date flightDate, Date takeOffBackDate, int flightTime, int price){
        this.cityA = cityA;
        this.cityB = cityB;
        this.flightDate = flightDate;
        this.takeOffBackDate = takeOffBackDate;
        this.flightTime = flightTime;
        this.price = price;
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

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
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
