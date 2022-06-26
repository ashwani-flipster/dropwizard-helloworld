package com.dropwizard.dao;

import com.dropwizard.bean.Admin;
import com.dropwizard.exceptions.*;

import java.sql.SQLException;

public interface AdminDAO {
    Admin fetchAdminData(int id) throws SQLException, UserNotFoundException;
    void approveStudent() throws SQLException;

    void generateReportCard();

    void addProfessor() throws SQLException, UserAlreadyExistsException;

    void updateCatalogue(int addOrDrop) throws SQLException, CourseAlreadyExistsException, CourseNotFoundException;

    void assignCourseToStudent();

    void viewCourseCatalogue() throws SQLException;
}
