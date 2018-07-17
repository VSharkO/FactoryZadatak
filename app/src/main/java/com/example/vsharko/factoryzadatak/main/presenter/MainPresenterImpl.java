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

public class MainPresenterImpl implements MainPresenter{

    private MainActivityView view;
    private FakeModel model;
    private NetworkingHelper networkingHelper;

    public MainPresenterImpl(MainActivityView view) {
       setView(view);
       this.model = FakeModel.getInstance();
    }

    public MainPresenterImpl(MainActivityView view, NetworkingHelper networkingHelper) {
        this.view = view;
        this.networkingHelper = networkingHelper;
    }

    @Override
    public void setView(MainActivityView view) {
        this.view = view;
    }

    @Override
    public void getArticles() {
        getArticlesFromAPI();
    }


    private void getArticlesFromAPI() {
        networkingHelper.getNewsFromAPI(new ResponseListener<ArticlesList>() {
            @Override
            public void onSuccess(ArticlesList callback) {
                view.setAdapterData(callback);
                Log.i("ma nemoguce",callback.getArticles().get(1).getAuthor());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

}
