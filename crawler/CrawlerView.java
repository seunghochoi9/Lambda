package crawler;

import user.UserController;

import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner scanner) {
        CrawlerController controller = new CrawlerController();

        while (true) {
            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1-벅스뮤직\n " +
                    "2-로그인\n " +
                    "3-ID검색\n " +
                    "4-비번변경\n" +
                    "5-탈퇴\n " +
                    "6-회원목록\n " +
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수");
            switch (scanner.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("1-벅스뮤직");
                    Map<String, ?> map = controller.findBugsMusic(scanner);
                    System.out.println("벅스뮤직 결과: ");
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":


                    break;
                case "7":

                    break;
                case "8":

                    break;
                case "9":

                    break;

            }

        }

    }
}
