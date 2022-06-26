package com.flipkart.exceptions;

//course has reached maximum strength limit of 10
public class CourseLimitExceededException extends Exception{
    private int num=10;
    public CourseLimitExceededException(int num ) {
        this.num = num;
    }

    @Override
    public String getMessage()
    {
        return "Exception: You have already registered for " + num + " courses";

    }
}
