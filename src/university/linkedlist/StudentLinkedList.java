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

	public boolean addStudent(Student student) {

		if (student == null) {
			System.out.println("Cannot add an empty student.");
			return false;
		}

		StudentNode current = first;

		while (current != null) {
			if (current.getData().getStudentId() == student.getStudentId()) {
				System.out.println("Student ID already exists: " + student.getStudentId());
				return false;
			}

			current = current.getNext();
		}

		StudentNode newNode = new StudentNode(student);

		if (first == null) {
			first = newNode;
		} else {
			current = first;

			while (current.getNext() != null) {
				current = current.getNext();
			}

			current.setNext(newNode);
		}

		System.out.println("Student added successfully: " + student.getStudentId());

		return true;
	}

	public void displayStudents() {

		if (isEmpty()) {
			System.out.println("Student linked list is empty.");
			return;
		}

		System.out.println("\n===== STUDENT LINKED LIST =====");

		StudentNode current = first;

		while (current != null) {
			current.getData().displayStudent();
			System.out.println("------------------------------");
			current = current.getNext();
		}
	}
}
