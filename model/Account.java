package model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private String owner;
    private double balance;
    private List<Transaction> transactions;

    public Account(int id, String owner) {
        this.id = id;
        this.owner = owner;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getOwner() { return owner; }
    public double getBalance() { return balance; }
    public List<Transaction> getTransactions() { return transactions; }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Depósito", amount));
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("Saque", amount));
            return true;
        }
        return false;
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Titular: " + owner + " | Saldo: R$ " + balance;
    }
}
