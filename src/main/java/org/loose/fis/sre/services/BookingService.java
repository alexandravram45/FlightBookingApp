package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.FlightDoesNotExistException;
import org.loose.fis.sre.exceptions.FlightIsFullException;
import org.loose.fis.sre.exceptions.WrongEmailFormatException;
import org.loose.fis.sre.exceptions.WrongPhoneNumberFormatException;
import org.loose.fis.sre.model.Booking;
import org.loose.fis.sre.model.Flight;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class BookingService {
    private static ObjectRepository<Booking> bookingRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("booking-database.db").toFile())
                .openOrCreate("test", "test");

        bookingRepository = database.getRepository(Booking.class);
    }

    public static void addBooking(String firstName, String lastName, String tel, String address, String email, String cityA, String cityB, String flightDate, int flightHour, int price) throws WrongPhoneNumberFormatException, WrongEmailFormatException, FlightDoesNotExistException, FlightIsFullException {
        checkEmailFormat(email);
        checkTelFormat(tel);
        checkFlightCapacity(FlightsService.searchFlight(cityA, cityB, flightDate));
        bookingRepository.insert(new Booking(firstName, lastName, tel, address, email, cityA, cityB, flightDate, flightHour, price));
    }

    public static void checkFlightCapacity(Flight flight) throws FlightIsFullException {
        if (flight.getCapacity() > 100){
            throw new FlightIsFullException();
        }
    }

    private static void checkTelFormat(String tel) throws WrongPhoneNumberFormatException{
        String patterns
                = "^\\d{10}$"
                + "^(\\d{3}[- .]?){2}\\d{4}$"
                + "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(tel);
        if (!matcher.matches()){
            throw new WrongPhoneNumberFormatException(tel);
        }
    }

    private static void checkEmailFormat(String email) throws WrongEmailFormatException {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        System.out.println(email +" : "+ matcher.matches());
        if (!matcher.matches()){
            throw new WrongEmailFormatException(email);
        }
    }
}
