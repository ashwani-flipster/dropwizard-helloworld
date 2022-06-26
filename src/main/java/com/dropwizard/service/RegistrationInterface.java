package com.dropwizard.service;

import com.dropwizard.bean.RegisteredCourse;

import java.util.List;

public interface RegistrationInterface {
    List<RegisteredCourse> registeredCourses();

    void addCourses();

    void dropCourses();

    void feePayment();

    void viewCourses();
}
