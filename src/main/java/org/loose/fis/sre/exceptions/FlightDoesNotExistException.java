package org.loose.fis.sre.exceptions;

import java.time.LocalDate;

public class FlightDoesNotExistException extends Exception{

    private String cityA, cityB;
    private LocalDate takeOffDate, takeOffBackDate;
    public FlightDoesNotExistException(String cityA, String cityB, LocalDate takeOffDate, LocalDate takeOffBackDate){
        super(String.format("Sorry, we didn't find a flight available!"));
        this.cityA = cityA;
        this.cityB = cityB;
        this.takeOffDate = takeOffDate;
        this.takeOffBackDate = takeOffBackDate;
    }
}
