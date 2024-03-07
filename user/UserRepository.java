package user;

import java.sql.*;

public class UserRepository {

    private static UserRepository instance = new UserRepository();

    private UserRepository(){}

    public static UserRepository getInstance() {
        return instance;
    }

    public String test(){
        return "UserRepository 연결";
    }
    public void findUSers() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/erichgammadb";
        String userName = "erichgamma";
        String password = "good0119!";

        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from board");

        resultSet.next();
        String name = resultSet.getString("name");

        System.out.println(name);

        resultSet.close();
        statement.close();
        connection.close();
    }
}