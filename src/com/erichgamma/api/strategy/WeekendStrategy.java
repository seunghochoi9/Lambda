package com.erichgamma.api.strategy;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum WeekendStrategy {

    Mon("1", i -> "Mon"),
    Tues("2", i -> "Tues"),
    Wed("3", i -> "Wed"),
    Thurs("4", i -> "Thurs"),
    Fri("5", i -> "Fri"),
    Sat("6", i -> "Sat"),
    Sun("7", i -> "Sun"),
    Wrong("", i -> "wrong")
    ;

    private final String name;

    private final Function<String, String> function;

    WeekendStrategy(String name, Function<String, String> function) {
        this.name = name;
        this.function = function;
    }

    public static String excute(Scanner sc) {
        System.out.println("1~7 입력: ");
        String day = sc.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(day))
                .findAny()
                .orElseGet(() -> Wrong)
                .function.apply(day);
    }
}
