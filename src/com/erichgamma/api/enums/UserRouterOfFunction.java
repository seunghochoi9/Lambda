package com.erichgamma.api.enums;

import com.erichgamma.api.user.UserController;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public enum UserRouterOfFunction {
    EXIT("x", i -> {
        System.out.println("Exit");
        return false;
    }),
    SAVE("save", i -> {
        try {
            UserController.getInstance().save(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    LOGIN("login", i -> {
        UserController.getInstance().login(i);
        return true;
    }),
    FINDID("findId", i -> {
        UserController.getInstance().getOne(i);
        return true;
    }),
    UPDATE("update", i -> {
        UserController.getInstance().updatePassword(i);
        return true;
    }),
    DELET("del", i -> {
        UserController.getInstance().delete(i);
        return true;
    }),
    LIST("ls", i -> {
        try {
            UserController.getInstance().findUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    FINDNAME("findName", i -> {
        UserController.getInstance().findUsersByName(i)
                .forEach((j)-> { System.out.println(j);});
        return true;
    }),
    FINDJOB("findJob", i -> {
        UserController.getInstance().findUsersByJob(i)
                .forEach((j)-> { System.out.println(j);});
        return true;
    }),
    COUNT("count", i -> {
        UserController.getInstance().count();
        return true;
    }),
    TOUCH("touch", i -> {
        try {
            UserController.getInstance().createTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }),
    DELTABLE("rm", i -> {
        try {
            UserController.getInstance().delTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    });

    private final String name;
    private final Function<Scanner, Boolean> function;

    UserRouterOfFunction(String name, Function<Scanner, Boolean> function) {
        this.name = name;
        this.function = function;
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
                .findAny().orElse(EXIT).function.apply(scanner);
    }
}
