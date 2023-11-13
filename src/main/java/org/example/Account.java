package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private BigDecimal accountBalance = new BigDecimal("0");
    //private Client client;
    private List<Client> clients = new ArrayList<>();

    public Account() {
    }

    public Account(String accountNumber, BigDecimal accountBalance, Client clients) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.clients.add(clients);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public List<Client> getClients() {
        return clients;
    }
    public void addAccountHolder(Client client){
        clients.add(client);

    }

    public void deposit(BigDecimal money){
        //BigDecimal depositMoney = new BigDecimal(Double.toString(money));
        accountBalance = accountBalance.add(money);
        System.out.println("account balance of (" +accountNumber+ ") now is: "+ accountBalance);
    }
    public void withdraw(BigDecimal money){
        //BigDecimal withdrawMoney = new BigDecimal(Double.toString(money));
        accountBalance = accountBalance.subtract(money);
        System.out.println("account balance of ("+ accountNumber +") now is: "+ accountBalance);
    }
    public int numberOfHolders(){
        return clients.size();
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountBalance=" + accountBalance +
                ", clients=" + clients +
                '}';
    }
}
