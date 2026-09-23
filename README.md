

# University Student Management System

## CIT300 – Data Structures and Algorithms

A Java console-based University Student Management System developed as a group practical assignment. The system demonstrates the practical use of multiple data structures to manage student information, requests, action history, and campus locations.

## Project Features

- Register new students
- Search students using Student ID
- Update student information
- Delete student records
- Display students in ascending order
- Manage student requests using a queue
- Maintain action history using a stack
- Store and retrieve students using a hash table
- Manage student records using a linked list
- Manage campus locations and connections using a graph
- Perform Breadth-First Search (BFS)
- Perform Depth-First Search (DFS)
- Validate invalid and empty user inputs

## Data Structures Used

| Data Structure | Purpose |
|---|---|
| Binary Search Tree | Stores students and displays them in ascending Student ID order |
| Hash Table | Provides efficient student storage, searching, and deletion |
| Singly Linked List | Maintains student records sequentially |
| Queue | Processes student requests using FIFO order |
| Stack | Stores action history using LIFO order |
| Graph | Represents campus locations and their connections |
| BFS and DFS | Traverse connected campus locations |

## Group Members and Contributions

| Student Name | Student ID | Responsibility | Git Branch |
|---|---|---|---|
| A.M. Mohamed Rinas | 23DA2-1125 | Campus Graph, BFS, DFS, system integration, main menu, final testing and bug fixing | `rinas-graph`, `integration-testing` |
| A.M. Afri | 23DA2-1126 | Action Stack and Student Request Queue implementation and testing | `afri-stack-queue` |
| M.K.M. Umair | 23DA2-0821 | Binary Search Tree and Student Hash Table implementation and testing | `umair-tree-hashing` |
| N.M. Saamil | 23DA2-0516 | Student Linked List implementation, search, update, delete and testing | `saamil-linked-list` |

## Project Structure

```text
src/
└── university/
    ├── graph/
    │   ├── CampusGraph.java
    │   └── GraphTest.java
    ├── hashing/
    │   ├── StudentHashTable.java
    │   └── TreeHashingTest.java
    ├── linkedlist/
    │   ├── LinkedListTest.java
    │   ├── StudentLinkedList.java
    │   └── StudentNode.java
    ├── main/
    │   └── Main.java
    ├── model/
    │   └── Student.java
    ├── queue/
    │   ├── StudentRequestQueue.java
    │   └── StudentRequestQueueTest.java
    ├── stack/
    │   ├── ActionStack.java
    │   └── ActionStackTest.java
    └── tree/
        └── StudentBST.java
````

## System Menu

The integrated system provides the following options:

1. Register Student
2. Search Student
3. Update Student
4. Delete Student
5. Display Students Using BST
6. Display Students Using Linked List
7. Display Student Hash Table
8. Add Student Request
9. Process Student Request
10. Peek Next Request
11. Display Request Queue
12. Display Action History
13. Add Campus Location
14. Add Campus Connection
15. Display Campus Graph
16. Campus BFS Traversal
17. Campus DFS Traversal
18. Exit

## Technologies Used

* Java
* Eclipse IDE
* Git
* GitHub
* Java Console Input and Output

## How to Run the Project

### Clone the Repository

```bash
git clone https://github.com/23da2-1125-creator/CIT300-University-Student-Management-System.git
```

### Open the Project Folder

```bash
cd CIT300-University-Student-Management-System
```

### Switch to the Integrated Branch

```bash
git switch integration-testing
```

### Run Using Eclipse

1. Open Eclipse IDE.
2. Select **File → Import**.
3. Select **Existing Projects into Workspace**.
4. Select the cloned project folder.
5. Open `src/university/main/Main.java`.
6. Right-click `Main.java`.
7. Select **Run As → Java Application**.

## Testing

The following operations were successfully tested:

* Student registration
* Existing and invalid student search
* Student update
* Student deletion
* BST in-order traversal
* Linked List display and operations
* Hash Table display and deletion
* Queue add, peek, display, and process operations
* Stack action history in LIFO order
* Graph location and connection management
* BFS traversal
* DFS traversal
* Empty structure validation
* Invalid input validation
* Integrated main menu operation

## Git Collaboration

The project was developed collaboratively using:

* Separate feature branches for each member
* Meaningful Git commits
* Individual module testing
* Integration through the `integration-testing` branch
* Final integrated system testing
* GitHub commit and branch history as contribution evidence

## Final Integrated Branch

```text
integration-testing
```

## Repository

[https://github.com/23da2-1125-creator/CIT300-University-Student-Management-System](https://github.com/23da2-1125-creator/CIT300-University-Student-Management-System)
