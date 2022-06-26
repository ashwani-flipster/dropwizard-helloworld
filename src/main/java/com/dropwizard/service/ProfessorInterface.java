package com.dropwizard.service;
import com.dropwizard.bean.*;
public interface ProfessorInterface {
    void chooseCourse(int id);
    Professor fetchProfessorData(int id);

    void viewStudentsList(int id);

    void assignGrade(int id);

}
