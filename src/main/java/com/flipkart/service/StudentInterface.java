package com.flipkart.service;

import com.flipkart.bean.Student;
import com.flipkart.exceptions.*;

import java.sql.SQLException;

public interface StudentInterface {
    //method to register student for a new course
    //@throws RegistrationUnsuccessfulException
    /**
     * Method to register student in a course from database
     * @param stud: student object containing all the fields
     * @return
     * @throws RegistrationUnsuccessfulException
     */
    void register(Student stud);

    public Student fetchStudentData(int id);

    //show gradesheet(print inside the function not return it)
    /**
     * Method to view gradesheet after grade assigned by the professor
     * @param id: student id
     * @return
     * @throws NoRegisteredCoursesException
     */
    void viewGradesheet();

    //same goes with this function we show the grades print it not return it


    /**
     * Method to view course course catalogue
     * @return
     * @throws SQLException
     */
    void viewCourseCatalogue();






    /**
     * method to add course in database from course catalogue
     * @param stud: student object containing all fields
     * @return
     * @throws CourseNotAddedException
     */
    void addCourses(Student stud);

    /**
     * method to drop course selected by student
     * @param stud: student object containing all fields
     * @return
     * @throws CourseNotDroppedException
     */
    void dropCourses(Student stud);

    /**
     * method to pay fee by student for the selected course from database
     * @return
     * @throws PaymentUnsuccessfulException
     */
    void feePayment();




    /**
     * method to view selected course list
     * @param stud: student object containing all fields
     * @return
     * @throws NoRegisteredCoursesException
     */
    void viewCourses(Student stud);
}


