package com.flipkart.controller;

import com.flipkart.application.AdminCRSMenu;
import com.flipkart.application.ProfessorCRSMenu;
import com.flipkart.application.StudentCRSMenu;
import com.flipkart.bean.Admin;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constants.SQLQueriesConstants;
import com.flipkart.dao.*;
import com.flipkart.entity.UpdatePasswordEntity;
import com.flipkart.entity.UserLoginEntity;
import com.flipkart.entity.UserRegisterEntity;
import com.flipkart.exceptions.*;
import com.flipkart.utils.DBConnection;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;

import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/students")
public class StudentRestController {
    private final Validator validator;

    public StudentRestController(Validator validator) {
        this.validator = validator;
    }

    @GET
    @Path("/view_course_catalog")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response viewCourseCatalog() throws URISyntaxException, UserNotFoundException, SQLException, NoRegisteredCoursesException, CourseNotAddedException, PaymentUnsuccessfulException, CourseNotDroppedException, RegistrationUnsuccessfulException, CourseNotFoundException {
        // validation

        // calling dao
        StudentDAO si = new StudentDAOoperation();
        ArrayList<String> res = si.viewCourseCatalogue();

        return Response.status(200).entity(res).build();
    }

}