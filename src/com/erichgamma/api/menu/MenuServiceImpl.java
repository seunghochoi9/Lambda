package com.erichgamma.api.menu;

import com.erichgamma.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuServiceImpl implements MenuService {
    private MenuRepository repository;

    private MenuServiceImpl() {
        this.repository = MenuRepository.getInstance();
    }

    private static MenuServiceImpl instance = new MenuServiceImpl();

    public static MenuServiceImpl getInstance() {
        return instance;
    }

    /**
     * 공통 메뉴 명령어 정의
     * x means 'Exit'
     * mk means 'Create Table'
     * cat means 'Find The One'
     * touch means 'Insert One'
     * ch-* means 'Change What'
     * rm means 'Delete Row'
     * ls-a means 'All List'
     * ls-n means 'Find By Name'
     * ls-* means 'Something List'
     * cnt means 'Count'
     * 이 외에 일상적이 아닌 단어는 약어 사용
     * withdraw -> with
     * deposit -> depo
     * balance -> bal
     * */
//    String[] categories = {"navigate", "user", "account", "article", "board", "soccer"};
//    String[][] menus = {{"x", "usr", "acc", "cwl", "art", "bbs","scc"},
//            {"x", "mk", "joi", "log", "cat :", "ch-pw", "rm",
//                    "ls-a", "ls-n", "ls-job", "cnt"},
//            {"x", "mk", "touch", "with", "depo", "bal", "rm", "cat", "ls-a"},
//            {"x", "mk"},
//            {"x", "mk"},
//            {"x", "mk"},
//    };

    public Messenger insertMenus() {
        String[] categories = {"navigate", "user", "account", "article", "board", "soccer"};
        String[][] menus = {{"x:Exit", "usr:user", "acc:account", "cwl:crawler", "art:article", "bbs:board","scc:soccer"},
                {"x : 종료", "mk : UserTable", "joi: 회원가입", "log : 로그인", "cat : ID 검색", "ch-pw : PW 변경",
                        "rm : 탈퇴", "ls-a : 회원목록", "ls-n : 이름 검색", "ls-job : 직업 검색", "cnt : 회원수"},
                {"x : Exit", "mk: Account Table 생성", "touch:Create", "depo:Deposit", "with:Withdraw", "bal:Balance", "rm:Delete", "ls-a:List"},
                {"x : Exit", "mk:Article Table 생성", "1 : Article"},
                {"x : Exit", "mk:Board Table 생성", "1 : Board" },
                {"x : Exit", "mk : Soccer Table 생성", "1 : Soccer"},
                };
        for(int i = 0; i < menus.length; i++)
            for(int j = 0; j < menus[i].length; j++)
                repository.insertMenu(Menu.builder().category(categories[i]).item(menus[i][j]).build());
        return Messenger.SUCCESS;
    }

    public void makeTable() {
        repository.makeTable();
    }


    // 리턴타입 별 참고용 코딩
    @Override
    public Messenger returnMessenger() throws SQLException {
        return repository.returnMessenger();
    }
    @Override
    public Menu returnOneMenu() throws SQLException {
        return repository.returnOneMenu();
    }
    @Override
    public List<?> returnAllMenus() throws SQLException {
        return repository.returnAllMenus();
    }
}
