package com.example.vsharko.factoryzadatak.model;

import com.example.vsharko.factoryzadatak.pojo.Article;

import java.util.ArrayList;
import java.util.List;

public class fakeModel {
    private List listOfArticles = new ArrayList();

    private static fakeModel model;

    private fakeModel() {
    }

    public static fakeModel getInstance() {
        if (model == null) {
            model = new fakeModel();
            return model;

        } else {
            return model;
        }
    }

    public void add(Article article) {
       listOfArticles.add(article);
    }

    public List<Article> getArticles() {
        return listOfArticles;
    }

    public void setListOfArticles(List listOfArticles) {
        this.listOfArticles = listOfArticles;
    }
}
