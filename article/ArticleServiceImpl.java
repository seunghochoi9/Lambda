package article;

import java.sql.SQLException;
import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    private static ArticleServiceImpl instance = new ArticleServiceImpl();
    public static ArticleServiceImpl getInstance() {
        return instance;
    }

    ArticleRepository rp;

    private ArticleServiceImpl() {
        this.rp = ArticleRepository.getInstance();
    }

    @Override
    public List<?> getArticle() throws SQLException {
        return rp.getArticle();
    }
}
