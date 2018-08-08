package com.example.vsharko.factoryzadatak.database.repository;

import com.example.vsharko.factoryzadatak.model.Article;
import java.util.List;

public interface ArticlesRepository {

    List<Article> getArticles();
    void setListOfArticles(List<Article> listOfArticles);

}
