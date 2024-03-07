package article;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArticleView {
    public static void main(Scanner scanner) throws SQLException {
        ArticleController articleController = new ArticleController();
        while (true) {
            System.out.println("0-Exit 1-000");
            switch (scanner.next()) {
                case "0":
                    System.out.println("Exit");
                    return;
                case "1":
                    List<?> article = articleController.getArticle();
                    break;

                default:
                    System.out.println("잘못된 입력입니다");
            }
        }
    }
}
