package com.erichgamma.api.enums;

import com.erichgamma.api.account.AccountView;
import com.erichgamma.api.board.BoardView;
import com.erichgamma.api.crawler.CrawlerView;
import com.erichgamma.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;

public class NavigationOfFunction {

    public enum Navigation{

        Exit("x", i -> "x"),
        Userview("u", i -> {
            try {
                UserView.main(i);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return "";
        }),
        BOARD("b", i -> {
            BoardView.main(i);
            return "";
        }),

        Account("ac", i -> {
            AccountView.main(i);
            return "";
        }),
        Crawler("c", i -> {
            try {
                CrawlerView.main(i);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return "";
        })
        ;


        private final String name;
        private final Function<Scanner, String> function;


        Navigation(String name, Function<Scanner, String> function) {
            this.name = name;
            this.function = function;
        }
    }

    public static String navigate(Scanner scanner){
        System.out.println("x-Exit u-UserView b-BoardView ac-AccountView c-CrawlerView");
        String str = scanner.next();
        System.out.println("선택한 메뉴" + str);
        return str;
    }
}
