package university.main;

import university.model.Student;

public class Main {

    public static void main(String[] args) {

        System.out.println(
                "UNIVERSITY STUDENT MANAGEMENT SYSTEM");
        System.out.println("==============================");

        Student student = new Student(
                1001,
                "Test Student",
                "BAIT",
                75.5
        );

        student.displayStudent();
    }
}