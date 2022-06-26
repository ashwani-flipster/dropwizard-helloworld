package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.exceptions.*;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDAO {
    //method to register student for a new course
    //@throws RegistrationUnsuccessfulException
    /**
     * Method to register student in a course from database
     * @param stud: student object containing all the fields
     * @return
     * @throws RegistrationUnsuccessfulException
     */
    void register(Student stud) throws SQLException, RegistrationUnsuccessfulException;

    /**
     * Method to fetch student data from database
     * @param id: student id
     * @return student object containing all the fields
     * @throws UserNotFoundException
     */
    public Student fetchStudentData(int id) throws SQLException, UserNotFoundException;

    //show gradesheet(print inside the function not return it)
//    /**
//     * Method to view gradesheet after grade assigned by the professor
//     * @param id: student id
//     * @return
//     * @throws NoRegisteredCoursesException
//     */
    void viewGradesheet(int userId) throws SQLException, NoRegisteredCoursesException;

    //same goes with this function we show the course catalogue print it not return it
    /**
     * Method to view course course catalogue
     * @return
     * @throws SQLException
     */
    ArrayList<String> viewCourseCatalogue() throws SQLException;

    /**
     * method to add course in database from course catalogue
     * @param stud: student object containing all fields
     * @return
     * @throws CourseNotAddedException
     */
    void addCourses(Student stud) throws SQLException, CourseNotAddedException;


    /**
     * method to drop course selected by student
     * @param stud: student object containing all fields
     * @return
     * @throws CourseNotDroppedException
     */
    void dropCourses(Student stud) throws SQLException, CourseNotDroppedException,CourseNotFoundException;


    /**
     * method to pay fee by student for the selected course from database
     * @param student: student object containing all fields
     * @return
     * @throws PaymentUnsuccessfulException
     */
    void feePayment(Student student) throws SQLException, PaymentUnsuccessfulException;

    /**
     * method to view selected course list
     * @param stud: student object containing all fields
     * @return
     * @throws NoRegisteredCoursesException
     */
    void viewCourses(int stud) throws SQLException, NoRegisteredCoursesException;
}
