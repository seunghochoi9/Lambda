package com.erichgamma.api.enums;


import com.erichgamma.api.user.UserController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum UserRouterOfPredicate {
    Exit("x", (scanner) -> {
        System.out.println("Exit");
        return false;
    }),
    Save("save", (scanner) -> {
        try {
            UserController.getInstance().save(scanner);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    Login("login", (scanner) -> {
        UserController.getInstance().login(scanner);
        return true;
    }),
    FindId("findId", (scanner) -> {
        UserController.getInstance().getOne(scanner);
        return true;
    }),
    Update("update", (scanner) -> {
        UserController.getInstance().updatePassword(scanner);
        return true;
    }),
    Delete("del", (scanner) -> {
        UserController.getInstance().delete(scanner);
        return true;
    }),
    List("ls", (scanner) -> {
        try {
            UserController.getInstance().findUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    FindName("findName", (scanner) -> {
        UserController.getInstance().findUsersByName(scanner);
        return true;
    }),
    FindJob("findJob", (scanner) -> {
        UserController.getInstance().findUsersByJob(scanner);
        return true;
    }),
    Count("count", (scanner) -> {
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
    DelTable("rm", (scanner) -> {
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
    public static Boolean routing(Scanner scanner) {
        System.out.println("[사용자메뉴]\n" +
                "x-Exit\n " +
                "save-회원가입\n " +
                "login-로그인\n " +
                "findId-ID검색\n " +
                "update-비번변경\n" +
                "del-탈퇴\n " +
                "ls-회원목록\n " +
                "findName-이름검색\n" +
                "findJob-직업검색\n" +
                "count-회원수\n" +
                "touch-테이블생성\n" +
                "rm-테이블삭제\n" +
                "");
        String msg = scanner.next();
        return Stream.of(values())
                .filter(i -> i.name.equals(msg))
                .findAny().orElse(UserError).predicate.test(scanner);
    }

}
