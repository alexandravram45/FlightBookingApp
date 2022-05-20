package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.FlightAlreadyExistsException;
import org.loose.fis.sre.exceptions.FlightDoesNotExistException;
import org.loose.fis.sre.exceptions.NoFlightsAvailable;
import org.loose.fis.sre.model.Flight;

import javafx.scene.control.TableView;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class FlightsService {
    private static ObjectRepository<Flight> flightRepository;

    public static ObjectRepository<Flight> getFlightRepository() {
        return flightRepository;
    }

    private static ObjectRepository<Flight> interestedRepository;

    public static ObjectRepository<Flight> getInterestedRepository() {
        return interestedRepository;
    }

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("flights-database.db").toFile())
                .openOrCreate("test", "test");

        flightRepository = database.getRepository(Flight.class);
    }

    public static void initDatabaseInterested() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("interested-database.db").toFile())
                .openOrCreate("test", "test");

        interestedRepository = database.getRepository(Flight.class);
    }

    public static void addFlight(String cityA, String cityB, String takeOffDate, int takeOffHour, int price) throws FlightAlreadyExistsException{
        checkFlightDoesNotAlreadyExist(cityA, cityB);
        flightRepository.insert(new Flight(cityA, cityB, takeOffDate, takeOffHour, price));
    }
    private static void checkFlightDoesNotAlreadyExist(String cityA, String cityB) throws FlightAlreadyExistsException {
        for (Flight flight : flightRepository.find()) {
            if (Objects.equals(cityA, flight.getCityA()) && Objects.equals(cityB, flight.getCityB()))
                throw new FlightAlreadyExistsException(cityA, cityB);
        }
    }
    public static void addFlightToInterested(String cityA, String cityB){
        for (Flight flight : flightRepository.find()) {
            if (Objects.equals(cityA, flight.getCityA()) && Objects.equals(cityB, flight.getCityB()))
                interestedRepository.insert(flight);
        }
    }

    public static void deleteFlight(String cityA, String cityB) throws FlightDoesNotExistException{
        for (Flight flight : flightRepository.find()) {
            if (Objects.equals(cityA, flight.getCityA()) && Objects.equals(cityB, flight.getCityB()))
                flightRepository.remove(flight);
            throw new FlightDoesNotExistException(cityA, cityB, flight.getFlightDate());
        }
    }

    public static void deleteFlightFromInterested(String cityA, String cityB) {
        for (Flight flight : interestedRepository.find()) {
            if (Objects.equals(cityA, flight.getCityA()) && Objects.equals(cityB, flight.getCityB()))
                interestedRepository.remove(flight);
        }
    }

     public static void editFlight(String cityA, String cityB, String oldDate, String newDate, int oldTime, int newTime) throws FlightDoesNotExistException {
         for (Flight flight : flightRepository.find()) {
             if (Objects.equals(cityA, flight.getCityA()) && Objects.equals(cityB, flight.getCityB())){
                 flightRepository.remove(flight);
                 Flight newFlight = new Flight(cityA, cityB, newDate, newTime, flight.getPrice());
                 flightRepository.insert(newFlight);
             }
             throw new FlightDoesNotExistException(cityA, cityB, flight.getFlightDate());
         }
     }

    public static Flight searchFlight(String cityA, String cityB, String flightDate) throws FlightDoesNotExistException {
        for (Flight flight : flightRepository.find()) {
            System.out.println(flightDate);
            System.out.println(flight.getFlightDate());
            System.out.println(flight.getCityA());
            System.out.println(flight.getCityB());
            if (Objects.equals(cityA, flight.getCityA()) && Objects.equals(cityB, flight.getCityB()) && Objects.equals(flightDate, flight.getFlightDate())) {
                return flight;
            }
        }
        throw new FlightDoesNotExistException(cityA, cityB, flightDate);
    }

    private static int flightNumber = 0;
    public static Flight returnFlight(int i){
        flightNumber = 0;
        for (Flight flight : flightRepository.find()) {
            flightNumber++;
            if (i == flightNumber)
                return flight;
        }
        return null;
    }


    private static int interestedFlightNumber = 0;
    public static Flight returnInterestedFlight(int i)  {
        interestedFlightNumber = 0;
        for (Flight flight : interestedRepository.find()) {
            interestedFlightNumber++;
            if (i == interestedFlightNumber)
                return flight;
        }
        return null;
    }
    public static int getFlightsNumber() throws NoFlightsAvailable{
        int flightsNumber = 0;
        for (Flight flight : flightRepository.find()) {
            flightsNumber ++;
        }
        if (flightsNumber == 0){
            throw new NoFlightsAvailable();
        }
        return flightsNumber;
    }

    public static int getInterestedFlightsNumber() throws NoFlightsAvailable{
        int flightsNumber = 0;
        for (Flight flight : interestedRepository.find()) {
            flightsNumber ++;
        }
        if (flightsNumber == 0){
            throw new NoFlightsAvailable();
        }
        return flightsNumber;
    }

}

