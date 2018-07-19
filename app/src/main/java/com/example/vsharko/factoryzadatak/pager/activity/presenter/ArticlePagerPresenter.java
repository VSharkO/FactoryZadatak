package com.example.vsharko.factoryzadatak.pager.activity.presenter;

import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.pager.activity.view.ArticlePagerActivityView;

import java.util.List;

public interface ArticlePagerPresenter {

    List<Article> getData();
    void setView(ArticlePagerActivityView view);
}
