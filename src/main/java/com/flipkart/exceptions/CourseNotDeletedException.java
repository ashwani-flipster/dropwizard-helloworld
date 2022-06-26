package com.flipkart.exceptions;

//course could not be added (used by student)
public class CourseNotDeletedException extends Exception{
    private int courseId;

    public CourseNotDeletedException(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    @Override
    public String getMessage() {
        return "Exception: Course with ID: " + courseId + " has not been deleted";
    }
}
