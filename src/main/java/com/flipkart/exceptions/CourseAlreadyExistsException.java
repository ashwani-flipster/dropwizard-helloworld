package com.flipkart.exceptions;

//Exception to check if the course already exists in catalogue  (used by admin)
public class CourseAlreadyExistsException extends Exception{
    private int courseId;

    //constructor
    public CourseAlreadyExistsException(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    @Override
    public String getMessage() {
        return "Exception: The course with ID: " + courseId + " already exists";
    }
}
//user at left
//java8 api
//push documentation