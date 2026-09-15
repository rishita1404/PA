abstract class BankAccount {
    private final String accountNumber;
    private String accountHolderName;
    protected double balance;
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public void setAccountHolderName(String accountHolderName) {
        if (accountHolderName == null || accountHolderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.accountHolderName = accountHolderName;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        this.balance += amount;
        System.out.printf("[%s] Deposited: $%.2f | New Balance: $%.2f%n", accountNumber, amount, balance);
    }
    public void deposit(double amount, String note) {
        System.out.printf("Transaction Note: %s%n", note);
        deposit(amount);
    }
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            System.out.printf("[%s] Insufficient funds to withdraw $%.2f (Balance: $%.2f)%n", accountNumber, amount, balance);
            return false;
        }
        this.balance -= amount;
        System.out.printf("[%s] Withdrew: $%.2f | Remaining Balance: $%.2f%n", accountNumber, amount, balance);
        return true;
    }
    public abstract double calculateInterest();
    public void displayAccountDetails() {
        System.out.printf("Account: %s | Holder: %s | Balance: $%.2f%n", accountNumber, accountHolderName, balance);
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;
    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance, double interestRate) {
        super(accountNumber, accountHolderName, initialBalance);
        this.interestRate = interestRate;
    }
    @Override
    public double calculateInterest() {
        return (getBalance() * interestRate) / 100.0;
    }
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.printf("  Type: Savings | Interest Rate: %.2f%% | Estimated Annual Interest: $%.2f%n", interestRate, calculateInterest());
    }
}
class CheckingAccount extends BankAccount {
    private double overdraftLimit;
    public CheckingAccount(String accountNumber, String accountHolderName, double initialBalance, double overdraftLimit) {
        super(accountNumber, accountHolderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance + overdraftLimit) {
            System.out.printf("[%s] Overdraft limit exceeded! Limit: $%.2f, Tried: $%.2f%n", getAccountNumber(), overdraftLimit, amount);
            return false;
        }
        this.balance -= amount;
        System.out.printf("[%s] Checking Withdrew: $%.2f | Current Balance: $%.2f%n", getAccountNumber(), amount, balance);
        return true;
    }
    @Override
    public double calculateInterest() {
        return 0.0;
    }
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.printf("  Type: Checking | Overdraft Limit: $%.2f%n", overdraftLimit);
    }
}
public class OOPPrinciplesDemo {
    public static void main(String[] args) {
        System.out.println("=== Demonstrating 4 Core OOP Principles ===");
        BankAccount acc1 = new SavingsAccount("SA-101", "Alice Smith", 5000.0, 4.0);
        BankAccount acc2 = new CheckingAccount("CA-202", "Bob Jones", 1500.0, 1000.0);
        BankAccount[] accounts = { acc1, acc2 };
        for (BankAccount acc : accounts) {
            System.out.println("----------------------------------------------");
            acc.displayAccountDetails();
            acc.deposit(500.0, "Bonus credit");
            acc.withdraw(2200.0);
            System.out.printf("Calculated Interest: $%.2f%n", acc.calculateInterest());
        }
    }
}
