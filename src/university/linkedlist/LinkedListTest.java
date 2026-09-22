package university.linkedlist;

import university.model.Student;

public class LinkedListTest {

    public static void main(String[] args) {

        StudentLinkedList studentList =
            new StudentLinkedList();

        System.out.println(
            "===== ADD STUDENT TEST ====="
        );

        studentList.addStudent(
            new Student(1001, "Nipuna", "BAIT", 75.5)
        );

        studentList.addStudent(
            new Student(1002, "Aravinda", "BAIT", 78.0)
        );

        studentList.addStudent(
            new Student(1003, "Prashani", "BAIT", 69.5)
        );

        studentList.displayStudents();

        System.out.println(
            "\n===== DUPLICATE ID TEST ====="
        );

        studentList.addStudent(
            new Student(
                1002,
                "Duplicate Student",
                "BAIT",
                60.0
            )
        );

        System.out.println(
            "\n===== SEARCH STUDENT TEST ====="
        );

        studentList.searchStudent(1002);

        System.out.println(
            "\n===== STUDENT NOT FOUND TEST ====="
        );

        studentList.searchStudent(9999);

        System.out.println(
            "\n===== UPDATE STUDENT TEST ====="
        );

        studentList.updateStudent(
            1003,
            "Prashani Silva",
            "BSc IT",
            85.0
        );

        studentList.displayStudents();

        System.out.println(
            "\n===== DELETE STUDENT TEST ====="
        );

        studentList.deleteStudent(1001);

        studentList.displayStudents();

        System.out.println(
            "\n===== DELETE NOT FOUND TEST ====="
        );

        studentList.deleteStudent(9999);
    }
}