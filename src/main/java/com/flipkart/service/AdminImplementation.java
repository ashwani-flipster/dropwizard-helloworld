package com.flipkart.service;


import com.flipkart.dao.MockData;



import com.flipkart.bean.*;
import java.util.*;
public class AdminImplementation implements AdminInterface{
    @Override
    public Admin fetchAdminData(int id) {
        MockData data = MockData.getInstance();
        return data.admin.get(id);
    }

    @Override
    public void approveStudent() {
        System.out.println("Enter your Name");
        Scanner sc = new Scanner(System.in);
        String newstudname = sc.next();
        System.out.println("Enter your password");
        sc.next();

        Student student = new Student();
        MockData data = MockData.getInstance();
        int currentSize = data.student.size();

        Student studreg = new Student();
        studreg.setUserId(currentSize+101);
        studreg.setName(newstudname);
        studreg.setType(1);
        studreg.setStudentId(currentSize+101);
        data.student.put(studreg.getUserId(), studreg);
        System.out.println("Your UserID is "+studreg.getUserId());
        System.out.println("Your StudentID is "+studreg.getStudentId());
    }

    @Override
    public void generateReportCard() {

    }

    @Override
    public void addProfessor() {
        Scanner sc = new Scanner(System.in);
        Professor prof = new Professor();
        System.out.println("Enter userid for new professor");
        int profid = sc.nextInt();
        prof.setUserId(profid);
        System.out.println("Enter new Professor Name");
        String profname = sc.next();
        prof.setName(profname);
        int profrole = 2;
        prof.setType(profrole);
        MockData data = MockData.getInstance();
        data.professor.put(prof.getUserId(),prof);
    }

    @Override
    public void updateCatalogue(int addOrdrop) {
        MockData data = MockData.getInstance();
        Scanner sc = new Scanner(System.in);
        switch (addOrdrop) {
            case 1:
                System.out.println("Enter Course Details for adding course");
                System.out.println("Enter Course ID");
                int cida = sc.nextInt();
                System.out.println("Enter Course Name");
                String cnamea = sc.next();
                Course newcoursea = new Course();
                newcoursea.setCourseId(cida);
                newcoursea.setCourseName(cnamea);
                newcoursea.setStatus(0);
                data.course.put(newcoursea.getCourseId(), newcoursea);
                break;
            case 2:
                System.out.println("Enter Course Details for dropping course");
                System.out.println("Enter Course ID");
                int cidd = sc.nextInt();
                data.course.remove(cidd);
                break;
        }
    }

    @Override
    public void assignCourseToStudent() {


    }
}
