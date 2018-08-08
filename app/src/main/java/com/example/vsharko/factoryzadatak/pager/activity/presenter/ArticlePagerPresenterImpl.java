package com.example.vsharko.factoryzadatak.pager.activity.presenter;

import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepository;
import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.pager.activity.view.ArticlePagerActivityView;
import java.util.List;

import javax.inject.Inject;

public class ArticlePagerPresenterImpl implements ArticlePagerPresenter {

    private ArticlePagerActivityView view;
    private final ArticlesRepository repository;

    @Inject
    public ArticlePagerPresenterImpl(ArticlePagerActivityView view, ArticlesRepository repository) {
        setView(view);
        this.repository = repository;
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
