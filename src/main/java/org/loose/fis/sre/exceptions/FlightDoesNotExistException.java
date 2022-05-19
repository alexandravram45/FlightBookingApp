package org.loose.fis.sre.exceptions;

import java.sql.Date;
import java.time.LocalDate;

public class FlightDoesNotExistException extends Exception{

    private String cityA, cityB;
    private int flightTime;
    private String flightDate;
    public FlightDoesNotExistException(String cityA, String cityB, String flightDate){
        super(String.format("Sorry, we didn't find a flight available!"));
        this.cityA = cityA;
        this.cityB = cityB;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
    }
}
