package com.erichgamma.api.user;

import com.erichgamma.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static final UserRepository instance;
    private PreparedStatement pstmt;
    private ResultSet rs;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection conn;
    private UserRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bitcampdb",
                "root",
                "rootroot");
        pstmt  = null;
        rs = null;
    }

    public static UserRepository getInstance() {
        return instance;
    }

    public String test(){
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from board";
        System.out.println("sql : "+ sql);
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        List<User> ls = new ArrayList<>();
        if(rs.next()){
            do{
                ls.add(User.builder()
                        .id(rs.getLong("id"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .phone(rs.getString("phone"))
                        .job(rs.getString("job"))
                        .build());
            }while(rs.next());

        }else{
            System.out.println("데이터가 없습니다.");
        }

        return ls;
    }

    public Messenger createUsers() throws SQLException {
        String sql ="CREATE TABLE IF NOT EXISTS members (\\n\" +\n" +
                "        \"                       id INT AUTO_INCREMENT PRIMARY KEY,\\n\" +\n" +
                "        \"                       member_name VARCHAR(20) NOT NULL,\\n\" +\n" +
                "        \"                       password VARCHAR(20) NOT NULL,\\n\" +\n" +
                "        \"                       name VARCHAR(20),\\n\" +\n" +
                "        \"                       phone_number VARCHAR(20),\\n\" +\n" +
                "        \"                       job VARCHAR(20),\\n\" +\n" +
                "        \"                       height VARCHAR(20),\\n\" +\n" +
                "        \"                       weight VARCHAR(20)\\n\" +\n" +
                "        \"";
        pstmt = conn.prepareStatement(sql);
        return (pstmt.executeUpdate() == 0) ? Messenger.SUCCESS: Messenger.FAIL;
    }
}