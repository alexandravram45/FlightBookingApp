package org.loose.fis.sre.exceptions;

public class WrongPhoneNumberFormatException extends Exception{

    private String tel;
    public WrongPhoneNumberFormatException(String tel){
        super(String.format("This phone number is not a valid phone number."));
        this.tel = tel;
    }
}
