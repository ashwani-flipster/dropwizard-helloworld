package com.dropwizard.service;

import com.dropwizard.bean.Course;
import com.dropwizard.dao.MockData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseCatalogImplementation implements CourseCatalogInterface {
    @Override

    public HashMap<Integer, Course> fetchCoursesList() {

        MockData data = MockData.getInstance();
        return data.course;
        //return null;
    }
}
