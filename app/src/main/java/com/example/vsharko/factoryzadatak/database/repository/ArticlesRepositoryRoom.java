package com.example.vsharko.factoryzadatak.database.repository;
import com.example.vsharko.factoryzadatak.App;
import com.example.vsharko.factoryzadatak.database.repository.repositoryDI.DaggerRepositoryComponent;
import com.example.vsharko.factoryzadatak.database.repository.repositoryDI.RepositoryComponent;
import com.example.vsharko.factoryzadatak.database.repository.repositoryDI.RepositoryModule;
import com.example.vsharko.factoryzadatak.database.room.ArticlesDao;
import com.example.vsharko.factoryzadatak.model.Article;

import java.util.List;

import javax.inject.Inject;

public class ArticlesRepositoryRoom implements ArticlesRepository {

    private ArticlesDao articlesDao;

    @Inject
    public ArticlesRepositoryRoom() {
        RepositoryComponent component = DaggerRepositoryComponent.builder()
                .repositoryModule(new RepositoryModule(App.getInstance().getApplicationContext()))
                .build();
        articlesDao = component.injectDao();
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
