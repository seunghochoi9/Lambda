package com.erichgamma.api.menu;

import java.sql.*;
import java.util.List;

public class MenuRepository {
    private static MenuRepository instance = new MenuRepository();

    public static MenuRepository getInstance() {
        return instance;
    }

    private Connection connection;

    private MenuRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb",
                "erichgamma",
                "erichgammadb");
    }

    public void menu() throws SQLException {
        String sql = "select * from com.erichgamma.api.menu";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();

        resultSet.close();
        pstmt.close();
        connection.close();

    }


}
