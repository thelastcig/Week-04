import java.util.*;

public class BankingSystem {
    private HashMap<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    static class WithdrawalRequest {
        int accountNumber;
        double amount;

        WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    public void createAccount(int accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        sortedAccounts.put(initialBalance, accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double oldBalance = accounts.get(accountNumber);
            sortedAccounts.remove(oldBalance);
            double newBalance = oldBalance + amount;
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void requestWithdrawal(int accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
        } else {
            System.out.println("Account not found.");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            int accountNumber = request.accountNumber;
            double amount = request.amount;

            if (accounts.containsKey(accountNumber)) {
                double balance = accounts.get(accountNumber);
                if (balance >= amount) {
                    sortedAccounts.remove(balance);
                    double newBalance = balance - amount;
                    accounts.put(accountNumber, newBalance);
                    sortedAccounts.put(newBalance, accountNumber);
                    System.out.println("Withdrawal successful for account " + accountNumber);
                } else {
                    System.out.println("Insufficient funds for account " + accountNumber);
                }
            } else {
                System.out.println("Account not found.");
            }
        }
    }

    public void displaySortedAccounts() {
        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, Integer> entry : sortedAccounts.entrySet()) {
            System.out.println("Account " + entry.getValue() + " - Balance: " + entry.getKey());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount(101, 5000);
        bank.createAccount(102, 3000);
        bank.createAccount(103, 7000);

        bank.deposit(101, 2000);
        bank.requestWithdrawal(102, 1000);
        bank.requestWithdrawal(103, 8000);
        
        bank.processWithdrawals();
        bank.displaySortedAccounts();
    }
}
