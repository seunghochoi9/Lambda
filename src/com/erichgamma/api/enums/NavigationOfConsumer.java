//package com.erichgamma.api.enums;
//
//import com.erichgamma.api.user.UserView;
//
//import java.util.Scanner;
//import java.util.function.Consumer;
//import java.util.function.Function;
//
//public enum NavigationOfConsumer {
//
//    Exit("x", i -> System.out.println("exit")),
//    User("u", i -> System.out.println(i)),
//    BoardView("b", i -> System.out.println(i)),
//    AccountView("av", i -> System.out.println(i)),
//    CrawlerView("c", i -> System.out.println(i));
//
//    private final String name;
//    private final Consumer<String> consumer;
//
//
//    NavigationOfConsumer(String name, Consumer<String> consumer) {
//        this.name = name;
//        this.consumer = consumer;
//    }
//
//    public static String navigate(Scanner scanner) {
//        System.out.println("0-Exit 1-UserView 2-BoardView 3-AccountView 4-CrawlerView");
//        String str = scanner.next();
//        return "";
//    }
//}
//
