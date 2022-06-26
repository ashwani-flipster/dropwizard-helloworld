package com.dropwizard.service;
import com.dropwizard.bean.*;
public interface AdminInterface {
    Admin fetchAdminData(int id);
    void approveStudent();

    void generateReportCard();

    void addProfessor();

    void updateCatalogue(int addOrDrop);

    void assignCourseToStudent();
}
