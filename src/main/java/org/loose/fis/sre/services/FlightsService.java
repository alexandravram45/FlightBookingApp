package org.loose.fis.sre.services;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.jetbrains.annotations.Nullable;
import org.loose.fis.sre.controllers.FlightsController;
import org.loose.fis.sre.controllers.HomeController;
import org.loose.fis.sre.exceptions.FlightAlreadyExistsException;
import org.loose.fis.sre.exceptions.FlightDoesNotExistException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.Flight;
import org.loose.fis.sre.model.User;

import java.util.Date;
import java.time.LocalDate;
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

    public static void addFlight( String cityA, String cityB, Date takeOffDate, Date takeOffBackDate, int takeOffHour, int price) throws FlightAlreadyExistsException{
        checkFlightDoesNotAlreadyExist(cityA, cityB);
        flightRepository.insert(new Flight(cityA, cityB, takeOffDate, takeOffBackDate, takeOffHour, price));
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

    public static void deleteFlight(String cityA, String cityB) {
        for (Flight flight : flightRepository.find()) {
            if (Objects.equals(cityA, flight.getCityA()) && Objects.equals(cityB, flight.getCityB()))
                flightRepository.remove(flight);
        }
    }

    public static void deleteFlightFromInterested(String cityA, String cityB) {
        for (Flight flight : interestedRepository.find()) {
            if (Objects.equals(cityA, flight.getCityA()) && Objects.equals(cityB, flight.getCityB()))
                interestedRepository.remove(flight);
        }
    }

    @Nullable
    public static Flight searchFlight(String cityA, String cityB, LocalDate takeOffDate, LocalDate takeOffBackDate) throws FlightDoesNotExistException {
        int ok = 0;
        for (Flight flight : flightRepository.find()) {
            if (Objects.equals(cityA, flight.getCityA()) && Objects.equals(cityB, flight.getCityB()) && Objects.equals(takeOffDate, flight.getTakeOffDate()) && Objects.equals(takeOffBackDate, flight.getTakeOffBackDate())) {
                ok = 1;
                return flight;
            }
        }
        if (ok == 0) {
            throw new FlightDoesNotExistException(cityA, cityB, takeOffDate, takeOffBackDate);
        }
        return null;
    }
}

