package com.example.vsharko.factoryzadatak.main.presenter;

import com.example.vsharko.factoryzadatak.main.view.MainActivityView;
import com.example.vsharko.factoryzadatak.pojo.Article;

import java.util.List;

public interface MainPresenter {
    void setView(MainActivityView view);
    public List<Article> getArticles();

}
