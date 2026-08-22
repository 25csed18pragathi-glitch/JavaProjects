import java.util.Scanner;

public class ATM {

    private final BankAccount account;
    private final Scanner scanner;
    private final int pin;

    private static final int MAX_PIN_ATTEMPTS = 3;

    public ATM(BankAccount account, int pin) {
        this.account = account;
        this.pin = pin;
        this.scanner = new Scanner(System.in);
    }

    // Start ATM
    public void start() {

        if (!authenticate()) {
            System.out.println("\nToo many incorrect attempts.");
            System.out.println("Your account has been temporarily blocked.");
            return;
        }

        boolean running = true;

        while (running) {

            displayMenu();

            int choice = getIntegerInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    miniStatement();
                    break;

                case 5:
                    System.out.println("\nThank you for using the ATM.");
                    System.out.println("Have a nice day!");
                    running = false;
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please select 1 to 5."
                    );
            }
        }
    }

    // PIN Authentication
    private boolean authenticate() {

        for (int attempt = 1;
             attempt <= MAX_PIN_ATTEMPTS;
             attempt++) {

            int enteredPin =
                    getIntegerInput("\nEnter your 4-digit PIN: ");

            if (enteredPin == pin) {

                System.out.println(
                        "\n✓ Authentication successful!"
                );

                System.out.println(
                        "Welcome, "
                                + account.getAccountHolder()
                                + "!"
                );

                return true;
            }

            int remaining =
                    MAX_PIN_ATTEMPTS - attempt;

            if (remaining > 0) {

                System.out.println(
                        "Incorrect PIN!"
                );

                System.out.println(
                        "Attempts remaining: "
                                + remaining
                );
            }
        }

        return false;
    }

    // Display ATM Menu
    private void displayMenu() {

        System.out.println("\n================================");
        System.out.println("            ATM MENU");
        System.out.println("================================");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Mini Statement");
        System.out.println("5. Exit");
        System.out.println("================================");
    }

    // Check Balance
    private void checkBalance() {

        System.out.println("\n----------- BALANCE -----------");

        System.out.printf(
                "Account Holder : %s%n",
                account.getAccountHolder()
        );

        System.out.printf(
                "Account Number : %s%n",
                account.getAccountNumber()
        );

        System.out.printf(
                "Available Balance : ₹%.2f%n",
                account.getBalance()
        );

        System.out.println("-------------------------------");
    }

    // Deposit
    private void deposit() {

        double amount =
                getDoubleInput(
                        "\nEnter amount to deposit: ₹"
                );

        if (account.deposit(amount)) {

            System.out.println(
                    "✓ Deposit successful!"
            );

            System.out.printf(
                    "Deposited Amount : ₹%.2f%n",
                    amount
            );

            System.out.printf(
                    "New Balance      : ₹%.2f%n",
                    account.getBalance()
            );
        }
    }

    // Withdraw
    private void withdraw() {

        double amount =
                getDoubleInput(
                        "\nEnter amount to withdraw: ₹"
                );

        if (account.withdraw(amount)) {

            System.out.println(
                    "✓ Withdrawal successful!"
            );

            System.out.printf(
                    "Withdrawn Amount : ₹%.2f%n",
                    amount
            );

            System.out.println(
                    "Please collect your cash."
            );

            System.out.printf(
                    "Remaining Balance: ₹%.2f%n",
                    account.getBalance()
            );
        }
    }

    // Mini Statement
    private void miniStatement() {

        System.out.println(
                "\n============== MINI STATEMENT =============="
        );

        System.out.printf(
                "%-15s %-12s %-22s %-15s%n",
                "TYPE",
                "AMOUNT",
                "DATE & TIME",
                "BALANCE"
        );

        System.out.println(
                "---------------------------------------------"
        );

        if (account.getTransactions().isEmpty()) {

            System.out.println(
                    "No transactions available."
            );

        } else {

            for (Transaction transaction
                    : account.getTransactions()) {

                transaction.display();
            }
        }

        System.out.println(
                "---------------------------------------------"
        );

        System.out.printf(
                "Current Balance: ₹%.2f%n",
                account.getBalance()
        );

        System.out.println(
                "============================================="
        );
    }

    // Integer Input Validation
    private int getIntegerInput(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a number."
                );
            }
        }
    }

    // Double Input Validation
    private double getDoubleInput(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                double amount =
                        Double.parseDouble(input);

                if (amount > 0) {
                    return amount;
                }

                System.out.println(
                        "Amount must be greater than zero."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid amount! Please enter a valid number."
                );
            }
        }
    }
}