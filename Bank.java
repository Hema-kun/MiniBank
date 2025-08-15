import java.util.*;
import java.io.*;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void createAccount(String accNum, String name) {
        accounts.add(new Account(accNum, name));
    }

    public Account findAccount(String accNum) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accNum)) return acc;
        }
        return null;
    }

    public void saveAccounts() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.txt"));
        for (Account acc : accounts) {
            writer.write(acc.toFileString());
            writer.newLine();
        }
        writer.close();
    }

    public void loadAccounts() throws IOException {
        File file = new File("accounts.txt");
        if (!file.exists()) return;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            Account acc = new Account(parts[0], parts[1]);
            acc.setBalance(Double.parseDouble(parts[2]));
            accounts.add(acc);
        }
        reader.close();
    }
}
