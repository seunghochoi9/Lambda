package user;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner scanner) throws SQLException {
        UserController controller = new UserController();
        String msg = controller.addUsers();
        System.out.println(" addUsers 결과 : "+msg);
        while(true){
            System.out.println("[사용자메뉴]\n" +
                    "x-Exit\n " +
                    "1-회원가입\n " +
                    "2-로그인\n " +
                    "3-ID검색\n " +
                    "4-비번변경\n" +
                    "5-탈퇴\n " +
                    "ls-회원목록\n " +
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수\n" +
                    "touch-테이블생성\n" +
                    "rm-테이블삭제\n" +
                    "");
            switch (scanner.next()){
                case "x":
                    System.out.println("종료");return;
                case "1":
                    System.out.println("1-회원가입");
                    System.out.println("ID, 비밀번호, 이름, 전화번호, 직업");
                    System.out.println("회원가입 결과 : "+ controller.save(scanner));
                    break;
                case "2":
                    System.out.println("2-로그인");
                    msg = controller.login(scanner);
                    System.out.println("로그인 결과 : "+msg);
                    break;
                case "3":
                    System.out.println("3-ID 검색");
                    System.out.println(controller.test());


                    System.out.println(controller.getOne(scanner));
                    break;
                case "4":
                    System.out.println("4-비번변경");
                    System.out.println(controller.updatePassword(scanner));
                    break;
                case "5":
                    System.out.println("5-탈퇴");
                    System.out.println(controller.delete(scanner));
                    break;
                case "ls":
                    System.out.println("6-회원목록");
                    List<?> users = controller.findUsers();
//                    users.forEach(i->{
//                        System.out.printf("회원정보: %s", i);
//                    });

//                    Map<String, ?> users = controller.getUserMap();
//                    users.forEach((k,v)->{
//                        System.out.printf("아이디: %s, 회원정보: %s", k, v);
//                    });
                    break;
                case "7":
                    System.out.println("7-이름검색");
                    controller.findUsersByName(scanner).forEach((i)->{
                        System.out.println(i);
                    });
                    break;
                case "8":
                    System.out.println("8-직업검색");
                    controller.findUsersByJob(scanner).forEach((i)->{
                        System.out.println(i);
                    });
                    break;
                case "9":
                    System.out.println("9-회원수");
                    String numberOfUsers = controller.count();
                    System.out.println("회원수 "+numberOfUsers);
                    break;
                case "touch":
                    System.out.println("touch-테이블생성");
                    System.out.println(controller.createTable());
                    break;
                case "rm":
                    System.out.println("rm-테이블삭제");
                    System.out.println(controller.delTable());
                    break;
            }

        }

    }
}