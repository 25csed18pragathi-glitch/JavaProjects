# Quiz Application with Timer

## 📌 Project Description

The **Quiz Application** is a Java console-based application that allows users to answer multiple-choice questions within a limited time.

Each question has a **10-second time limit**. The application uses Java's **ExecutorService, Future, and TimeUnit** classes to implement the timer. If the user does not answer within 10 seconds, the question is automatically marked as unanswered.

At the end of the quiz, the application displays the total questions, correct answers, wrong answers, unanswered questions, final score, and percentage.

## 🎯 Features

* Multiple-choice questions
* 10-second time limit for each question
* Automatic timeout handling
* Correct answer detection
* Wrong answer detection
* Unanswered question tracking
* Final score calculation
* Percentage calculation
* Console-based user interface

## 🛠️ Technologies Used

* **Java**
* `ArrayList`
* `Scanner`
* `ExecutorService`
* `Future`
* `TimeUnit`
* Exception handling
* Multithreading

## 📚 Questions Included

The quiz currently contains questions related to:

* Android development
* Java inheritance
* Data structures
* Java program execution
* Object creation in Java

## ⏱️ Timer Implementation

Each question provides **10 seconds** to enter an answer.

The program uses:

```java
Future<String> future = executor.submit(() -> sc.nextLine());
```

and:

```java
future.get(10, TimeUnit.SECONDS);
```

If the user does not enter an answer within 10 seconds, a `TimeoutException` occurs and the question is marked as unanswered.

## ▶️ How to Run

### 1. Save the Program

Save the code as:

```text
QuizApplication.java
```

### 2. Compile

Open Command Prompt, Terminal, or a Java-supported environment and run:

```bash
javac QuizApplication.java
```

### 3. Execute

```bash
java QuizApplication
```

## 💻 Sample Output

```text
=================================
       QUIZ APPLICATION
=================================
Each question has 10 seconds.

---------------------------------
Question 1: Which language is used for Android development?
1. C
2. Java
3. HTML
4. SQL

You have 10 seconds!
Enter your answer (1-4): 2
Correct!

---------------------------------
Question 2: Which keyword is used to inherit a class in Java?
1. this
2. super
3. extends
4. implements

You have 10 seconds!
Enter your answer (1-4): 3
Correct!

=================================
          QUIZ RESULT
=================================
Total Questions : 5
Correct Answers : 2
Wrong Answers   : 1
Unanswered      : 2
Final Score     : 2/5
Percentage      : 40.0%
=================================
        THANK YOU!
=================================
```

## 🧮 Scoring

The application calculates the score based on correct answers.

```text
Final Score = Number of Correct Answers
```

The percentage is calculated using:

```text
Percentage = (Correct Answers / Total Questions) × 100
```

## 🧠 Concepts Demonstrated

1. **Classes and Objects** – The `Question` class represents each quiz question.
2. **ArrayList** – Stores multiple quiz questions.
3. **Arrays** – Stores the options for each question.
4. **Scanner** – Accepts answers from the user.
5. **Multithreading** – Uses `ExecutorService` to handle timed input.
6. **Future** – Retrieves the user's answer within the specified time.
7. **Exception Handling** – Handles timeout and invalid input.
8. **Loops** – Iterates through all quiz questions.
9. **Conditional Statements** – Checks whether the selected answer is correct.
10. **Percentage Calculation** – Calculates the user's final performance.

## 📂 Project Structure

```text
QuizApplication/
│
├── QuizApplication.java
└── README.md
```

## 🚀 Future Enhancements

The application can be enhanced by adding:

* Randomized questions
* Different difficulty levels
* User login
* High-score storage
* Negative marking
* Restart quiz option
* More questions
* Graphical User Interface (GUI)
* Database connectivity
* Question categories

## 👩‍💻 Author

**Quiz Application**
Developed using Java.
