package org.loose.fis.sre.exceptions;

public class EmptyUsernameFieldException extends Exception{
    EmptyUsernameFieldException() {
        super(String.format("The username field can not be empty!"));
    }
}
