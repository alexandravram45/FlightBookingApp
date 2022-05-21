package org.loose.fis.sre.exceptions;

public class EmptyTextFieldException extends Exception{
    EmptyTextFieldException () {
        super(String.format("This field can't be empty!"));
    }
}
