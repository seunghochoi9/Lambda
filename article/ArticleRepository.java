package article;

import user.UserServiceImpl;

import java.sql.*;
import java.util.List;

public class ArticleRepository {

    private static ArticleRepository instance;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArticleRepository getInstance() {
        return instance;
    }

    Connection connection;

    private ArticleRepository() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/erichgammadb", "erichgamma", "erichgammadb");

    }

    public List<?> getArticle() throws SQLException {
        String sql = "select * from articles";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery("select * from articles");
        if(resultSet.next()){
            do{
                System.out.println("-- inner ---");
                System.out.printf("ID: %d\t Title: %s\t Content: %s\t Writer: %s\n",
                        resultSet.getInt("id"),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4));
                System.out.println();
            }while(resultSet.next());

        }else{
            System.out.println("데이터가 없습니다.");
        }
        resultSet.close();
        pstmt.close();
        connection.close();
        return null;
    }
}
