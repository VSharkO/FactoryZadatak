package com.example.vsharko.factoryzadatak.model;
import com.example.vsharko.factoryzadatak.pojo.Article;

import java.util.ArrayList;
import java.util.List;

public class FakeModel {

    private List<Article> listOfArticles;

    private static FakeModel model;

    private FakeModel() {
    }

    public static FakeModel getInstance() {
        if (model == null) {
            model = new FakeModel();
            return model;

        } else {
            return model;
        }
    }

    public List<Article> getArticles() {
        return listOfArticles;
    }

    public void setListOfArticles(List<Article> listOfArticles) {
        this.listOfArticles = listOfArticles;
    }
}
