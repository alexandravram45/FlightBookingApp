package org.loose.fis.sre.services;

import javafx.collections.ObservableList;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.controllers.FlightsController;
import org.loose.fis.sre.model.Flight;
import org.loose.fis.sre.model.Review;

import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class ReviewsService {
    public static Review addReviews(String city) {
        if (Objects.equals(city, "Spania")) {
            Review review = new Review("Spania", "Mark Rein", "I had lots of fun on my trip to Spain. Besides visiting family, I also went to different parts of Spain like Madrid, Fuentenovilla, Malaga, Getafe, Torre Molinos, and many other smaller cities. I had a blast. I live in Miami,Florida where the only hills and mountains you see are either the expressway or the landfill sites. The idea of all the mountainous regions and being atop these mountains was simply a thrill. I would definitely recommend it to anyone. ");
            return review;
        } else if (Objects.equals(city, "Italia")) {
            Review review = new Review(city, "Alexandra Bay", "This was the first time my wife and I have travelled to Italy and we wanted to see as much as possible so we booked a guided tour with Gate 1 Travel. I was a little apprehensive about traveling with a group, but the accomodations through Gate 1 exceeded our expectations. We were able to see all we wanted in Venice, Pisa, Florence, Assisi, and Rome.");
            return review;
        } else if (Objects.equals(city, "Anglia")) {
            Review review = new Review(city, "John Newman", "This was the first time my wife and I have travelled to England and we wanted to see as much as possible so we booked a guided tour with Gate 1 Travel. I was a little apprehensive about traveling with a group, but the accomodations through Gate 1 exceeded our expectations.");
            return review;
        } else if (Objects.equals(city, "Milano")) {
            Review review = new Review(city, "Alexandra Bay", "This was the first time my wife and I have travelled to Italy and we wanted to see as much as possible so we booked a guided tour with Gate 1 Travel. I was a little apprehensive about traveling with a group, but the accomodations through Gate 1 exceeded our expectations. We were able to see all we wanted in Venice, Pisa, Florence, Assisi, and Rome.");
            return review;
        } else if (Objects.equals(city, "Norvegia")) {
            Review review = new Review(city, "John", "There are many reasons to visit Norway. Mountains, fjords, Northern Lights, Sami culture, whale watching and so much more is waiting for you, and the Norwegian people will be happy to welcome you.");
            return review;
        } else if (Objects.equals(city, "Finlanda")) {
            Review review = new Review(city, "Maria", "Arctic Finland is worth a visit anytime of year. In summer, the sun never sets meaning there are all-day opportunities for outdoor activities including hiking and wildlife spotting");
            return review;
        } else if (Objects.equals(city, "Germania")) {
            Review review = new Review(city, "Bogdan", "Germany is a beautiful country in Western Europe full of calming landscapes, forests, rivers, and mountains. ");
            return review;
        } else if (Objects.equals(city, "Franta")) {
            Review review = new Review(city, "Alexandra Bay", "This was the first time my wife and I have travelled to France and we wanted to see as much as possible so we booked a guided tour with Gate 1 Travel. I was a little apprehensive about traveling with a group, but the accomodations through Gate 1 exceeded our expectations. We were able to see all we wanted in beautiful France.");
            return review;
        }
        return new Review(city, "There are no reviews available for this city.", "");
    }
}
