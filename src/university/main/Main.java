package university.main;

import java.util.Scanner;

import university.graph.CampusGraph;
import university.hashing.StudentHashTable;
import university.linkedlist.StudentLinkedList;
import university.model.Student;
import university.queue.StudentRequestQueue;
import university.stack.ActionStack;
import university.tree.StudentBST;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        StudentBST studentBST = new StudentBST();
        StudentHashTable hashTable = new StudentHashTable(31);
        StudentLinkedList studentList = new StudentLinkedList();

        StudentRequestQueue requestQueue =
                new StudentRequestQueue(20);

        ActionStack actionStack =
                new ActionStack(50);

        CampusGraph campusGraph =
                new CampusGraph(20);

        int choice;

        System.out.println(
                "==========================================");
        System.out.println(
                "   UNIVERSITY STUDENT MANAGEMENT SYSTEM");
        System.out.println(
                "==========================================");

        do {
            displayMenu();
            choice = readInt("Enter your choice: ");

            System.out.println();

            switch (choice) {

                case 1:
                    registerStudent(
                            studentBST,
                            hashTable,
                            studentList,
                            actionStack
                    );
                    break;

                case 2:
                    searchStudent(studentBST);
                    break;

                case 3:
                    updateStudent(studentBST, actionStack);
                    break;

                case 4:
                    deleteStudent(
                            studentBST,
                            hashTable,
                            studentList,
                            actionStack
                    );
                    break;

                case 5:
                    studentBST.displayInOrder();
                    break;

                case 6:
                    studentList.displayStudents();
                    break;

                case 7:
                    hashTable.displayTable();
                    break;

                case 8:
                    addStudentRequest(requestQueue);
                    break;

                case 9:
                    requestQueue.processRequest();
                    break;

                case 10:
                    String nextRequest =
                            requestQueue.peekRequest();

                    if (nextRequest != null) {
                        System.out.println(
                                "Next request: " + nextRequest);
                    }
                    break;

                case 11:
                    requestQueue.displayRequests();
                    break;

                case 12:
                    actionStack.displayActions();
                    break;

                case 13:
                    addCampusLocation(campusGraph);
                    break;

                case 14:
                    addCampusConnection(campusGraph);
                    break;

                case 15:
                    campusGraph.displayLocations();
                    campusGraph.displayConnections();
                    break;

                case 16:
                    String bfsStart =
                            readText("Enter starting location: ");

                    campusGraph.breadthFirstSearch(bfsStart);
                    break;

                case 17:
                    String dfsStart =
                            readText("Enter starting location: ");

                    campusGraph.depthFirstSearch(dfsStart);
                    break;

                case 0:
                    System.out.println(
                            "System closed successfully.");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again.");
            }

            System.out.println();

        } while (choice != 0);
    }

    private static void displayMenu() {

        System.out.println(
                "============== MAIN MENU ==============");
        System.out.println("1.  Register Student");
        System.out.println("2.  Search Student");
        System.out.println("3.  Update Student");
        System.out.println("4.  Delete Student");
        System.out.println("5.  Display Students Using BST");
        System.out.println("6.  Display Students Using Linked List");
        System.out.println("7.  Display Student Hash Table");
        System.out.println("8.  Add Student Request");
        System.out.println("9.  Process Student Request");
        System.out.println("10. Peek Next Request");
        System.out.println("11. Display Request Queue");
        System.out.println("12. Display Action History");
        System.out.println("13. Add Campus Location");
        System.out.println("14. Add Campus Connection");
        System.out.println("15. Display Campus Graph");
        System.out.println("16. Campus BFS Traversal");
        System.out.println("17. Campus DFS Traversal");
        System.out.println("0.  Exit");
        System.out.println(
                "=======================================");
    }

    private static void registerStudent(
            StudentBST studentBST,
            StudentHashTable hashTable,
            StudentLinkedList studentList,
            ActionStack actionStack) {

        int studentId = readInt("Enter student ID: ");

        Student existingStudent =
                studentBST.findStudent(studentId);

        if (existingStudent != null) {
            System.out.println(
                    "Student ID already exists: " + studentId);
            return;
        }

        String name = readText("Enter student name: ");
        String programme =
                readText("Enter programme: ");
        double marks = readDouble("Enter marks: ");

        Student student = new Student(
                studentId,
                name,
                programme,
                marks
        );

        studentBST.insert(student);
        hashTable.insert(student);
        studentList.addStudent(student);

        actionStack.push(
                "Student " + studentId + " registered");

        System.out.println(
                "Student registration completed.");
    }

    private static void searchStudent(
            StudentBST studentBST) {

        int studentId =
                readInt("Enter student ID to search: ");

        Student student =
                studentBST.findStudent(studentId);

        if (student == null) {
            System.out.println(
                    "Student not found: " + studentId);
        } else {
            System.out.println("Student found:");
            student.displayStudent();
        }
    }

    private static void updateStudent(
            StudentBST studentBST,
            ActionStack actionStack) {

        int studentId =
                readInt("Enter student ID to update: ");

        Student student =
                studentBST.findStudent(studentId);

        if (student == null) {
            System.out.println(
                    "Student not found: " + studentId);
            return;
        }

        String newName =
                readText("Enter new name: ");
        String newProgramme =
                readText("Enter new programme: ");
        double newMarks =
                readDouble("Enter new marks: ");

        student.setName(newName);
        student.setProgramme(newProgramme);
        student.setMarks(newMarks);

        actionStack.push(
                "Student " + studentId + " updated");

        System.out.println(
                "Student updated successfully.");
    }

    private static void deleteStudent(
            StudentBST studentBST,
            StudentHashTable hashTable,
            StudentLinkedList studentList,
            ActionStack actionStack) {

        int studentId =
                readInt("Enter student ID to delete: ");

        Student student =
                studentBST.findStudent(studentId);

        if (student == null) {
            System.out.println(
                    "Student not found: " + studentId);
            return;
        }

        studentBST.delete(studentId);
        hashTable.delete(studentId);
        studentList.deleteStudent(studentId);

        actionStack.push(
                "Student " + studentId + " deleted");

        System.out.println(
                "Student deletion completed.");
    }

    private static void addStudentRequest(
            StudentRequestQueue requestQueue) {

        int studentId =
                readInt("Enter student ID: ");

        String request =
                readText("Enter request: ");

        requestQueue.addRequest(
                "Student " + studentId + " - " + request);
    }

    private static void addCampusLocation(
            CampusGraph campusGraph) {

        String location =
                readText("Enter campus location: ");

        campusGraph.addLocation(location);
    }

    private static void addCampusConnection(
            CampusGraph campusGraph) {

        String firstLocation =
                readText("Enter first location: ");

        String secondLocation =
                readText("Enter second location: ");

        campusGraph.addConnection(
                firstLocation,
                secondLocation
        );
    }

    private static int readInt(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(
                        scanner.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.println(
                        "Please enter a valid whole number.");
            }
        }
    }

    private static double readDouble(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(
                        scanner.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.println(
                        "Please enter a valid number.");
            }
        }
    }

    private static String readText(String message) {

        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                    "This value cannot be empty.");
        }
    }
}