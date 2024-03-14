import account.AccountView;
import article.ArticleView;
import board.BoardView;
import crawler.CrawlerService;
import crawler.CrawlerView;
import user.UserView;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("x-Exit \n" +
                    "u-UserView \n" +
                    "b-BoardView \n" +
                    "s-AccountView \n" +
                    "c-CrawlerView \n" +
                    "a-ArticleView");
            switch (scanner.next()) {
                case "x":
                    System.out.println("Exit");
                    return;
                case "u": UserView.main(scanner); break;
                case "b": BoardView.main(); break;
                case "s": AccountView.main(scanner); break;
                case "c": CrawlerView.main(scanner); break;
                case "a": ArticleView.main(scanner); break;

                default:
                    System.out.println("잘못된 입력입니다");
            }
        }
    }
}