import java.time.LocalDateTime;

public class Transaction {
    private LocalDateTime timestamp;
    private String type;
    private double amount;
    private double balanceAfter;

    public Transaction(String type, double amount, double balanceAfter) {
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    public String toString() {
        return timestamp + " | " + type + " | Jumlah: " + amount + " | Saldo: " + balanceAfter;
    }
}
