import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private final String accountNumber;
    private final String accountHolder;
    private double balance;

    private final List<Transaction> transactions;

    // Maximum amount that can be withdrawn in one day
    private static final double DAILY_WITHDRAWAL_LIMIT = 20000;

    private double todayWithdrawalAmount = 0;

    // Constructor
    public BankAccount(
            String accountNumber,
            String accountHolder,
            double initialBalance) {

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;

        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }

        transactions = new ArrayList<>();
    }

    // Withdraw money
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println(
                    "Invalid withdrawal amount."
            );
            return false;
        }

        if (amount > balance) {
            System.out.println(
                    "Insufficient balance."
            );
            return false;
        }

        if (todayWithdrawalAmount + amount
                > DAILY_WITHDRAWAL_LIMIT) {

            System.out.println(
                    "Daily withdrawal limit of ₹"
                            + DAILY_WITHDRAWAL_LIMIT
                            + " exceeded."
            );

            return false;
        }

        balance -= amount;
        todayWithdrawalAmount += amount;

        transactions.add(
                new Transaction(
                        TransactionType.WITHDRAWAL,
                        amount,
                        balance
                )
        );

        return true;
    }

    // Deposit money
    public boolean deposit(double amount) {

        if (amount <= 0) {
            System.out.println(
                    "Invalid deposit amount."
            );
            return false;
        }

        balance += amount;

        transactions.add(
                new Transaction(
                        TransactionType.DEPOSIT,
                        amount,
                        balance
                )
        );

        return true;
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    // Get account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Get account holder name
    public String getAccountHolder() {
        return accountHolder;
    }

    // Get transaction history
    public List<Transaction> getTransactions() {
        return transactions;
    }
}