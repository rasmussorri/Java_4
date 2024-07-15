package main;

import java.util.ArrayList;
import java.util.Collections;

public class Calculator {
    public static double getAverageGrade(Student student) {
        ArrayList<Grade> grades = student.getGrades();
        if (grades.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (Grade grade : grades) {
            sum += grade.grade;
        }
        return sum / grades.size();
    }

    public static double getMedianGrade(Student student) {
        ArrayList<Grade> grades = student.getGrades();
        if (grades.isEmpty()) {
            return 0;
        }

        ArrayList<Integer> gradeValues = new ArrayList<>();
        for (Grade grade : grades) {
            gradeValues.add(grade.grade);
        }

        Collections.sort(gradeValues);

        int size = gradeValues.size();
        if (size % 2 == 1) {
            return gradeValues.get(size / 2);
        } else {
            return (gradeValues.get(size / 2 - 1) + gradeValues.get(size / 2)) / 2.0;
        }
    }
}
