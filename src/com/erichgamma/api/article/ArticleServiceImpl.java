package com.erichgamma.api.article;

import com.erichgamma.api.common.AbstractService;
import com.erichgamma.api.enums.Messenger;
import com.erichgamma.api.user.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService {
    private final static ArticleServiceImpl instance = new ArticleServiceImpl();

    public static ArticleServiceImpl getInstance() {
        return instance;
    }

    private ArticleRepository repository;

    private ArticleServiceImpl() {
        this.repository = ArticleRepository.getInstance();
    }


    @Override
    public Messenger save(Article article) throws SQLException {
        return null;
    }

    @Override
    public List findAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional getOne(String id) {
        return Optional.empty();
    }

    @Override
    public String delete(Article article) {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}
