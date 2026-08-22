import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame1{

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static int totalScore = 0;
    private static int roundsWon = 0;

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("       NUMBER GUESSING GAME");
        System.out.println("======================================");

        boolean playAgain;

        do {
            playRound();
            playAgain = getPlayAgain();

        } while (playAgain);

        displayFinalResult();
        scanner.close();
    }

    private static void playRound() {

        int maxAttempts = selectDifficulty();
        int secretNumber = random.nextInt(100) + 1;

        int attempts = 0;
        boolean won = false;

        System.out.println("\nI have selected a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {

            int guess = getValidGuess();
            attempts++;

            if (guess == secretNumber) {

                int roundScore = calculateScore(maxAttempts, attempts);

                System.out.println("\n✓ Congratulations!");
                System.out.println("You guessed the correct number.");
                System.out.println("Attempts used : " + attempts);
                System.out.println("Round score   : " + roundScore);

                totalScore += roundScore;
                roundsWon++;
                won = true;

                break;

            } else if (guess < secretNumber) {

                System.out.println("Too low! Try a higher number.");

            } else {

                System.out.println("Too high! Try a lower number.");
            }

            System.out.println("Attempts remaining: "
                    + (maxAttempts - attempts));
        }

        if (!won) {
            System.out.println("\n✗ Game Over!");
            System.out.println("The correct number was: " + secretNumber);
        }
    }

    private static int selectDifficulty() {

        System.out.println("\nSelect Difficulty:");
        System.out.println("1. Easy   - 10 attempts");
        System.out.println("2. Medium - 7 attempts");
        System.out.println("3. Hard   - 5 attempts");

        while (true) {

            System.out.print("Enter choice: ");
            String input = scanner.nextLine();

            switch (input) {

                case "1":
                    return 10;

                case "2":
                    return 7;

                case "3":
                    return 5;

                default:
                    System.out.println("Invalid choice. Enter 1, 2 or 3.");
            }
        }
    }

    private static int getValidGuess() {

        while (true) {

            System.out.print("Enter your guess (1-100): ");
            String input = scanner.nextLine();

            try {

                int guess = Integer.parseInt(input);

                if (guess >= 1 && guess <= 100) {
                    return guess;
                }

                System.out.println("Please enter a number between 1 and 100.");

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static int calculateScore(int maxAttempts, int attempts) {

        return (maxAttempts - attempts + 1) * 10;
    }

    private static boolean getPlayAgain() {

        while (true) {

            System.out.print("\nDo you want to play another round? (Y/N): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Y")) {
                return true;
            }

            if (choice.equalsIgnoreCase("N")) {
                return false;
            }

            System.out.println("Please enter Y or N.");
        }
    }

    private static void displayFinalResult() {

        System.out.println("\n======================================");
        System.out.println("             FINAL RESULT");
        System.out.println("======================================");
        System.out.println("Rounds Won : " + roundsWon);
        System.out.println("Total Score: " + totalScore);
        System.out.println("======================================");
        System.out.println("Thank you for playing!");
    }
}