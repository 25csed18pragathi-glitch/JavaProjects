import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("       ATM ACCOUNT SETUP");
        System.out.println("================================");

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accountHolder = scanner.nextLine();

        System.out.print("Enter Initial Balance: ₹");
        double initialBalance = scanner.nextDouble();

        System.out.print("Create 4-digit PIN: ");
        int pin = scanner.nextInt();

        BankAccount account = new BankAccount(
                accountNumber,
                accountHolder,
                initialBalance
        );

        ATM atm = new ATM(account, pin);

        atm.start();

        scanner.close();
    }
}