package com.erichgamma.api.enums;


import com.erichgamma.api.account.AccountView;
import com.erichgamma.api.crawler.CrawlerView;
import com.erichgamma.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum Navigation {
    EXIT("exit", i -> {
        System.out.println("Exit");
        return false;
    }),
    USER("user", i -> {
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),

    ACCOUNT("account", i -> {
        AccountView.main(i);
        return true;
    }),

    CRAWLER("crawler", i-> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    ERROR("error", i ->{
        System.out.println("input error");
        return true;
    })
    ;

    Navigation(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }
    private final String name;
    private final Predicate<Scanner> predicate;

    public static Boolean navigate(Scanner scanner){
        System.out.println("0-Exit 1-UserView 2-BoardView 3-AccountView 4-CrawlerView");
        String str = scanner.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(ERROR).predicate.test(scanner);
    }


}
