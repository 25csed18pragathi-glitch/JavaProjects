import java.util.*;
import java.util.concurrent.*;

class Question {
    String question;
    String[] options;
    int correctAnswer;

    Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class QuizApplication {

    static Scanner sc = new Scanner(System.in);
    static int score = 0;
    static int correct = 0;
    static int wrong = 0;
    static int unanswered = 0;

    public static void main(String[] args) {

        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "Which language is used for Android development?",
                new String[]{"C", "Java", "HTML", "SQL"}, 2));

        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                new String[]{"this", "super", "extends", "implements"}, 3));

        questions.add(new Question(
                "Which data structure follows FIFO?",
                new String[]{"Stack", "Queue", "Tree", "Graph"}, 2));

        questions.add(new Question(
                "Which method is the entry point of a Java program?",
                new String[]{"start()", "run()", "main()", "execute()"}, 3));

        questions.add(new Question(
                "Which keyword is used to create an object?",
                new String[]{"class", "new", "object", "create"}, 2));

        System.out.println("=================================");
        System.out.println("       QUIZ APPLICATION");
        System.out.println("=================================");
        System.out.println("Each question has 10 seconds.");
        System.out.println();

        for (int i = 0; i < questions.size(); i++) {

            Question q = questions.get(i);

            System.out.println("---------------------------------");
            System.out.println("Question " + (i + 1) + ": " + q.question);

            for (int j = 0; j < q.options.length; j++) {
                System.out.println((j + 1) + ". " + q.options[j]);
            }

            System.out.println("You have 10 seconds!");
            System.out.print("Enter your answer (1-4): ");

            ExecutorService executor = Executors.newSingleThreadExecutor();

            Future<String> future = executor.submit(() -> sc.nextLine());

            try {
                String answer = future.get(10, TimeUnit.SECONDS);

                int selected = Integer.parseInt(answer);

                if (selected == q.correctAnswer) {
                    System.out.println("Correct!");
                    score++;
                    correct++;
                } else {
                    System.out.println("Wrong!");
                    wrong++;
                }

            } catch (TimeoutException e) {

                System.out.println("\nTime's up!");
                unanswered++;

                future.cancel(true);

            } catch (Exception e) {

                System.out.println("Invalid answer!");
                wrong++;
            }

            executor.shutdownNow();
        }

        System.out.println("\n=================================");
        System.out.println("          QUIZ RESULT");
        System.out.println("=================================");

        System.out.println("Total Questions : " + questions.size());
        System.out.println("Correct Answers : " + correct);
        System.out.println("Wrong Answers   : " + wrong);
        System.out.println("Unanswered      : " + unanswered);
        System.out.println("Final Score     : " + score + "/" + questions.size());

        double percentage =
                ((double) score / questions.size()) * 100;

        System.out.println("Percentage      : " + percentage + "%");

        System.out.println("=================================");
        System.out.println("        THANK YOU!");
        System.out.println("=================================");

        sc.close();
    }
}