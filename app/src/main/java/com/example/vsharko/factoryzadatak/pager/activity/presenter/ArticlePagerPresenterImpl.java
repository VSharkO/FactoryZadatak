package com.example.vsharko.factoryzadatak.pager.activity.presenter;

import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepository;
import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.pager.activity.view.ArticlePagerActivityView;
import com.example.vsharko.factoryzadatak.utils.DbResponseListener;

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
    public void getData() {
        repository.getArticles(listener);
    }

    @Override
    public void setView(ArticlePagerActivityView view) {
        this.view = view;
    }

    DbResponseListener listener = new DbResponseListener() {

        @Override
        public void onSuccess(List<Article> callback) {
            view.setupPager(callback);
        }

        @Override
        public void onFailure(Throwable throwable) {

        }
    };

}
