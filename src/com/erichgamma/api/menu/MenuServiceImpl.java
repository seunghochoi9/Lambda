package com.erichgamma.api.menu;

public class MenuServiceImpl implements MenuService {
    private MenuRepository repository;

    private MenuServiceImpl() {
        this.repository = MenuRepository.getInstance();
    }

    private static MenuServiceImpl instance = new MenuServiceImpl();

    public static MenuServiceImpl getInstance() {
        return instance;
    }
}
