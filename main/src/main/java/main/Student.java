package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    String studentName;
    int studentId;
    ArrayList<Grade> grades;

    public Student(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }

    public void AddGrade(String course, int grade) {
        grades.add(new Grade(course, grade));
    }
    
    public void listGrades() {
        for (Grade grade : grades) {
            System.out.println("Kurssi: " + grade.course + ", Arvosana: " + grade.grade);
        }
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }
}