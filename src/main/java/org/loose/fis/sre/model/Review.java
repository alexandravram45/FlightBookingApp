package org.loose.fis.sre.model;

public class Review {

    private String personName, reviewText;

    private String city;

    public Review(String city, String personName, String reviewText){
        this.city = city;
        this.personName = personName;
        this.reviewText = reviewText;
    }

    public String getCity() {
        return city;
    }

    public String getPersonName() {
        return personName;
    }

    public String getReviewText() {
        return reviewText;
    }
}
