import account.AccountView;
import board.BoardView;
import crawler.CrawlerService;
import crawler.CrawlerView;
import user.UserView;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("0-Exit 1-회원관리 2-{} 3-게시판 4-Crawler 5-사용자관리(맵) 6-은행");
            switch (scanner.next()) {
                case "0":
                    System.out.println("Exit");
                    return;
                case "1":
                    UserView.main(scanner);
                    break;
                case "2":
                    break;
                case "3":
                    BoardView.main();
                    break;
                case "4":
                    CrawlerView.main(scanner);
                    break;
                case "5":
                    UserView.main(scanner);
                    break;
                case "6":
                    AccountView.main(scanner);
                    break;

                default:
                    System.out.println("잘못된 입력입니다");
            }
        }
    }

}