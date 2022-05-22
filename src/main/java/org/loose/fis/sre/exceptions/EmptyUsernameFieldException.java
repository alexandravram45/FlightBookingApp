package org.loose.fis.sre.exceptions;

public class EmptyUsernameFieldException extends Exception{
    public EmptyUsernameFieldException() {
        super(String.format("The username field can not be empty!"));
    }
}
