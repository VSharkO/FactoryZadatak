package com.example.vsharko.factoryzadatak.main.view;

import com.example.vsharko.factoryzadatak.pojo.Article;

import java.util.List;

public interface MainActivityView {
    void initPresenter(MainActivityView view);
    void setAdapter(List<Article> articles);
}
