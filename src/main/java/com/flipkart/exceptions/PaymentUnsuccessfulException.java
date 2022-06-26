package com.flipkart.exceptions;

//payment could not success
public class PaymentUnsuccessfulException extends Exception{
    private int studentId;

    public PaymentUnsuccessfulException(int studentId)
    {
        this.studentId=studentId;
    }

    public int getStudentId()
    {
        return studentId;
    }

    public String getMessage() {
        return "Exception: Payment unsuccessful for : " + studentId;
    }
}
