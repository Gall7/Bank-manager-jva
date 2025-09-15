import model.Account;
import service.BankService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bank = new BankService();
        Scanner sc = new Scanner(System.in);
        int accountIdCounter = 1;

        while (true) {
            System.out.println("\n=== Gerenciador de Contas Bancárias ===");
            System.out.println("1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Histórico de transações");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Nome do titular: ");
                    String owner = sc.nextLine();
                    bank.addAccount(new Account(accountIdCounter++, owner));
                    System.out.println("Conta criada!");
                }
                case 2 -> {
                    System.out.print("ID da conta: ");
                    int id = sc.nextInt();
                    System.out.print("Valor: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    Account acc = bank.findAccountById(id);
                    if (acc != null) {
                        acc.deposit(amount);
                        System.out.println("Depósito realizado!");
                    } else System.out.println("Conta não encontrada!");
                }
                case 3 -> {
                    System.out.print("ID da conta: ");
                    int id = sc.nextInt();
                    System.out.print("Valor: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    Account acc = bank.findAccountById(id);
                    if (acc != null && acc.withdraw(amount)) System.out.println("Saque realizado!");
                    else System.out.println("Saldo insuficiente ou conta não encontrada!");
                }
                case 4 -> {
                    System.out.print("ID da conta origem: ");
                    int fromId = sc.nextInt();
                    System.out.print("ID da conta destino: ");
                    int toId = sc.nextInt();
                    System.out.print("Valor: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    if (bank.transfer(fromId, toId, amount)) System.out.println("Transferência realizada!");
                    else System.out.println("Erro na transferência!");
                }
                case 5 -> {
                    System.out.print("ID da conta: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Account acc = bank.findAccountById(id);
                    if (acc != null) System.out.println(acc);
                    else System.out.println("Conta não encontrada!");
                }
                case 6 -> {
                    System.out.print("ID da conta: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Account acc = bank.findAccountById(id);
                    if (acc != null) {
                        System.out.println("Transações:");
                        for (var t : acc.getTransactions()) System.out.println(t);
                    } else System.out.println("Conta não encontrada!");
                }
                case 0 -> {
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
