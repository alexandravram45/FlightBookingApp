package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.WrongEmailFormatException;
import org.loose.fis.sre.exceptions.WrongPhoneNumberFormatException;
import org.loose.fis.sre.model.Booking;

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

    public static void addBooking(String firstName, String lastName, String tel, String address, String email) throws WrongPhoneNumberFormatException, WrongEmailFormatException{
        checkEmailFormat(email);
        checkTelFormat(tel);
        bookingRepository.insert(new Booking(firstName, lastName, tel, address, email));
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
