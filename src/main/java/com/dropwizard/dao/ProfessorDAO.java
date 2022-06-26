package com.dropwizard.dao;

import com.dropwizard.bean.*;
import com.dropwizard.exceptions.CourseNotAssignedToProfException;
import com.dropwizard.exceptions.GradeNotAddedException;
import com.dropwizard.exceptions.NoStudentRegisteredException;
import com.dropwizard.exceptions.UserNotFoundException;

import java.sql.SQLException;

public interface ProfessorDAO {

    void chooseCourse(int id) throws SQLException, CourseNotAssignedToProfException;

    Professor fetchProfessorData(int id) throws SQLException, UserNotFoundException;

    void viewStudentsList (int id) throws SQLException, NoStudentRegisteredException;

    void assignGrade(int id) throws SQLException, GradeNotAddedException,NoStudentRegisteredException;

}
