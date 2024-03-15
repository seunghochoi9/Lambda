package com.erichgamma.api;

import com.erichgamma.api.enums.Messenger;
import com.erichgamma.api.enums.NavigationOfFunction;
import com.erichgamma.api.enums.NavigationOfPredicate;
import com.erichgamma.api.menu.Menu;
import com.erichgamma.api.menu.MenuController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, SQLException {
        while (NavigationOfPredicate.navigate(scanner)) ;



//        // 리턴타입 별 참고용 코딩
////        Messenger msg1 = MenuController.getInstance().returnMessenger();
////        Menu msg2 = MenuController.getInstance().returnOneMenu();
////        List<?> msg3 = MenuController.getInstance().returnAllMenus();
//        MenuController.getInstance().returnAllMenus();


        // 람다 함수별 enum 내용들
//         MenuController.getInstance().insertMenus();
//        MenuController.getInstance().makeTable();
//        NavigationOfConsumer.navigate(scanner);
        //while
//        String a = NavigationOfSupplier.navigate(scanner);
//        while (f.equals("x"));
//        while (!NavigationOfFunction.navigate(scanner).equals("x")) ;
//        while (f.equals("x"));

    }
}