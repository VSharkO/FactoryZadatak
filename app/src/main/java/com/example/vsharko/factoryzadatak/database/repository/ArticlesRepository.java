package com.example.vsharko.factoryzadatak.database.repository;

import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.networking.ResponseListener;
import com.example.vsharko.factoryzadatak.utils.DbResponseListener;

import java.util.List;

public interface ArticlesRepository {

    void getArticles(DbResponseListener listener);

    void setListOfArticles(List<Article> listOfArticles);

}
