package com.dropwizard.application;

import com.dropwizard.bean.Admin;
import com.dropwizard.bean.Professor;
import com.dropwizard.bean.Student;
import com.dropwizard.constants.SQLQueriesConstants;
import com.dropwizard.dao.*;
import com.dropwizard.exceptions.*;
import com.dropwizard.utils.DBConnection;

import java.sql.*;
import java.util.Scanner;




public class CRSApplication {

    public static void main(String[] args) throws SQLException, CourseAlreadyExistsException, CourseNotAddedException, CourseNotFoundException, UserAlreadyExistsException, UserNotFoundException, NoRegisteredCoursesException, CourseNotDroppedException, RegistrationUnsuccessfulException, GradeNotAddedException, CourseNotAssignedToProfException, NoStudentRegisteredException, PaymentUnsuccessfulException {

        int menuClick = -1;
        while (menuClick != 4) {
            //shows the menu for user
            Scanner sc = new Scanner(System.in);
            System.out.println("--------------------------------------------------------------");
            System.out.println("\t \t Welcome to CRS Application");
            System.out.println("Enter 1 Login");
            System.out.println("Enter 2 for Register");
            System.out.println("Enter 3 to Update Password");
            System.out.println("Enter 4 to Exit");
            System.out.println("Enter Here:");

            menuClick = sc.nextInt();
            //to login an already existing user
            if (menuClick == 1) {


                MockData data = MockData.getInstance();

                System.out.println("Please enter userId");
                int userName = sc.nextInt();
                System.out.println("Please Enter Password");
                String password = sc.next();
                //fetching role from db
                int reqRole = userName / 100;
                if (reqRole == 1) {

                    StudentDAO SI = new StudentDAOoperation() {
                        @Override
                        public void viewCourseCatalogue() {
                        }
                    };
                    Student s = SI.fetchStudentData((userName));

                    //StudentInterface SI = new StudentImplementation();
                    //Student s = SI.fetchStudentData(userName);

                    StudentCRSMenu stucrs = new StudentCRSMenu();
                    stucrs.showChoices(s);


                } else if (reqRole == 2) {
                    ProfessorDAO PI = new ProfessorDAOoperation();
                    Professor p = PI.fetchProfessorData(userName);
                    ProfessorCRSMenu procrs = new ProfessorCRSMenu();
                    procrs.showChoices(p);

                } else if (reqRole == 3) {
                    AdminDAO AI = new AdminDAOoperation();
                    Admin ad = AI.fetchAdminData(userName);
                    AdminCRSMenu adcrs = new AdminCRSMenu();
                    adcrs.showChoices(ad);

                }
                //to register a new user
            } else if (menuClick == 2) {
                System.out.println("Enter Your Name");
                String name = sc.next();
                System.out.println("Enter Your Password");
                String pass = sc.next();

                Connection connection = DBConnection.getConnection();
                String sql = SQLQueriesConstants.GET_MAX_STUDENT_ID;

                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql);
                int newid = 0;
                while(rs.next()) {
                    newid = rs.getInt("id") + 1;
                }
                if (newid ==1) {
                    newid = 101;
                }
                String sql2 = SQLQueriesConstants.ADD_STUDENT_BY_REGISTER_USER;

                PreparedStatement stmt=connection.prepareStatement(sql2);


                stmt.setInt(1,newid);
                stmt.setString(2,pass);
                stmt.setString(3,name);
                stmt.executeUpdate();

                String sql3 = SQLQueriesConstants.ADD_STUDENT_BY_REGISTER;

                PreparedStatement stmt2=connection.prepareStatement(sql3);

                stmt2.setInt(1,newid);
                stmt2.executeUpdate();

                System.out.println("Your UserID is "+newid);

            //update password
            } else if (menuClick == 3) {
            //exit
            } else {
                System.out.println("Thank you");
            }
//        MockData data = MockData.getInstance();
//        System.out.println(data.professor.get(201).getName());


        }
    }
}
