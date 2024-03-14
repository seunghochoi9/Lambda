package com.erichgamma.api.account;



import com.erichgamma.api.enums.Messenger;

import java.util.List;
import java.util.Scanner;

public class AccountController {
    com.erichgamma.api.account.AccountServiceImpl accountService;

    public AccountController() {
        this.accountService = com.erichgamma.api.account.AccountServiceImpl.getInstance();
    }

    public Messenger createAccount(Scanner sc) {
        return accountService.save(com.erichgamma.api.account.Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build()
        );
    }

    public String deposit(Scanner sc) {
        return accountService.deposit(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());
    }

    public String withdraw(Scanner sc) {
        return accountService.withdraw(Account.builder()
                .id(sc.nextLong())
                .accountNumber(sc.next())
                .accountHolder(sc.next())
                .balance(sc.nextDouble())
                .transactionDate(null)
                .build());
    }

    public String getBalance(Scanner sc) {
        return accountService.getBalance(sc.next());
    }

    public String deleteAccount(Scanner sc) {
        return accountService.delete(Account.builder().accountNumber(sc.next()).build());
    }

    public List<?> getAccounts() {
        return accountService.findAll();
    }
}