package university.linkedlist;

import university.model.Student;

public class LinkedListTest {

	public static void main(String[] args) {

		StudentLinkedList studentList = new StudentLinkedList();

		System.out.println("===== ADD STUDENT TEST =====");

		studentList.addStudent(new Student(1001, "Nipuna", "BAIT", 75.5));

		studentList.addStudent(new Student(1002, "Aravinda", "BAIT", 78.0));

		studentList.addStudent(new Student(1003, "Prashani", "BAIT", 69.5));

		studentList.displayStudents();

		System.out.println("\n===== DUPLICATE ID TEST =====");

		studentList.addStudent(new Student(1002, "Duplicate Student", "BAIT", 60.0));
	}
}