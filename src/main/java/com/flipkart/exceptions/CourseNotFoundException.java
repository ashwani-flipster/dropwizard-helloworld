package com.flipkart.exceptions;

//course not found in course catalogue
public class CourseNotFoundException extends Exception{
    private int courseId;

    public CourseNotFoundException(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    @Override
    public String getMessage() {
        return "Exception: Course with ID: " + courseId + " not found";
    }
}
