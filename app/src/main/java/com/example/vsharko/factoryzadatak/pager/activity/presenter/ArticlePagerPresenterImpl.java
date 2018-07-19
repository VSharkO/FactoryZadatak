package com.example.vsharko.factoryzadatak.pager.activity.presenter;

import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepository;
import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepositoryRoom;
import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.pager.activity.view.ArticlePagerActivityView;

import java.util.List;

public class ArticlePagerPresenterImpl implements ArticlePagerPresenter {

    private ArticlePagerActivityView view;
    private ArticlesRepository repository;

    public ArticlePagerPresenterImpl(ArticlePagerActivityView view) {
        setView(view);
        repository = new ArticlesRepositoryRoom();
    }

    @Override
    public List<Article> getData() {
        return repository.getArticles();
    }

    @Override
    public void setView(ArticlePagerActivityView view) {
        this.view = view;
    }

}
