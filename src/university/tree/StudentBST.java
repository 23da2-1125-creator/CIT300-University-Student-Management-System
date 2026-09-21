	package university.tree;

	import university.model.Student;

	public class StudentBST {

	    private class Node {
	        Student student;
	        Node left;
	        Node right;

	        Node(Student student) {
	            this.student = student;
	        }
	    }

	    private Node root;

	    public StudentBST() {
	        root = null;
	    }

	    public boolean isEmpty() {
	        return root == null;
	    }

	    // Insert a student using Student ID
	    public void insert(Student student) {
	        root = insertRecursive(root, student);
	    }

	    private Node insertRecursive(Node current, Student student) {
	        if (current == null) {
	            System.out.println(
	                "Student inserted: " + student.getStudentId()
	            );
	            return new Node(student);
	        }

	        if (student.getStudentId()
	                < current.student.getStudentId()) {
	            current.left =
	                insertRecursive(current.left, student);

	        } else if (student.getStudentId()
	                > current.student.getStudentId()) {
	            current.right =
	                insertRecursive(current.right, student);

	        } else {
	            System.out.println(
	                "Student ID already exists: "
	                + student.getStudentId()
	            );
	        }

	        return current;
	    }

	    // Search for a student using Student ID
	    public Student search(int studentId) {
	        Node result = searchRecursive(root, studentId);

	        if (result == null) {
	            System.out.println(
	                "Student not found: " + studentId
	            );
	            return null;
	        }

	        System.out.println("Student found:");
	        result.student.displayStudent();
	        return result.student;
	    }

	    private Node searchRecursive(Node current, int studentId) {
	        if (current == null
	                || current.student.getStudentId() == studentId) {
	            return current;
	        }

	        if (studentId < current.student.getStudentId()) {
	            return searchRecursive(current.left, studentId);
	        }

	        return searchRecursive(current.right, studentId);
	    }

	    // Delete a student using Student ID
	    public void delete(int studentId) {
	        if (searchNode(root, studentId) == null) {
	            System.out.println(
	                "Cannot delete. Student not found: " + studentId
	            );
	            return;
	        }

	        root = deleteRecursive(root, studentId);

	        System.out.println(
	            "Student deleted: " + studentId
	        );
	    }

	    private Node searchNode(Node current, int studentId) {
	        if (current == null
	                || current.student.getStudentId() == studentId) {
	            return current;
	        }

	        if (studentId < current.student.getStudentId()) {
	            return searchNode(current.left, studentId);
	        }

	        return searchNode(current.right, studentId);
	    }

	    private Node deleteRecursive(Node current, int studentId) {
	        if (current == null) {
	            return null;
	        }

	        if (studentId < current.student.getStudentId()) {
	            current.left =
	                deleteRecursive(current.left, studentId);

	        } else if (studentId
	                > current.student.getStudentId()) {
	            current.right =
	                deleteRecursive(current.right, studentId);

	        } else {
	            if (current.left == null) {
	                return current.right;
	            }

	            if (current.right == null) {
	                return current.left;
	            }

	            Node successor = findMinimum(current.right);
	            current.student = successor.student;

	            current.right = deleteRecursive(
	                current.right,
	                successor.student.getStudentId()
	            );
	        }

	        return current;
	    }

	    private Node findMinimum(Node current) {
	        while (current.left != null) {
	            current = current.left;
	        }

	        return current;
	    }

	    // Display students in ascending Student ID order
	    public void displayInOrder() {
	        if (isEmpty()) {
	            System.out.println("Student BST is empty.");
	            return;
	        }

	        System.out.println("===== STUDENTS IN ASCENDING ORDER =====");
	        inOrderRecursive(root);
	    }

	    private void inOrderRecursive(Node current) {
	        if (current != null) {
	            inOrderRecursive(current.left);
	            current.student.displayStudent();
	            inOrderRecursive(current.right);
	        }
	    }
	}

