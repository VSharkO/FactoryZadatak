package com.example.vsharko.factoryzadatak.pager.presenter;


import com.example.vsharko.factoryzadatak.pager.view.ArticleFragmentView;

public interface ArticleFragmentPresenter {
    void setView(ArticleFragmentView view);
    void setData(int index);
}
