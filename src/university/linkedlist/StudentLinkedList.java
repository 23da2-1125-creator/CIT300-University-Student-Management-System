package university.linkedlist;

import university.model.Student;

public class StudentLinkedList {

    private StudentNode first;

    public StudentLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    // Add a new student to the end of the list
    public boolean addStudent(Student student) {

        if (student == null) {
            System.out.println(
                "Cannot add an empty student."
            );
            return false;
        }

        StudentNode current = first;

        while (current != null) {
            if (current.getData().getStudentId()
                    == student.getStudentId()) {

                System.out.println(
                    "Student ID already exists: "
                    + student.getStudentId()
                );

                return false;
            }

            current = current.getNext();
        }

        StudentNode newNode =
            new StudentNode(student);

        if (first == null) {
            first = newNode;
        } else {
            current = first;

            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(newNode);
        }

        System.out.println(
            "Student added successfully: "
            + student.getStudentId()
        );

        return true;
    }

    // Display all students
    public void displayStudents() {

        if (isEmpty()) {
            System.out.println(
                "Student linked list is empty."
            );
            return;
        }

        System.out.println(
            "\n===== STUDENT LINKED LIST ====="
        );

        StudentNode current = first;

        while (current != null) {
            current.getData().displayStudent();
            current = current.getNext();
        }
    }

    // Search for a student using Student ID
    public Student searchStudent(int studentId) {

        StudentNode current = first;

        while (current != null) {
            if (current.getData().getStudentId()
                    == studentId) {

                System.out.println("Student found:");
                current.getData().displayStudent();

                return current.getData();
            }

            current = current.getNext();
        }

        System.out.println(
            "Student not found: " + studentId
        );

        return null;
    }

    // Update an existing student
    public boolean updateStudent(
            int studentId,
            String newName,
            String newProgramme,
            double newMarks) {

        StudentNode current = first;

        while (current != null) {
            if (current.getData().getStudentId()
                    == studentId) {

                current.getData().setName(newName);
                current.getData().setProgramme(
                    newProgramme
                );
                current.getData().setMarks(newMarks);

                System.out.println(
                    "Student updated successfully: "
                    + studentId
                );

                return true;
            }

            current = current.getNext();
        }

        System.out.println(
            "Cannot update. Student not found: "
            + studentId
        );

        return false;
    }

    // Delete a student using Student ID
    public boolean deleteStudent(int studentId) {

        if (isEmpty()) {
            System.out.println(
                "Cannot delete. "
                + "Student linked list is empty."
            );
            return false;
        }

        StudentNode current = first;
        StudentNode previous = null;

        while (current != null) {
            if (current.getData().getStudentId()
                    == studentId) {

                if (previous == null) {
                    first = current.getNext();
                } else {
                    previous.setNext(
                        current.getNext()
                    );
                }

                System.out.println(
                    "Student deleted successfully: "
                    + studentId
                );

                return true;
            }

            previous = current;
            current = current.getNext();
        }

        System.out.println(
            "Cannot delete. Student not found: "
            + studentId
        );

        return false;
    }
}