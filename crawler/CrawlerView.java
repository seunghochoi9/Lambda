package crawler;

import org.jsoup.nodes.Element;
import user.UserController;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CrawlerView {
    public static void main(Scanner scanner) throws IOException {
        CrawlerController controller = new CrawlerController();

        while (true) {
            System.out.println("[사용자메뉴] 0-Exit\n " +
                    "1-bugsMusic\n " +
                    "2-MelonMusic\n " +
                    "3-ID검색\n " +
                    "4-비번변경\n" +
                    "5-탈퇴\n " +
                    "6-회원목록\n " +
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수");
            switch (scanner.next()) {
                case "0":
                    System.out.println("Exit");
                    return;
                case "1":
                    System.out.println("1-bugsMusic");
                    Map<String, ?> map = controller.findBugsMusic(scanner);
                    Iterator<Element> title = (Iterator<Element>) map.get("title");
                    Iterator<Element> artist = (Iterator<Element>) map.get("artist");
                    Iterator<Element> rank = (Iterator<Element>) map.get("rank");
                    System.out.println("bugsMusic List: ");
                    while (rank.hasNext()) {
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
                    }
                    break;
                case "2":
                    System.out.println("1-MelonMusic");
                    Map<String, ?> mapMelon = controller.findMelonMusic(scanner);
                    Iterator<Element> melonTitle = (Iterator<Element>) mapMelon.get("title");
                    Iterator<Element> melonArtist = (Iterator<Element>) mapMelon.get("artist");
                    Iterator<Element> melonRank = (Iterator<Element>) mapMelon.get("rank");
                    System.out.println("bugsMusic List: ");
                    while (melonRank.hasNext()) {
                        System.out.println(melonRank.next().text() + "위 " + melonArtist.next().text() + " - " + melonTitle.next().text());
                    }
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
