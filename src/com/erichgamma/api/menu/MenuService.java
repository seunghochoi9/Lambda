package com.erichgamma.api.menu;

import com.erichgamma.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    Messenger insertMenus() throws SQLException;
    void makeTable();


    // 리턴타입 별 참고용 코딩
    Messenger returnMessenger() throws SQLException;
    Menu returnOneMenu() throws SQLException;
    List<?> returnAllMenus() throws SQLException;
}
