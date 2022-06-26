package com.flipkart.bean;

import java.util.List;

public class GradeCard {
    public int studentId;
    List<RegisteredCourse> gradeCards;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<RegisteredCourse> getGradeCards() {
        return gradeCards;
    }

    public void setGradeCards(List<RegisteredCourse> gradeCards) {
        this.gradeCards = gradeCards;
    }
}
