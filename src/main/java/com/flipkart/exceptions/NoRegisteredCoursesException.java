package com.flipkart.exceptions;

//no courses registered by student
public class NoRegisteredCoursesException extends Exception{
    private int studentId;

    public NoRegisteredCoursesException(int studentId)
    {
        this.studentId=studentId;
    }

    public int getStudentId()
    {
        return studentId;
    }


    public String getMessage() {
        return "Exception: No courses registered for: " + studentId;
    }
}
