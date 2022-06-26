package com.dropwizard.service;
import com.dropwizard.bean.*;
import java.util.*;
public interface CourseCatalogInterface {
    public HashMap<Integer,Course> fetchCoursesList();
}
