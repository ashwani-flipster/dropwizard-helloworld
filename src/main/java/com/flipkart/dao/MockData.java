package com.flipkart.dao;

import com.flipkart.bean.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MockData {
    private static MockData single_instance = null;
    public HashMap<Integer,Student> student;
    public HashMap<Integer,Professor> professor;
    public HashMap<Integer,Admin> admin;


    public HashMap<Integer, Course> course;


    public HashMap<Student, List<Course>> registeredCourses;
    public HashMap<Student,List<Pair<Course, Grade>>> gradeSheet;

    private MockData(){

        this.gradeSheet =  new HashMap<Student,List<Pair<Course, Grade>>>();;
        this.registeredCourses = new HashMap<Student,List<Course>>();

        this.student = new HashMap<Integer,Student>();
        Student s1 = new Student();
        s1.setStudentId(101);
        s1.setName("Datta");
        s1.setType(1);
        s1.setUserId(101);
        this.student.put(101,s1);
        Student s2 = new Student();
        s2.setStudentId(102);
        s2.setName("Rohit");
        s2.setType(1);
        s2.setUserId(102);
        this.student.put(102,s2);

        Student s3 = new Student();
        s3.setStudentId(103);
        s3.setName("Ashok");
        s3.setType(1);
        s3.setUserId(103);
        this.student.put(103,s3);


        //Hard code data of Professor
        this.professor = new HashMap<Integer,Professor>();

        Professor p1 = new Professor();
        p1.setName("Datta");
        p1.setType(2);
        p1.setUserId(201);
        this.professor.put(201,p1);

        Professor p2 = new Professor();
        p2.setName("Arbab");
        p2.setType(2);
        p2.setUserId(202);
        this.professor.put(202,p2);

        Professor p3 = new Professor();
        p3.setName("Firoz");
        p3.setType(2);
        p3.setUserId(203);
        this.professor.put(203,p3);

        Professor p4 = new Professor();
        p4.setName("Shafali");
        p4.setType(2);
        p4.setUserId(204);
        this.professor.put(204,p4);

        Professor p5 = new Professor();
        p5.setName("Prakhar");
        p5.setType(2);
        p5.setUserId(205);
        this.professor.put(205,p5);

        Professor p6 = new Professor();
        p6.setName("Amit");
        p6.setType(2);
        p6.setUserId(206);
        this.professor.put(206,p6);


        //Hard code Data of Admin

        this.admin = new HashMap<Integer,Admin>();
        Admin s5 = new Admin();
        s5.setName("SS");
        s5.setType(3);
        s5.setUserId(301);
        this.admin.put(301,s5);

        // Hard code Courses


        Course course1 = new Course();
        course1.setCourseId(1);
        course1.setCourseName("POIS");

        course1.setStatus(1);

        course1.setProfessor(p1);
        course1.setStatus(1);

        Course course2 = new Course();
        course2.setCourseId(2);
        course2.setCourseName("Operating Systems");
        course2.setProfessor(p2);
        course2.setStatus(1);

        Course course3 = new Course();
        course3.setCourseId(3);
        course3.setCourseName("DSA");
        course3.setProfessor(p3);
        course3.setStatus(1);

        Course course4 = new Course();
        course4.setCourseId(4);
        course4.setCourseName("Java Basics");
        course4.setProfessor(p4);
        course4.setStatus(1);

        Course course5 = new Course();
        course5.setCourseId(5);
        course5.setCourseName("Python Basics");
        course5.setProfessor(p5);
        course5.setStatus(1);

        Course course6 = new Course();
        course6.setCourseId(6);
        course6.setCourseName("Python Advanced");
        course6.setStatus(0);


        this.course = new HashMap<Integer,Course>();
        this.course.put(1,course1);
        this.course.put(2,course2);
        this.course.put(3,course3);
        this.course.put(4,course4);
        this.course.put(5,course5);
        this.course.put(6,course6);


        //hardcoding data for registered courses
        List<Course> al1 = new ArrayList<Course>();
        al1.add(course1);
        al1.add(course2);
        al1.add(course3);
        al1.add(course4);
        this.registeredCourses.put(s1,al1);
        List<Course> al2 = new ArrayList<Course>();
        al2.add(course2);
        al2.add(course3);
        al2.add(course4);
        al2.add(course5);
        this.registeredCourses.put(s2,al2);
        List<Course> al3 = new ArrayList<Course>();
        al3.add(course3);
        al3.add(course4);
        al3.add(course5);
        al3.add(course1);
        this.registeredCourses.put(s3,al3);

        List<Pair<Course,Grade>> g1 = new ArrayList<Pair<Course,Grade>>();
        this.gradeSheet.put(s1,g1);
        this.gradeSheet.put(s2,g1);
        this.gradeSheet.put(s3,g1);

    }


    public static MockData getInstance(){
        if(single_instance == null) {
            single_instance = new MockData();
        }
        return single_instance;

    }


}
