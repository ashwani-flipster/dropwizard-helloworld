package com.flipkart.dao;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.exceptions.*;
import com.flipkart.utils.DBConnection;

import java.sql.*;
import java.util.Scanner;


public class AdminDAOoperation implements AdminDAO {

    private PreparedStatement statement = null;

    /**
     * Function to fetch admin data where admin logs into the system.
     * @throws UserNotFoundException
     * @throws SQLException
     */
    @Override
    public Admin fetchAdminData(int id) throws SQLException, UserNotFoundException {
        // For admin login
        Connection connection = DBConnection.getConnection();
        System.out.println("Done");

        Admin ad=new Admin();

        try {
            String sql = SQLQueriesConstants.GET_USER_BY_ID;
            statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            boolean flag = false;
            while (rs.next()) {
                ad.setUserId(rs.getInt("id"));
                ad.setName(rs.getString("name"));
                ad.setType(rs.getInt("type"));
                ad.setPassword(rs.getString("password"));
                flag = true;
            }
            if(!flag){
                throw new UserNotFoundException(id);
            }
        } catch(SQLException se) {
            throw new UserNotFoundException(id);
        }


        return ad;

    }

    /**
     * Approve Student using SQL commands
     */
    @Override
    public void approveStudent() throws SQLException {
        // Approves students to be approved
        Connection connection = DBConnection.getConnection();

        Student stud=new Student();

        boolean flag=false;
        try {
            String sql = SQLQueriesConstants.GET_STUDENT_TO_APPROVE;
            statement=connection.prepareStatement(sql);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id=rs.getInt("id");
                System.out.println(id+"to be approved");
                String postsql=SQLQueriesConstants.APPROVE_STUDENT_BY_ID;

                statement=connection.prepareStatement(postsql);
                statement.setInt(1,id);
                statement.executeUpdate();
                System.out.println(id+"approved");
            }
            // check if approval is done
            sql = SQLQueriesConstants.GET_STUDENT_TO_APPROVE;
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                flag=true;
                int id=rs.getInt("id");
                System.out.println(id+"not approved");
            }
            if (!flag)
                System.out.println("No student to be approved");
        }
        catch(SQLException se) {
            System.out.println(se.getMessage());
        }
    }

    @Override
    public void generateReportCard() {
        // add status of report card
    }

    /**
     * Function to add professor to database using SQL commands
     * @throws SQLException
     */
    @Override
    public void addProfessor() throws SQLException, UserAlreadyExistsException {
        // add professor
        Scanner sc = new Scanner(System.in);
        Professor prof = new Professor();
        System.out.println("Enter userid for new professor");
        int profid = sc.nextInt();
        prof.setUserId(profid);
        System.out.println("Enter new Professor Name");
        String profname = sc.next();
        System.out.println("Enter new Professor Dept ID");
        int deptid = sc.nextInt();
        int profrole = 2;
        String pass = "1234";

        try {
            Connection connection = DBConnection.getConnection();

            String sql = SQLQueriesConstants.ADD_PROFESSOR_SET_USER; // add in user table

            PreparedStatement stmt=connection.prepareStatement(sql);
            stmt.setInt(1,profid);
            stmt.setString(2,pass);
            stmt.setString(3,profname);
            stmt.setInt(4,profrole);
            stmt.executeUpdate();

            sql = SQLQueriesConstants.ADD_PROFESSOR_SET_PROF; // add in professor table
            PreparedStatement stmt2=connection.prepareStatement(sql);
            stmt2.setInt(1,profid);
            stmt2.setInt(2,deptid);
            stmt2.executeUpdate();

        }
        catch (SQLException se) {
            //throw new UserAlreadyExistsException(profid);
            System.out.println(se.getMessage());
        }
    }

    /**
     * Add or Delete Course from Catalogue using SQL commands
     * @param addOrdrop
     * @throws CourseNotFoundException
     * @throws CourseNotDeletedException
     * @throws SQLException
     */
    @Override
    public void updateCatalogue(int addOrdrop) throws SQLException, CourseAlreadyExistsException, CourseNotFoundException {
        // add or drop course from catalogue
        Scanner sc = new Scanner(System.in);
        Connection connection = DBConnection.getConnection();
        switch (addOrdrop) {
            case 1:
                System.out.println("Enter Course Details for adding course");
                System.out.println("Enter Course ID");
                int cida = sc.nextInt();
                System.out.println("Enter Course Name");
                String cnamea = sc.next();
                try {
                    String sql = SQLQueriesConstants.GET_COURSE_BY_ID;
                    PreparedStatement stmt=connection.prepareStatement(sql);
                    stmt.setInt(1,cida);
                    ResultSet rs = stmt.executeQuery();
                    boolean flag = true;
                    while (rs.next()) {
                        flag = false;
                    }
                    if(!flag) {
                        throw new CourseAlreadyExistsException(cida);
                    }

                    sql = SQLQueriesConstants.ADD_COURSE_ADMIN;
                    stmt=connection.prepareStatement(sql);
                    stmt.setInt(1,cida);
                    stmt.setString(2,cnamea);
                    stmt.executeUpdate();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.println("Enter Course Details for dropping course");
                System.out.println("Enter Course ID");
                int cidd = sc.nextInt();
                try {
                    String sql = SQLQueriesConstants.GET_COURSE_BY_ID;
                    PreparedStatement stmt=connection.prepareStatement(sql);
                    stmt.setInt(1,cidd);
                    ResultSet rs = stmt.executeQuery();
                    boolean flag = false;
                    while (rs.next()) {
                        flag = true;
                    }
                    if(!flag) {
                        throw new CourseNotFoundException(cidd);
                    }


                    sql = SQLQueriesConstants.DELETE_COURSE_ADMIN;
                    stmt=connection.prepareStatement(sql);
                    stmt.setInt(1,cidd);
                    stmt.execute();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    //throw new CourseNotAddedException();

                }

                break;
        }
    }

    /**
     * Function for admin to list the courses in catalogue.
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

    @Override
    public void assignCourseToStudent() {
        // approve assignment
    }
}
