package com.dropwizard.exceptions;

public class CourseNotDroppedException extends Exception {
    @Override
    public String getMessage() {
        return "Exception: Course has not been dropped";
    }
}
