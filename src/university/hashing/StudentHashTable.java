package university.hashing;

import university.model.Student;

public class StudentHashTable {

	private static class HashNode {
		Student student;
		HashNode next;

		HashNode(Student student) {
			this.student = student;
		}
	}

	private final HashNode[] table;
	private final int capacity;
	private int size;

	public StudentHashTable(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be greater than zero.");
		}

		this.capacity = capacity;
		this.table = new HashNode[capacity];
		this.size = 0;
	}

	private int hash(int studentId) {
		return Math.floorMod(studentId, capacity);
	}

	// Insert a student into the hash table
	public void insert(Student student) {
		int index = hash(student.getStudentId());
		HashNode current = table[index];

		while (current != null) {
			if (current.student.getStudentId() == student.getStudentId()) {
				System.out.println("Student ID already exists: " + student.getStudentId());
				return;
			}

			current = current.next;
		}

		HashNode newNode = new HashNode(student);
		newNode.next = table[index];
		table[index] = newNode;
		size++;

		System.out.println("Student inserted into hash table: " + student.getStudentId());
	}

	// Search for a student using Student ID
	public Student search(int studentId) {
		int index = hash(studentId);
		HashNode current = table[index];

		while (current != null) {
			if (current.student.getStudentId() == studentId) {
				System.out.println("Student found in hash table:");
				current.student.displayStudent();
				return current.student;
			}

			current = current.next;
		}

		System.out.println("Student not found in hash table: " + studentId);
		return null;
	}

	// Delete a student using Student ID
	public boolean delete(int studentId) {
		int index = hash(studentId);
		HashNode current = table[index];
		HashNode previous = null;

		while (current != null) {
			if (current.student.getStudentId() == studentId) {
				if (previous == null) {
					table[index] = current.next;
				} else {
					previous.next = current.next;
				}

				size--;

				System.out.println("Student deleted from hash table: " + studentId);
				return true;
			}

			previous = current;
			current = current.next;
		}

		System.out.println("Cannot delete. Student not found: " + studentId);
		return false;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	// Display the complete hash table
	public void displayTable() {
		if (isEmpty()) {
			System.out.println("Student hash table is empty.");
			return;
		}

		System.out.println("===== STUDENT HASH TABLE =====");

		for (int i = 0; i < capacity; i++) {
			System.out.print("Index " + i + ": ");

			HashNode current = table[i];

			if (current == null) {
				System.out.println("Empty");
				continue;
			}

			while (current != null) {
				System.out.print("[" + current.student.getStudentId() + " - " + current.student.getName() + "]");

				if (current.next != null) {
					System.out.print(" -> ");
				}

				current = current.next;
			}

			System.out.println();
		}
	}
}
