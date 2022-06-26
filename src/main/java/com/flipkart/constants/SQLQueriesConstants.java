package com.flipkart.constants;

public class SQLQueriesConstants {
    public static final String GET_USER_BY_ID= "select * from user where id = ?;";

    public static final String GET_STUDENT_BY_ID= "select * from student where id = ?;";
    public static final String GET_STUDENT_TO_APPROVE="select * from student where is_approved= 0 ;";
    public static final String REGISTER_COURSE="insert into registeredCourses(course_id,student_id) values(?,?)";
    public static final String GIVE_GRADE="update registeredCourses set grade=? where course_id=? and student_id=?";
    public static final String ADD_COURSE_ADMIN="insert into course(id,course_name,status,strength) values(?,?,0,0) ";
    public static final String DELETE_COURSE_ADMIN="delete from course where id=? ";
    public static final String GET_COURSE_BY_ID="select * from course where id=? ";


    public static final String GET_MAX_STUDENT_ID="select MAX(id) as id  from student ";


    public static final String ADD_STUDENT_BY_REGISTER_USER="insert into user (id,password,name,type) values (?,?,?,1); ";


    public static final String ADD_STUDENT_BY_REGISTER="insert into student (id,is_approved) values (?,0); ";

    public static final String STUDENT_DROP_COURSE="delete from registeredCourses where course_id=? and student_id=?   ";
    public static final String STUDENT_ADD_COURSE="insert into registeredCourses(course_id,student_id) values(?,?) ";

    public static final String GET_REGISTERED_COURSE_STUDENT_ID="select * from registeredCourses where student_id=? ";

    public static final String GET_COURSE_CATALOG="select * from course";

    public static final String APPROVE_STUDENT_BY_ID="update student set is_approved=1 where id=? ;";

    public static final String CHOOSE_COURSE_PROF_LIST="select * from course where status =0;";

    public static final String CHOOSE_COURSE_PROF_SELECT = "update course set status=1,professor_id = ? where id=?;";
    public static final String VIEW_STUDENT_LIST_COURSEID = "select * from course where professor_id=?;";

    public static final String VIEW_STUDENT_LIST_STUDENTID = "select * from registeredcourses where course_id =?;";

    public static final String VIEW_STUDENT_LIST_STUDENTNAME = "select * from user where id=?;";
    public static final String ADD_PROFESSOR_SET_USER = "insert into user (id,password,name,type) values (?,?,?,?); ";
    public static final String ADD_PROFESSOR_SET_PROF = "insert into professor (id,dept_id) values (?,?) ;";

    public static final String STUDENT_GET_PAYMENT_STATUS = "select status from payment where student_id = ? ;";

    public static final String STUDENT_SET_PAYMENT = "insert into payment (student_id,payment_mode,status) values (?,?,?) ;";

    public static final String SEND_NOTIFICATION = "insert into notification (user_id, message, type) values (?, ?, ?);";

}
