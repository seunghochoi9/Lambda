package com.erichgamma.api.menu;

public class MenuController {
    MenuServiceImpl service;

    public MenuController() {
        this.service = MenuServiceImpl.getInstance();
    }

    private static MenuController instance = new MenuController();

    public static MenuController getInstance() {
        return instance;
    }
}
