package org.loose.fis.sre.exceptions;

public class FlightAlreadyExistsException extends Exception {

    private String cityA, cityB;

    public FlightAlreadyExistsException(String cityA, String cityB) {
        super(String.format("A flight with the same departure and arrival city already exists!"));
    }
}
