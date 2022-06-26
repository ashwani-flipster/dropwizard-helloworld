package com.dropwizard.application;

import com.dropwizard.bean.Professor;
import com.dropwizard.dao.ProfessorDAO;
import com.dropwizard.dao.ProfessorDAOoperation;
import com.dropwizard.exceptions.CourseNotAssignedToProfException;
import com.dropwizard.exceptions.GradeNotAddedException;
import com.dropwizard.exceptions.NoStudentRegisteredException;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProfessorCRSMenu {
    public static void showChoices(Professor professor) throws SQLException, CourseNotAssignedToProfException, NoStudentRegisteredException, GradeNotAddedException {
        int choice = 0;
        System.out.println("Hello " + professor.getName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
        LocalDateTime now = LocalDateTime.now();
        String dateTimeString = now.format(formatter);
        System.out.println(dateTimeString+", ");

        Scanner sc = new Scanner(System.in);
        while (choice != -1) {
            ProfessorDAO PI = new ProfessorDAOoperation();
            System.out.println("1. Choose Course");
            System.out.println("2. View Student List ");
            System.out.println("3. Assign Grade");

            System.out.println("-1. exit");
            System.out.println("Enter a choice :");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    //choose course from catalogue which professor wants to teach
                    PI.chooseCourse(professor.getUserId());
                    break;
                case 2:
                    //view list of students in respective course
                    PI.viewStudentsList(professor.getUserId());
                    break;
                case 3:
                    //assign grade to students
                    PI.assignGrade(professor.getUserId());
                    break;


            }

        }
    }
}
