package com.flipkart.exceptions;

//course not assigned to professor
public class CourseNotAssignedToProfException extends Exception {
    @Override
    public String getMessage() {
        return "Exception: Course  not assigned to the professor";
    }
}
