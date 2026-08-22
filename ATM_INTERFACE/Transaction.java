import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private final TransactionType type;
    private final double amount;
    private final double balanceAfter;
    private final LocalDateTime dateTime;

    public Transaction(
            TransactionType type,
            double amount,
            double balanceAfter) {

        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.dateTime = LocalDateTime.now();
    }

    public void display() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy HH:mm:ss"
                );

        System.out.printf(
                "%-12s ₹%-10.2f %-20s ₹%.2f%n",
                type,
                amount,
                dateTime.format(formatter),
                balanceAfter
        );
    }
}