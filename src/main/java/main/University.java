package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class University {
    ArrayList<Student> students = new ArrayList<>();

    public void AddStudent(Student student) {
        students.add(student);
    }

    public void listStudentsWithId() {
        for (Student student : students) {
            System.out.println(student.studentId + ": " + student.studentName);
        }
    }

    public void listStudentsWithIndex() {
        int i = 0;
        for (Student student : students) {
            System.out.println(i + ": " + student.studentName);
            i++;
        }
    }

    public void saveToFile(String filename) {
        try {
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(filename));
            fileWriter.writeObject(students);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Tiedoston tallentaminen epäonnistui");
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        try {
            ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(filename));
            students = (ArrayList<Student>) fileReader.readObject();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Tietojen lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Tietojen lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Tietojen lukeminen ei onnistunut");
            e.printStackTrace();
        }
    }
}

