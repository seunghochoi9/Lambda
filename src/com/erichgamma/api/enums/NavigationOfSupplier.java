//package com.erichgamma.api.enums;
//
//import com.erichgamma.api.user.UserView;
//
//import java.util.Scanner;
//import java.util.function.Consumer;
//import java.util.function.Supplier;
//
//
//public enum NavigationOfSupplier {
//    Exit("Exit", () -> ""),
//    User("UserView", () -> UserView.main()),
//    BoardView("BoardView", () -> ""),
//    AccountView("AccountView", () -> ""),
//    CrawlerView("CrawlerView", () -> "");
//
//    private final String name;
//    private final Supplier<Scanner> supplier;
//
//    NavigationOfSupplier(String name, Supplier<Scanner> supplier) {
//        this.name = name;
//        this.supplier = supplier;
//    }
//
//    public static String navigate(Scanner scanner) {
//        System.out.println("0-Exit 1-UserView 2-BoardView 3-AccountView 4-CrawlerView");
//        String str = scanner.next();
//        return "";
//    }
//
//}
//
//
//
//
