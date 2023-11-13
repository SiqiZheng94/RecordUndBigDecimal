package org.example;

import java.math.BigDecimal;
import java.util.*;

public class BankService {

    private Map<String,Account> bankService = new HashMap<>();
    //private Set<Account> bankService = new HashSet();


    public BankService() {
    }

    public BankService(Map<String, Account> bankService) {
        this.bankService = bankService;
    }

    public String openAccount(Client client){
        String accountNumber = generateAccountNumber();
        Account newAccount = new Account(accountNumber,new BigDecimal("0"),client);
        bankService.put(accountNumber,newAccount);
        return accountNumber;

    }
    private String generateAccountNumber(){
        return UUID.randomUUID().toString();
    }
    public Account getAccount(String accountNum){
        return bankService.get(accountNum);
    }
    public void bankTransfer(String from,String to,BigDecimal howMuch){
        //bankService.get(from).withdraw(howMuch);
        //bankService.get(to).deposit(howMuch);
        Account fromAccount = getAccount(from);
        Account toAccount = getAccount(to);
        fromAccount.withdraw(howMuch);
        toAccount.deposit(howMuch);

    }
    public List<String> split(String accountNumber){
        Account originalAccount = getAccount(accountNumber);
        BigDecimal totalBalance = originalAccount.getAccountBalance();
        int numOfHolders = originalAccount.numberOfHolders();
        BigDecimal splitBalance = totalBalance.divide(BigDecimal.valueOf(numOfHolders));

        List<String> newAccountNumbers = new ArrayList<>();
        for (Client client:originalAccount.getClients()) {
            String newAccountNum = openAccount(client);
            Account newAccount = getAccount(newAccountNum);
            newAccount.deposit(splitBalance);
            newAccountNumbers.add(newAccountNum);
        }
        return newAccountNumbers;
    }
    @Override
    public String toString() {
        return "BankService{" +
                "bankService=" + bankService +
                '}';
    }
}
