package com.flipkart.exceptions;

public class PaymentAlreadyExistsException extends Exception {
    @Override
    public String getMessage() {
        return "Exception: Fee already paid.";
    }
}
