package com.flipkart.exceptions;

//user already exists(used during registration)
public class UserAlreadyExistsException extends Exception{
    private int userId;

    public UserAlreadyExistsException(int userId)
    {
        this.userId=userId;
    }

    public int getStudentId()
    {
        return userId;
    }


    public String getMessage() {
        return "Exception: User with userId : " + userId +" already exists";
    }
}
