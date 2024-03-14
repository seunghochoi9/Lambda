package com.erichgamma.api.menu;

public class MenuController {
    MenuService service = new MenuService();

    public MenuController(MenuService service) {
        this.service = new MenuService();
    }
}
