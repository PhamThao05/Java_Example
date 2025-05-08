import java.util.Scanner;

public class App {
    private String accountNumber;      // Số tài khoản
    private double balance;            // Số dư
    private String transactionHistory; // Lịch sử giao dịch

    // Constructor
    public App(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = "Tạo tài khoản với số dư: " + initialBalance + "\n";
    }

    // Getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getTransactionHistory() {
        return transactionHistory;
    }

    // Nạp tiền
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory += "Nạp tiền: +" + amount + "\n";
        } else {
            System.out.println("Số tiền nạp phải lớn hơn 0.");
        }
    }

    // Rút tiền
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory += "Rút tiền: -" + amount + "\n";
        } else {
            System.out.println("Số tiền rút không hợp lệ hoặc vượt quá số dư.");
        }
    }

    // Hiển thị thông tin tài khoản
    public void displayInfo() {
        System.out.println("Số tài khoản: " + accountNumber);
        System.out.println("Số dư hiện tại: " + balance);
        System.out.println("Lịch sử giao dịch:\n" + transactionHistory);
    }

    // Nhập thông tin từ bàn phím
    public static App nhapThongTin() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số tài khoản: ");
        String acc = sc.nextLine();
        System.out.print("Nhập số dư ban đầu: ");
        double bal = sc.nextDouble();
        return new App(acc, bal);
    }
}
