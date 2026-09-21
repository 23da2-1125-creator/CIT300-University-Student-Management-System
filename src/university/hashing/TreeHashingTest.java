package university.hashing;

import university.model.Student;
import university.tree.StudentBST;

public class TreeHashingTest {

    public static void main(String[] args) {

        Student student1 =
            new Student(105, "Ahamed", "BAIT", 78.5);

        Student student2 =
            new Student(102, "Fathima", "BAIT", 82.0);

        Student student3 =
            new Student(108, "Nimal", "BSc IT", 69.5);

        Student student4 =
            new Student(101, "Sara", "BAIT", 88.0);

        System.out.println("========== BST TEST ==========");

        StudentBST studentTree = new StudentBST();

        System.out.println("\n--- INSERT TEST ---");
        studentTree.insert(student1);
        studentTree.insert(student2);
        studentTree.insert(student3);
        studentTree.insert(student4);

        System.out.println("\n--- IN-ORDER TEST ---");
        studentTree.displayInOrder();

        System.out.println("\n--- SEARCH TEST ---");
        studentTree.search(102);

        System.out.println("\n--- DELETE TEST ---");
        studentTree.delete(105);

        System.out.println("\n--- BST AFTER DELETE ---");
        studentTree.displayInOrder();

        System.out.println(
            "\n\n========== HASH TABLE TEST =========="
        );

        StudentHashTable hashTable =
            new StudentHashTable(5);

        System.out.println("\n--- INSERT TEST ---");
        hashTable.insert(student1);
        hashTable.insert(student2);
        hashTable.insert(student3);
        hashTable.insert(student4);

        System.out.println("\n--- DISPLAY TABLE TEST ---");
        hashTable.displayTable();

        System.out.println("\n--- SEARCH TEST ---");
        hashTable.search(108);

        System.out.println("\n--- DELETE TEST ---");
        hashTable.delete(102);

        System.out.println("\n--- TABLE AFTER DELETE ---");
        hashTable.displayTable();

        System.out.println(
            "\nTotal students in hash table: "
            + hashTable.getSize()
        );
    }
}