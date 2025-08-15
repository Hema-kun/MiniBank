import java.util.*;

public class Account {
    private String accountNumber;
    private String holderName;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();
    private static final double MONTHLY_INTEREST_RATE = 0.00167;

    public Account(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Setoran", amount, balance));
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Penarikan", amount, balance));
            return true;
        }
        return false;
    }

    public void applyMonthlyInterest() {
        double interest = balance * MONTHLY_INTEREST_RATE;
        balance += interest;
        transactions.add(new Transaction("Bunga", interest, balance));
    }

    public void printTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public String getDetails() {
        return "Akun: " + accountNumber + ", Nama: " + holderName + ", Saldo: " + balance;
    }

    public String toFileString() {
        return accountNumber + "," + holderName + "," + balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
