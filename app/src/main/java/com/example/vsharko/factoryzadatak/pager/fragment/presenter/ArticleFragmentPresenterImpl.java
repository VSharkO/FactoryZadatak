package com.example.vsharko.factoryzadatak.pager.fragment.presenter;

import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepository;
import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.pager.fragment.view.ArticleFragment;
import com.example.vsharko.factoryzadatak.pager.fragment.view.ArticleFragmentView;
import com.example.vsharko.factoryzadatak.utils.DbResponseListener;

import java.util.List;

public class ArticleFragmentPresenterImpl implements ArticleFragmentPresenter {

    private ArticleFragmentView view;
    private final ArticlesRepository mRepository;
    private int mIndex;

    public ArticleFragmentPresenterImpl(ArticleFragment view, ArticlesRepository repository) {
        setView(view);
        mRepository = repository;
    }

    @Override
    public void setView(ArticleFragmentView view) {
        this.view = view;
    }

    @Override
    public void setData(int index) {
        mIndex = index;
        mRepository.getArticles(listener);
    }

    public void setView(Article article){
        view.setImage(article.getUrlToImage());
        view.setDescription(article.getDescription());
        view.setTitle(article.getTitle());
        view.setLink(article.getUrl());
    }

    DbResponseListener listener = new DbResponseListener() {
        @Override
        public void onSuccess(List<Article> callback) {
            setView(callback.get(mIndex));
        }

        @Override
        public void onFailure(Throwable throwable) {
        }
    };

}
