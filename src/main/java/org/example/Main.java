package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


        public static void main(String[] args) {

            Client client1 = new Client("Siqi","Zheng","47883ZFJ");
            Client client2 = new Client("Mario","wolf","87987GFF");
            Client client3 = new Client("Anna","Max","87987GFF");


            BankService bankService = new BankService();
            String bankAccount1 = bankService.openAccount(client1);
            String bankAccount2 = bankService.openAccount(client2);



            Account account1 = new Account(bankAccount1,new BigDecimal("0"),client1);
            account1.addAccountHolder(client3);
            System.out.println(account1);

            bankService.getAccount(bankAccount1).deposit(BigDecimal.valueOf(100.999));
            bankService.getAccount(bankAccount1).withdraw(BigDecimal.valueOf(20));

            bankService.bankTransfer(bankAccount1,bankAccount2,BigDecimal.valueOf(10));

            account1.deposit(BigDecimal.valueOf(100.999));
            account1.withdraw(BigDecimal.valueOf(20));
            Map<String, Account> m = new HashMap<>();
            m.put(bankAccount1,account1);
            BankService bankService1 = new BankService(m);
            System.out.println(bankService1);

            System.out.println(bankService1.split(bankAccount1));
        }
}