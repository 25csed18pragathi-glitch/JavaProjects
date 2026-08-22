# Student Course Registration System

## 📌 Project Description

The **Student Course Registration System** is a Java console-based application that allows students to view available courses, register for courses, drop registered courses, and view their registered courses.

The system also keeps track of the available seats for each course. When a student registers for a course, the available capacity decreases by one. When a course is dropped, the capacity increases by one.

## 🎯 Features

* Enter student ID and student name
* Display available courses
* View course details
* Register for a course
* Prevent duplicate course registration
* Check course capacity
* Drop a registered course
* View all registered courses
* Interactive menu-driven system

## 🛠️ Technologies Used

* **Language:** Java
* **Concepts:** Classes, Objects, ArrayList, Constructors, Methods, Loops, Conditional Statements, Scanner
* **Interface:** Command Line / Console

## 📚 Courses Available

| Course Code | Course            | Capacity |
| ----------- | ----------------- | -------: |
| CS101       | Java Programming  |        3 |
| CS102       | Data Structures   |        2 |
| CS103       | Operating Systems |        2 |

## ▶️ How to Run

### 1. Compile the program

```bash
javac StudentCourseRegistration.java
```

### 2. Run the program

```bash
java StudentCourseRegistration
```

## 💻 Sample Output

```text
===== STUDENT COURSE REGISTRATION SYSTEM =====

Enter Student ID: 101
Enter Student Name: Pragathi

===== MENU =====
1. Display Available Courses
2. Register for a Course
3. Drop a Course
4. View Registered Courses
5. Exit

Enter your choice: 1

----- AVAILABLE COURSES -----

Course Code: CS101
Title: Java Programming
Description: Introduction to Java programming
Available Slots: 3
Schedule: Monday - 10:00 AM

Course Code: CS102
Title: Data Structures
Description: Learn basic data structures
Available Slots: 2
Schedule: Wednesday - 2:00 PM

Course Code: CS103
Title: Operating Systems
Description: Learn operating system concepts
Available Slots: 2
Schedule: Friday - 11:00 AM
```

## 🔄 Registration Example

```text
Enter your choice: 2
Enter Course Code to Register: CS101

Course registered successfully!

Enter your choice: 4

----- REGISTERED COURSES -----
CS101 - Java Programming
```

## 🧠 Concepts Demonstrated

1. **Classes and Objects** – `Course` and `Student` classes are used to model the system.
2. **ArrayList** – Stores available courses and courses registered by the student.
3. **Encapsulation of Operations** – Registration, dropping, and displaying courses are handled using methods.
4. **Constructors** – Used to initialize student and course objects.
5. **Loops and Conditions** – Used for menu handling, searching courses, and checking availability.
6. **Exception-free Input Flow** – `Scanner` is used to receive user input from the console.

## 📂 Project Structure

```text
StudentCourseRegistration/
│
├── StudentCourseRegistration.java
└── README.md
```

