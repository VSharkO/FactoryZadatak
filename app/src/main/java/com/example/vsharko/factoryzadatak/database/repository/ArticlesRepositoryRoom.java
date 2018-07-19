package com.example.vsharko.factoryzadatak.database.repository;

import com.example.vsharko.factoryzadatak.App;
import com.example.vsharko.factoryzadatak.database.room.ArticlesDao;
import com.example.vsharko.factoryzadatak.database.room.ArticlesRoomDatabase;
import com.example.vsharko.factoryzadatak.model.Article;

import java.util.List;

public class ArticlesRepositoryRoom implements ArticlesRepository {

    private ArticlesDao articlesDao;

    public ArticlesRepositoryRoom() {
            ArticlesRoomDatabase database = ArticlesRoomDatabase.getDatabase(App.getInstance().getApplicationContext());
            articlesDao=database.articlesDao();
    }

    @Override
    public List<Article> getArticles() {
        return articlesDao.getArticles();
    }

    @Override
    public void setListOfArticles(List<Article> listOfArticles) {
        articlesDao.deleteAllArticles();
        for (Article article:listOfArticles) {
            articlesDao.insert(article);
        }
    }
}
