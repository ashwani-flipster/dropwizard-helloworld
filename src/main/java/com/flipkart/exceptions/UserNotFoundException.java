package com.flipkart.exceptions;

//no user with given id exists
public class UserNotFoundException extends Exception{
    private int userId;

    public UserNotFoundException(int userId)
    {
        this.userId=userId;
    }

    public int getStudentId()
    {
        return userId;
    }


    public String getMessage() {
        return "Exception: User with userId : " + userId +" not found";
    }
}
