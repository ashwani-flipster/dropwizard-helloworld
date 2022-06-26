package com.flipkart.exceptions;

//registration of student unsucessful
public class RegistrationUnsuccessfulException extends Exception{

    @Override
    public String getMessage() {
        return "Exception: Registration unsuccessful ";
    }
}
