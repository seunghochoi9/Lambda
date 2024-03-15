package com.erichgamma.api.menu;

import com.erichgamma.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    MenuServiceImpl service;

    public MenuController() {
        this.service = MenuServiceImpl.getInstance();
    }

    private static MenuController instance = new MenuController();

    public static MenuController getInstance() {
        return instance;
    }

    public Messenger insertMenus() {
        return service.insertMenus();
    }

    public void makeTable() {
        service.makeTable();
    }


    // 리턴타입 별 참고용 코딩
    public Messenger returnMessenger() throws SQLException {
        return service.returnMessenger();
    }
    public Menu returnOneMenu() throws SQLException {
        return service.returnOneMenu();
    }
    public List<?> returnAllMenus() throws SQLException {
        return service.returnAllMenus();
    }
}
