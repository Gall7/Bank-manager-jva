package service;

import model.Account;
import model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BankService {
    private List<Account> accounts;

    public BankService() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccountById(int id) {
        for (Account a : accounts) {
            if (a.getId() == id) return a;
        }
        return null;
    }

    public boolean transfer(int fromId, int toId, double amount) {
        Account from = findAccountById(fromId);
        Account to = findAccountById(toId);
        if (from != null && to != null && from.withdraw(amount)) {
            to.deposit(amount);
            from.addTransaction(new Transaction("Transferência enviada", amount));
            to.addTransaction(new Transaction("Transferência recebida", amount));
            return true;
        }
        return false;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
