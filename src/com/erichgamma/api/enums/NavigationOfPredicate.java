package com.erichgamma.api.enums;

import com.erichgamma.api.account.AccountView;
import com.erichgamma.api.board.BoardView;
import com.erichgamma.api.crawler.CrawlerView;
import com.erichgamma.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum NavigationOfPredicate {
    EXIT("x", i -> {
        System.out.println("Exit");
        return false;
    }),
    USER("u", i -> {
        try {
            UserView.main(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("userview: 테스트");
        return true;
    }),

    BOARD("b", i -> {
        BoardView.main(i);
        return true;
    }),


    ACCOUNT("ac", i -> {
        AccountView.main(i);
        return true;
    }),

    CRAWLER("c", i-> {
        try {
            CrawlerView.main(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    NAVIGATION_ERROR("error", i ->{
        System.out.println("input error");
        return true;
    })
    ;

    NavigationOfPredicate(String name, Predicate<Scanner> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    private final String name;
    private final Predicate<Scanner> predicate;

    public static Boolean navigate(Scanner scanner){
        System.out.println("x-Exit u-UserView b-BoardView ac-AccountView c-CrawlerView");
        String str = scanner.next();
        return Stream.of(values()).filter(i -> i.name.equals(str))
                .findAny().orElse(NAVIGATION_ERROR).predicate.test(scanner);
    }


}
