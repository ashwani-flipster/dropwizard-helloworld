package com.flipkart.service;

import com.flipkart.bean.RegisteredCourse;

import java.util.List;

public interface RegistrationInterface {
    List<RegisteredCourse> registeredCourses();

    void addCourses();

    void dropCourses();

    void feePayment();

    void viewCourses();
}
