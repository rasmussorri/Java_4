package main;

import java.io.Serializable;

public class Grade implements Serializable {
    String course;
    int grade;

    public Grade(String course, int grade) {
        this.course = course;
        this.grade = grade;
    }   
}
