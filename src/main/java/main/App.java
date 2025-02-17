package main;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        University university = new University();

        boolean exit = false;

        while(!exit) {
            System.out.println( "1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");
            
            if(sc.hasNext()){
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                        System.out.println("Anna opiskelijan nimi?");
                        String studentName = sc.nextLine();
                        System.out.println("Anna opiskelijan opiskelijanumero:");
                        String stringStudentId = sc.nextLine();
                        int studentId = Integer.parseInt(stringStudentId);

                        Student student = new Student(studentName, studentId);  
                        university.AddStudent(student);
                        break;

                    case 2:
                        System.out.println("Opiskelijat:");
                        university.listStudentsWithId();
                        break;

                    case 3:
                        university.listStudentsWithIndex();
                        System.out.println("Mille opiskelijalle suorite lisätään?");
                        String stringChoice = sc.nextLine();
                        int choice = Integer.parseInt(stringChoice);
                        System.out.println("Mille kurssille suorite lisätään?");
                        String courseName = sc.nextLine();
                        System.out.println("Mikä arvosana kurssille lisätään?");
                        String stringGrade = sc.nextLine();
                        int grade = Integer.parseInt(stringGrade);

                        university.students.get(choice).AddGrade(courseName, grade);
                        break;
                    
                    case 4:
                        university.listStudentsWithIndex();
                        System.out.println("Minkä opiskelijan suoritteet listataan?");
                        stringChoice = sc.nextLine();
                        choice = Integer.parseInt(stringChoice);

                        university.students.get(choice).listGrades();
                        break;
                    
                    case 5:
                        university.listStudentsWithIndex();
                        System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                        stringChoice = sc.nextLine();
                        choice = Integer.parseInt(stringChoice);

                        double average = Calculator.getAverageGrade(university.students.get(choice));
                        System.out.println("Keskiarvo on " + average);
                        break;

                    case 6:
                        university.listStudentsWithIndex();
                        System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                        stringChoice = sc.nextLine();
                        choice = Integer.parseInt(stringChoice);
                        double median = Calculator.getMedianGrade(university.students.get(choice));
                        System.out.println("Mediaani on " + median);
                        break;
                    
                    case 7:
                        university.saveToFile( "students.ser");
                        break;

                    case 8:
                    university.loadFromFile("students.ser");
                    break;

                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;
                    
                    default:
                        System.out.println("Syöte oli väärä");
                        break;
                        
                }
            }
        }
        sc.close();
    }
}
