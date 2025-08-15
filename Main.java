import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        bank.loadAccounts();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MiniBank Menu ===");
            System.out.println("1. Buat Akun");
            System.out.println("2. Setor Uang");
            System.out.println("3. Tarik Uang");
            System.out.println("4. Lihat Detail Akun");
            System.out.println("5. Tambahkan Bunga");
            System.out.println("6. Lihat Riwayat Transaksi");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            int choice = sc.nextInt();
            sc.nextLine(); // konsumsi newline

            String accNum;
            Account acc;

            switch (choice) {
                case 1:
                    System.out.print("Nomor Akun: ");
                    accNum = sc.nextLine();
                    System.out.print("Nama Pemilik: ");
                    String name = sc.nextLine();
                    bank.createAccount(accNum, name);
                    System.out.println("Akun berhasil dibuat.");
                    break;
                case 2:
                    System.out.print("Nomor Akun: ");
                    accNum = sc.nextLine();
                    acc = bank.findAccount(accNum);
                    if (acc != null) {
                        System.out.print("Jumlah: ");
                        double amt = sc.nextDouble();
                        acc.deposit(amt);
                        System.out.println("Setoran berhasil.");
                    } else {
                        System.out.println("Akun tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.print("Nomor Akun: ");
                    accNum = sc.nextLine();
                    acc = bank.findAccount(accNum);
                    if (acc != null) {
                        System.out.print("Jumlah: ");
                        double amt = sc.nextDouble();
                        if (acc.withdraw(amt)) {
                            System.out.println("Penarikan berhasil.");
                        } else {
                            System.out.println("Saldo tidak cukup.");
                        }
                    } else {
                        System.out.println("Akun tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.print("Nomor Akun: ");
                    accNum = sc.nextLine();
                    acc = bank.findAccount(accNum);
                    if (acc != null) {
                        System.out.println(acc.getDetails());
                    } else {
                        System.out.println("Akun tidak ditemukan.");
                    }
                    break;
                case 5:
                    System.out.print("Nomor Akun: ");
                    accNum = sc.nextLine();
                    acc = bank.findAccount(accNum);
                    if (acc != null) {
                        acc.applyMonthlyInterest();
                        System.out.println("Bunga telah ditambahkan.");
                    } else {
                        System.out.println("Akun tidak ditemukan.");
                    }
                    break;
                case 6:
                    System.out.print("Nomor Akun: ");
                    accNum = sc.nextLine();
                    acc = bank.findAccount(accNum);
                    if (acc != null) {
                        acc.printTransactions();
                    } else {
                        System.out.println("Akun tidak ditemukan.");
                    }
                    break;
                case 7:
                    bank.saveAccounts();
                    System.out.println("Data disimpan. Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
