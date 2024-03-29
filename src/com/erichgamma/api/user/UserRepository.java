package com.erichgamma.api.user;

import com.erichgamma.api.enums.Messenger;
import com.erichgamma.api.user.User;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private static UserRepository instance;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserRepository getInstance() {
        return instance;
    }

    private Connection connection;

    private PreparedStatement pstmt;

    private ResultSet rs;

    private UserRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/erichgammadb",
                "erichgamma",
                "erichgammadb");
        pstmt = pstmt;
        rs = rs;
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from com.erichgamma.api.board";
        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                System.out.println("-- inner ---");
                System.out.printf("ID: %d\t Title: %s\t Content: %s\t Writer: %s\n",
                        rs.getInt("id"),
                        rs.getString("Title"),
                        rs.getString("Content"),
                        rs.getString("Writer"));
                System.out.println();
            } while (rs.next());

        } else {
            System.out.println("데이터가 없습니다.");
        }
        rs.close();
        pstmt.close();
        connection.close();
        return null;
    }

    public Messenger createTable() throws SQLException {
        String Sql = "CREATE TABLE test (id INT AUTO_INCREMENT PRIMARY KEY, " +
                "username VARCHAR(20) NOT NULL," +
                "name VARCHAR(20)," +
                "phone VARCHAR(20)," +
                "job VARCHAR(20)," +
                "height VARCHAR(20)," +
                "weight VARCHAR(20));";
        PreparedStatement pstmt = connection.prepareStatement(Sql);
        pstmt.close();
        connection.close();
        return (pstmt.executeUpdate() >= 0) ? Messenger.SUCCESS : Messenger.FAIL ;
    }

    public Messenger delTable() throws SQLException {
        String Sql = "DROP TABLE test;";
        PreparedStatement pstmt = connection.prepareStatement(Sql);
        pstmt.close();
        connection.close();
        return (pstmt.executeUpdate() >= 0) ? Messenger.SUCCESS : Messenger.FAIL ;
    }

    public Messenger save(User user) throws SQLException {
//        Map<String, User> userI = new HashMap<>();
//        userI.put(user.getUsername(), user);


        String Sql = "insert into users(username, password, name, phone, job) values (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(Sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getName());
        pstmt.setString(4, user.getPhone());
        pstmt.setString(5, user.getJob());
        pstmt.executeUpdate();

        System.out.println("회원가입 완료!");
        return (pstmt.executeUpdate() >= 0) ? Messenger.SUCCESS : Messenger.FAIL ;
    }
}