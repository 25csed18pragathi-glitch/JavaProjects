import java.util.Scanner;

public class GradeCalculator {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("          GRADE CALCULATOR");
        System.out.println("======================================");

        int numberOfSubjects = getNumberOfSubjects();

        String[] subjects = new String[numberOfSubjects];
        double[] marks = new double[numberOfSubjects];

        double totalMarks = 0;

        for (int i = 0; i < numberOfSubjects; i++) {

            System.out.print("\nEnter subject " + (i + 1) + " name: ");
            subjects[i] = scanner.nextLine();

            marks[i] = getValidMarks(subjects[i]);

            totalMarks += marks[i];
        }

        double percentage = totalMarks / numberOfSubjects;

        String grade = calculateGrade(percentage);

        String result = percentage >= 40 ? "PASS" : "FAIL";

        displayResult(
                subjects,
                marks,
                totalMarks,
                percentage,
                grade,
                result
        );

        scanner.close();
    }

    private static int getNumberOfSubjects() {

        while (true) {

            System.out.print("Enter number of subjects: ");
            String input = scanner.nextLine();

            try {

                int number = Integer.parseInt(input);

                if (number > 0 && number <= 20) {
                    return number;
                }

                System.out.println(
                        "Number of subjects must be between 1 and 20."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a valid number."
                );
            }
        }
    }

    private static double getValidMarks(String subject) {

        while (true) {

            System.out.print(
                    "Enter marks for " + subject + " (0-100): "
            );

            String input = scanner.nextLine();

            try {

                double marks = Double.parseDouble(input);

                if (marks >= 0 && marks <= 100) {
                    return marks;
                }

                System.out.println(
                        "Marks must be between 0 and 100."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter numeric marks."
                );
            }
        }
    }

    private static String calculateGrade(double percentage) {

        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "F";
        }
    }

    private static void displayResult(
            String[] subjects,
            double[] marks,
            double totalMarks,
            double percentage,
            String grade,
            String result) {

        System.out.println("\n======================================");
        System.out.println("             RESULT SHEET");
        System.out.println("======================================");

        System.out.printf("%-20s %s%n", "Subject", "Marks");
        System.out.println("--------------------------------------");

        for (int i = 0; i < subjects.length; i++) {

            System.out.printf(
                    "%-20s %.2f%n",
                    subjects[i],
                    marks[i]
            );
        }

        System.out.println("--------------------------------------");

        System.out.printf(
                "Total Marks       : %.2f / %d%n",
                totalMarks,
                subjects.length * 100
        );

        System.out.printf(
                "Average Percentage: %.2f%%%n",
                percentage
        );

        System.out.println("Grade              : " + grade);
        System.out.println("Result             : " + result);

        System.out.println("======================================");
    }
}