package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.dao.MockData;

import java.util.HashMap;

public class CourseCatalogImplementation implements CourseCatalogInterface {
    @Override

    public HashMap<Integer, Course> fetchCoursesList() {

        MockData data = MockData.getInstance();
        return data.course;
        //return null;
    }
}
