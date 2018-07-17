package com.example.vsharko.factoryzadatak.main.presenter;

import android.util.Log;

import com.example.vsharko.factoryzadatak.App;
import com.example.vsharko.factoryzadatak.helpers.ResponseListener;
import com.example.vsharko.factoryzadatak.helpers.networking.NetworkingHelper;
import com.example.vsharko.factoryzadatak.main.view.MainActivityView;
import com.example.vsharko.factoryzadatak.model.FakeModel;
import com.example.vsharko.factoryzadatak.pojo.Article;
import com.example.vsharko.factoryzadatak.pojo.ArticlesList;
import java.util.List;

public class MainPresenterImpl implements MainPresenter,ResponseListener{

    private MainActivityView view;
    private FakeModel model;
    NetworkingHelper networkingHelper;

    public MainPresenterImpl(MainActivityView view) {
       setView(view);
       this.model = FakeModel.getInstance();
       this.networkingHelper = App.getInstance().getNetworkingHelper();
    }

    @Override
    public void setView(MainActivityView view) {
        this.view = view;
    }

    @Override
    public List<Article> getArticles() {
        getArticlesFromAPI();
        return model.getArticles();
    }


    private void updateModelWithArticles(ArticlesList list) {
        model.setListOfArticles(list.getArticles());
    }

    private void getArticlesFromAPI() {
        networkingHelper.getNewsFromAPI(this);
    }

    @Override
    public void onSuccess(Object callback) {
        updateModelWithArticles((ArticlesList) callback);
        view.setAdapter(model.getArticles());
        Log.i("daaa",model.getArticles().get(1).getDescription());
    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}
