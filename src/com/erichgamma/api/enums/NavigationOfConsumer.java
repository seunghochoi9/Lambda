package com.erichgamma.api.enums;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class NavigationOfConsumer {
    public enum Navigation{

        Exit("Exit", i -> System.out.println(i)),
        UserView("UserView", i -> System.out.println(i)),
        BoardView("BoardView", i -> System.out.println(i)),
        AccountView("AccountView", i -> System.out.println(i)),
        CrawlerView("CrawlerView", i -> System.out.println(i))

        ;

        private final String name;
        private final Consumer<String> consumer;


        Navigation(String name, Consumer<String> consumer) {
            this.name = name;
            this.consumer = consumer;
        }
    }

    public static String navigate(Scanner scanner) {
        System.out.println("0-Exit 1-UserView 2-BoardView 3-AccountView 4-CrawlerView");
        String str = scanner.next();
        return "";
    }
}
