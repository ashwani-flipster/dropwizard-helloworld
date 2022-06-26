package com.flipkart.service;
import com.flipkart.bean.*;
public interface AdminInterface {
    Admin fetchAdminData(int id);
    void approveStudent();

    void generateReportCard();

    void addProfessor();

    void updateCatalogue(int addOrDrop);

    void assignCourseToStudent();
}
