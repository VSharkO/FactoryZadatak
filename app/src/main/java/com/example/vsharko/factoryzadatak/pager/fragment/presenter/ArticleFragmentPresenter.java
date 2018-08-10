package com.example.vsharko.factoryzadatak.pager.fragment.presenter;


import com.example.vsharko.factoryzadatak.pager.fragment.view.ArticleFragmentView;

public interface ArticleFragmentPresenter {
    void setView(ArticleFragmentView view);
    void setData(int index);
}
