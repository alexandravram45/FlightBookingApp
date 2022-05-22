package org.loose.fis.sre.exceptions;

public class NoFlightsAvailable extends Exception{
    public NoFlightsAvailable(){
        super(String.format("Sorry, there are no flights available!"));
    }
}
