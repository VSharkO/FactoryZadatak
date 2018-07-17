package com.example.vsharko.factoryzadatak.main.view;
import com.example.vsharko.factoryzadatak.main.presenter.MainPresenter;
import com.example.vsharko.factoryzadatak.model.fakeModel;
import com.example.vsharko.factoryzadatak.pojo.Article;

import java.util.List;

class MainPresenterImpl implements MainPresenter {

    private MainActivityView view;
    private fakeModel model;

    public MainPresenterImpl(MainActivityView view) {
       setView(view);
       model = fakeModel.getInstance();
    }

    @Override
    public void setView(MainActivityView view) {
        this.view = view;
    }

    @Override
    public List<Article> getArticles() {
        return model.getArticles();
    }
}
