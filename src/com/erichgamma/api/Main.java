package com.erichgamma.api;

import com.erichgamma.api.account.AccountView;
import board.BoardView;
import com.erichgamma.api.crawler.CrawlerView;
import com.erichgamma.api.user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("0-Exit 1-UserView 2-BoardView 3-AccountView 4-CrawlerView");
            switch (scanner.next()) {
                case "0": System.out.println("Exit"); return;
                case "1": UserView.main(scanner); break;
                case "2": BoardView.main(); break;
                case "3": AccountView.main(scanner); break;
                case "4": CrawlerView.main(scanner); break;
                default:
                    System.out.println("잘못된 입력입니다");
            }
        }
    }

}