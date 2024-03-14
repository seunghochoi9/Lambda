package com.erichgamma.api.enums;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class NavigationOfSupplier {


    public enum Navigation{
        Exit("Exit", () -> ""),
        UserView("UserView", () -> ""),
        BoardView("BoardView", () -> ""),
        AccountView("AccountView", () -> ""),
        CrawlerView("CrawlerView", () -> "")

        ;

        private final String name;
        private final Supplier<String> supplier;

        Navigation(String name, Supplier<String> supplier) {
            this.name = name;
            this.supplier = supplier;
        }
    }

    public static String navigate(Scanner scanner) {
        System.out.println("0-Exit 1-UserView 2-BoardView 3-AccountView 4-CrawlerView");
        String str = scanner.next();
        return "";
    }


}
