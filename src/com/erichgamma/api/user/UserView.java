package com.erichgamma.api.user;

import com.erichgamma.api.enums.UserRouterOfFunction;
import com.erichgamma.api.enums.UserRouterOfPredicate;

import java.sql.SQLException;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner scanner) throws SQLException {
        while (UserRouterOfPredicate.routing(scanner));
        System.out.printf("유저뷰 입장");

    }
}