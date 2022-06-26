package com.dropwizard.dao;

import com.dropwizard.bean.Student;
import com.dropwizard.constants.SQLQueriesConstants;
import com.dropwizard.exceptions.*;
import com.dropwizard.utils.DBConnection;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * Class to implement Student Dao Operations
 *
 */
public class StudentDAOoperation implements StudentDAO{
    private PreparedStatement statement = null;

    /**
     * Method to register student in a course from database
     * @param stud: student object containing all the fields
     * @return
     * @throws RegistrationUnsuccessfulException
     */
    @Override
    public void register(Student stud) throws SQLException, RegistrationUnsuccessfulException {

        Scanner sc=new Scanner(System.in);
        Connection connection = DBConnection.getConnection();

        try {
            String sql = SQLQueriesConstants.GET_REGISTERED_COURSE_STUDENT_ID;
            int stdid=stud.getUserId();
            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1,stdid);
            boolean flag=false;
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                flag=true;
            }
            if (flag)
                throw new RegistrationUnsuccessfulException();

            sql = SQLQueriesConstants.REGISTER_COURSE;

            stmt=connection.prepareStatement(sql);

            System.out.println("Give you primary preferences");
            //System.out.println(stdid+"hi bro");
            //to fill 4 primary courses in the preference list
            for (int i=0;i<4;i++){
                System.out.println("Enter course ID");
                int courseid=sc.nextInt();
                stmt.setInt(1,courseid);
                stmt.setInt(2,stdid);
                stmt.execute();

            }
            System.out.println("Give you alternative preferences");
            //to fill 2 alternative courses in preference list
            for (int i=0;i<2;i++){
                System.out.println("Enter course ID");
                int id=sc.nextInt();
            }

        } catch (SQLException se) {

            System.out.println(se.getMessage());
            //throw new RegistrationUnsuccessfulException();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());

        }

    }

    /**
     * Method to fetch student data from database
     * @param id: student id
     * @return student object containing all the fields
     * @throws UserNotFoundException
     */
    @Override
    public Student fetchStudentData(int id) throws SQLException, UserNotFoundException {
        Connection connection = DBConnection.getConnection();
        System.out.println("Done");

        try {
            Student stud = new Student();
            String sql = SQLQueriesConstants.GET_USER_BY_ID;
            statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            boolean flag = false;
            while (rs.next()) {
                String sql2 = SQLQueriesConstants.GET_STUDENT_BY_ID;
                PreparedStatement statement2=connection.prepareStatement(sql2);
                statement2.setInt(1,id);
                ResultSet rs2 = statement2.executeQuery();

                while (rs2.next()) {
                    int test = rs2.getInt("is_approved");
                    if (test == 0) {
                        System.out.println("Waiting for admin approval");
                        return null;
                    }
                }
                stud.setUserId(rs.getInt("id"));
                stud.setName(rs.getString("name"));
                stud.setType(rs.getInt("type"));
                stud.setPassword(rs.getString("password"));
                flag = true;
            }
            if(!flag){
                throw new UserNotFoundException(id);
            }
            return stud;
        } catch (SQLException se) {
            throw new UserNotFoundException(id);
        }
    }

    /**
     * Method to view gradesheet after grade assigned by the professor
     * @param id: student id
     * @return
     * @throws NoRegisteredCoursesException
     */
    @Override
    public void viewGradesheet(int id) throws SQLException, NoRegisteredCoursesException {
        Connection connection = DBConnection.getConnection();
        System.out.println("Done");

        try {
            String sql = SQLQueriesConstants.GET_REGISTERED_COURSE_STUDENT_ID;
            statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            System.out.println("Course ID    Course Name    Grade");
            boolean flag = false;
            while (rs.next()) {
                flag = true;
                int cid=rs.getInt("course_id");
                String sql2=SQLQueriesConstants.GET_COURSE_BY_ID;
                PreparedStatement st2=connection.prepareStatement(sql2);
                st2.setInt(1,cid);
                ResultSet rs2=st2.executeQuery();

                while(rs2.next()){
                    System.out.println(cid+"    "+rs2.getString("course_name")+"    "+rs.getString("grade"));
                }
            }

            if (!flag) {
                throw new NoRegisteredCoursesException(id);
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            throw se;
        }
    }

    /**
     * Method to view course course catalogue
     * @return
     * @throws SQLException
     */
    @Override
    public void viewCourseCatalogue() throws SQLException {
        Connection connection = DBConnection.getConnection();
        System.out.println("Done");
        String sql = SQLQueriesConstants.GET_COURSE_CATALOG;
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        System.out.println("CourseID - Course-Name");
        while(rs.next()){
            System.out.println(rs.getInt("id")+"    "+rs.getString("course_name"));//+"     "+rs.getInt("strength"));
        }
    }

    /**
     * method to add course in database from course catalogue
     * @param stud: student object containing all fields
     * @return
     * @throws CourseNotAddedException
     */
    @Override
    public void addCourses(Student stud) throws SQLException, CourseNotAddedException {
        System.out.println("Add Course");
        Scanner sc=new Scanner(System.in);
        Connection connection = DBConnection.getConnection();

        try {
            String sql = SQLQueriesConstants.STUDENT_ADD_COURSE;

            PreparedStatement stmt=connection.prepareStatement(sql);
            int stdid=stud.getUserId();
            //System.out.println(stdid+"hi bro");

            System.out.println("Enter course ID");
            int courseid=sc.nextInt();
            stmt.setInt(1,courseid);
            stmt.setInt(2,stdid);
            stmt.execute();

//            //boolean flag = false;
////            while (rs.next()) {
////                flag = true;
////            }
//            if(!rs) {
//                throw new CourseNotAddedException();
//            }
            System.out.println("Course added");


        } catch (SQLException se) {
            System.out.println(se.getMessage());
            System.out.println("Course not added");
        }
//        catch (CourseNotAddedException se) {
//            System.out.println(se.getMessage());
//            //System.out.println("Course not added");
//        }

    }

    /**
     * method to drop course selected by student
     * @param stud: student object containing all fields
     * @return
     * @throws CourseNotDroppedException
     */
    @Override
    public void dropCourses(Student stud) throws SQLException, CourseNotDroppedException,CourseNotFoundException {
        System.out.println("Drop Course");
        Scanner sc=new Scanner(System.in);
        Connection connection = DBConnection.getConnection();

        try {
            String sql = SQLQueriesConstants.STUDENT_DROP_COURSE;

            PreparedStatement stmt=connection.prepareStatement(sql);
            int stdid=stud.getUserId();
            //System.out.println(stdid+"hi bro");
            System.out.println("Enter course ID");
            int courseid=sc.nextInt();
            String sql2 = SQLQueriesConstants.GET_COURSE_BY_ID;
            PreparedStatement stmt2=connection.prepareStatement(sql2);
            stmt2.setInt(1,courseid);
            ResultSet rs = stmt2.executeQuery();
            boolean flag = false;
            while (rs.next()) {
                flag = true;
            }
            if(!flag) {
                throw new CourseNotFoundException(courseid);
            }

            stmt.setInt(1,courseid);
            stmt.setInt(2,stdid);
            stmt.execute();
//            boolean flag2 = false;
//            while (rs2.next()) {
//                flag2 = true;
//            }
//
//
//            if(!flag2) {
//                //System.out.println("false");
//                throw new CourseNotDroppedException();
//            }
            System.out.println("Course dropped");


        } catch (SQLException se) {
            System.out.println(se.getMessage());
           System.out.println("You don't have such registered course");
//            throw new CourseNotDroppedException();
        }catch (CourseNotFoundException s) {

            System.out.println(s.getMessage());
            System.out.println("Course not dropped");
//            throw new CourseNotFoundException();
        }



    }

    /**
     * method to pay fee by student for the selected course from database
     * @param stud: student object containing all fields
     * @return
     * @throws PaymentUnsuccessfulException
     */
    @Override
    public void feePayment(Student stud) throws SQLException, PaymentUnsuccessfulException {
        Connection connection = DBConnection.getConnection();

        int stdid=stud.getUserId();

        try {
            String sql = SQLQueriesConstants.STUDENT_GET_PAYMENT_STATUS;
            statement=connection.prepareStatement(sql);
            statement.setInt(1,stdid);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int pay_status = rs.getInt("status");

                if(pay_status == 1) {
                    //System.out.println("Fee already paid.");
                    throw new PaymentAlreadyExistsException();
                }
            }

            Scanner sc=new Scanner(System.in);
            System.out.println("Enter payment mode:");
            System.out.println("1. Cash");
            System.out.println("2. Debit Card");
            System.out.println("3. Credit Card");
            int paymentMode = sc.nextInt();
            sql = SQLQueriesConstants.STUDENT_SET_PAYMENT;
            statement=connection.prepareStatement(sql);
            statement.setInt(1, stdid);
            statement.setInt(2, paymentMode);
            statement.setInt(3, 1);
            statement.execute();
            System.out.println("Fee  paid.");

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } catch (PaymentAlreadyExistsException e) {

            System.out.println(e.getMessage());

        }
    }

    /**
     * method to view selected course list
     * @param id: student id
     * @return
     * @throws NoRegisteredCoursesException
     */
    @Override
    public void viewCourses(int id) throws SQLException, NoRegisteredCoursesException {
        Connection connection = DBConnection.getConnection();
        System.out.println("Done");

        try {
            String sql = SQLQueriesConstants.GET_REGISTERED_COURSE_STUDENT_ID;
            statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            System.out.println("Course ID    Course Name");

            boolean flag = false;

            while (rs.next()) {
                flag = true;
                int cid=rs.getInt("course_id");
                String sql2=SQLQueriesConstants.GET_COURSE_BY_ID;
                PreparedStatement st2=connection.prepareStatement(sql2);
                st2.setInt(1,cid);
                ResultSet rs2=st2.executeQuery();

                while(rs2.next()){
                    System.out.println(cid+"    "+rs2.getString("course_name"));
                }
            }

            if (!flag) {
                throw new NoRegisteredCoursesException(id);
            }
        } catch (SQLException se) {
            throw new NoRegisteredCoursesException(id);
        }


    }
}
