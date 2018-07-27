package com.example.vsharko.factoryzadatak.pager.presenter;

import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepository;
import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepositoryRoom;
import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.pager.view.ArticleFragment;
import com.example.vsharko.factoryzadatak.pager.view.ArticleFragmentView;

public class ArticleFragmentPresenterImpl implements ArticleFragmentPresenter {

    private ArticleFragmentView view;
    private final ArticlesRepository repository;

    public ArticleFragmentPresenterImpl(ArticleFragment view) {
        setView(view);
        repository = new ArticlesRepositoryRoom();
    }

    @Override
    public void setView(ArticleFragmentView view) {
        this.view = view;
    }

    @Override
    public void setData(int index) {
        Article article = repository.getArticles().get(index);
        view.setImage(article.getUrlToImage());
        view.setDescription(article.getDescription());
        view.setTitle(article.getTitle());
        view.setLink(article.getUrl());
    }

}
