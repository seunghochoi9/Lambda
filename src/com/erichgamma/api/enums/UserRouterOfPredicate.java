package com.erichgamma.api.enums;


import com.erichgamma.api.menu.MenuController;
import com.erichgamma.api.user.UserController;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouterOfPredicate {
    Exit("x", (scanner) -> {
        System.out.println("Exit");
        return false;
    }),
    Save("joi", (scanner) -> {
        try {
            UserController.getInstance().save(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Login("log", (scanner) -> {
        UserController.getInstance().login(scanner);
        return true;
    }),
    FindId("cat", (scanner) -> {
        UserController.getInstance().getOne(scanner);
        return true;
    }),
    UpdatePW("ch-pw", (scanner) -> {
        UserController.getInstance().updatePassword(scanner);
        return true;
    }),
    Delete("rm", (scanner) -> {
        UserController.getInstance().delete(scanner);
        return true;
    }),
    List("ls-a", (scanner) -> {
        try {
            UserController.getInstance().findUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    FindName("ls-n", (scanner) -> {
        UserController.getInstance().findUsersByName(scanner);
        return true;
    }),
    FindJob("ls-job", (scanner) -> {
        UserController.getInstance().findUsersByJob(scanner);
        return true;
    }),
    Count("cnt", (scanner) -> {
        UserController.getInstance().count();
        return true;
    }),
    TOUCH("touch", (scanner) -> {
        try {
            UserController.getInstance().createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    DelTable("deltable", (scanner) -> {
        try {
            UserController.getInstance().delTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    UserError("error", (scanner) -> {
        System.out.println("input error");
        return true;
    })
    ;
    private final String name;
    private final Predicate<Scanner> predicate;


    UserRouterOfPredicate(String name, Predicate<Scanner> predicate) {
            this.name = name;
            this.predicate = predicate;
    }
    public static Boolean routing(Scanner scanner) throws SQLException {
        List<?> ls = MenuController.getInstance().returnAllMenus();
        ls.forEach(i -> System.out.println(i));
        String msg = scanner.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(msg))
                .findAny().orElse(UserError).predicate.test(scanner);
    }

}
