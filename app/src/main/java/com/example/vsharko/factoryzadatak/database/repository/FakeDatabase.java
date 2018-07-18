package com.example.vsharko.factoryzadatak.database.repository;
import com.example.vsharko.factoryzadatak.model.Article;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase implements ArticlesRepository {

    private static FakeDatabase model;

    private FakeDatabase() {
    }

    private List<Article> listOfArticles = new ArrayList<>();

    public static FakeDatabase getInstance() {
        if (model == null) {
            model = new FakeDatabase();
            return model;
        } else {
            return model;
        }
    }

    @Override
    public List<Article> getArticles() {
        return listOfArticles;
    }

    @Override
    public void setListOfArticles(List<Article> listOfArticles) {
            this.listOfArticles.clear();
            this.listOfArticles.addAll(listOfArticles);
    }
}