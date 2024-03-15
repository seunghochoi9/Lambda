package com.erichgamma.api.menu;

import com.erichgamma.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuRepository {
    private static MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static MenuRepository getInstance() {
        return instance;
    }

    private Connection conn;

    private PreparedStatement pstmt;

    private ResultSet rs;

    private MenuRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb",
                "erichgamma",
                "erichgammadb");
        pstmt = pstmt;
        rs = rs;
    }

    public Messenger insertMenu(Menu menu) {
        String sql = "INSERT INTO menus(category, item) VALUES(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, menu.getCategory());
            pstmt.setString(2, menu.getItem());
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e) {
            System.err.println("SQL Exception Occurred :" + menu.getCategory() + " " + menu.getItem());
            return Messenger.FAIL;
        }
    }

    public Messenger makeTable() {
        String sql = "CREATE TABLE IF NOT EXISTS menus (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "category VARCHAR(10) NOT NULL," +
                "item VARCHAR(20) NOT NULL)";
        try {
            pstmt = conn.prepareStatement(sql);
            return pstmt.executeUpdate() >= 0 ? Messenger.SUCCESS : Messenger.FAIL;
        } catch (SQLException e) {
            System.err.println("SQL Exception Occurred");
            return Messenger.FAIL;
        }
    }


    // 아래는 Messenger, Menu, List<?> 리턴타입 별 코딩 내용임, 참고용
    public Messenger returnMessenger() throws SQLException {
        String sql = "Update ...";
        pstmt = conn.prepareStatement(sql);
        int rs = pstmt.executeUpdate();
        if (rs > 0) {
            do {
                Menu m = Menu.builder()
                        .item("item")
                        .category("category")
                        .build();
            } while (rs > 0);
            return Messenger.SUCCESS;
        } else {
            return Messenger.FAIL;
        }
    }

    public Menu returnOneMenu() throws SQLException {
        System.out.println("repo 입장");
        String sql = "select * from menus where category = 'navigate';";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        Menu m = Menu.builder()
                .item(rs.getString("item"))
                .category(rs.getString("category"))
                .build();
        System.out.println(m);

        return null;
    }

    public List<?> returnAllMenus() throws SQLException {
        System.out.println("repo 입장");
        List<String> ls = new ArrayList<>();
        String sql = "select * from menus where category = 'user';";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            ls.add(rs.getString("item"));
        }
        System.out.println("repo 끝");
        return ls;
    }
}
