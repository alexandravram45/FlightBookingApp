package org.loose.fis.sre.exceptions;

public class FlightIsFullException extends Exception{
    public FlightIsFullException(){
        super(String.format("We are sorry, this flight has reached the maximum number of passengers!"));
    }
}
