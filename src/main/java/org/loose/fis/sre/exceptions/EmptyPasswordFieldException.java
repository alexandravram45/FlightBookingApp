package org.loose.fis.sre.exceptions;

public class EmptyPasswordFieldException extends Exception{
    public EmptyPasswordFieldException() {
        super(String.format("The password field can not be empty!"));
    }
}
