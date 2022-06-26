package com.flipkart.service;


import com.flipkart.bean.Student;
import com.flipkart.dao.MockData;
import com.flipkart.bean.*;

import java.util.*;

public  class StudentImplementation implements StudentInterface {


    @Override

    public void register(Student stud) {
        System.out.println("Give you primary preferences");
        Scanner sc=new Scanner(System.in);
        MockData data=MockData.getInstance();
        List courses = new ArrayList<Course>();
        List courses1 = new ArrayList<Course>();
        for (int i=0;i<4;i++){
            System.out.println("Enter course ID");
            int id=sc.nextInt();
            courses.add(data.course.get(id));
        }
        System.out.println("Give you alternative preferences");
        for (int i=0;i<2;i++){
            System.out.println("Enter course ID");
            int id=sc.nextInt();
            courses1.add(data.course.get(id));
        }
        data.registeredCourses.put(stud,courses);
        System.out.println("REGISTRATION SUCCESSFUL");
    }

    @Override
    public void addCourses(Student stud) {
        MockData data = MockData.getInstance();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the course ID to be added");
        int cor=sc.nextInt();
        //Get Registered student list and add in that
        data.registeredCourses.get(stud).add(data.course.get(cor));
        System.out.println("Course added");
    }

    @Override
    public void dropCourses(Student stud) {
        MockData data = MockData.getInstance();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the course ID to be dropped");
        int cor=sc.nextInt();
        //Get Registered student list and remove from that

        data.registeredCourses.get(stud).remove(data.course.get(cor));
        System.out.println("Course removed");
    }

    @Override
    public void feePayment() {
        System.out.println("Choose :");
        System.out.println("1.Online Payment");
        System.out.println("2.Offline Payment");
        Scanner sc=new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice ==1){
            System.out.println("1.Net Banking :");
            System.out.println("2.Card Payment");
            System.out.println("3.UPI");
            //External Payment GateWay
            System.out.println("Choose :");
            int c = sc.nextInt();
            System.out.println("Enter Credentials");
        }
        System.out.println("PAYMENT SUCCESSFUL");

    }



    @Override
    public void viewCourses(Student stud) {
        MockData data=MockData.getInstance();
        List<Course> name=new ArrayList<Course>();
        name=data.registeredCourses.get(stud);
        for(int i =0;i<name.size();i++){
            System.out.print(name.get(i).getCourseId()+"-");
            System.out.println(name.get(i).getCourseName());
        }
    }

    @Override
    public Student fetchStudentData(int id) {




        MockData data = MockData.getInstance();
        return data.student.get(id);

    }

    @Override
    public void viewGradesheet() {
        return ;

    }

    @Override
    public void viewCourseCatalogue() {
        MockData data = MockData.getInstance();
        System.out.println("CourseID : CourseName");
        for (Course iter: data.course.values()){
            System.out.print(iter.getCourseId()+" ");
            System.out.println(iter.getCourseName());
        }
        return ;
    }




}
