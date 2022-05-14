package org.loose.fis.sre.exceptions;

public class WrongEmailFormatException extends Exception{
    private String email;

    public WrongEmailFormatException(String email){
        super(String.format("This e-mail is not a valid e-mail!"));
        this.email = email;
    }
}
