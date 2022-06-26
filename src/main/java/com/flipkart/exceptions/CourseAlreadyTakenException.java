package com.flipkart.exceptions;

//course already taken by some other professor
public class CourseAlreadyTakenException extends Exception{
    private int courseId;

    public CourseAlreadyTakenException(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    @Override
    public String getMessage() {
        return "Exception: Course with ID: " + courseId + " already taken by other professor";
    }
}
