package com.example.vsharko.factoryzadatak.main.presenter;

import com.example.vsharko.factoryzadatak.helpers.ResponseListener;
import com.example.vsharko.factoryzadatak.helpers.networking.NetworkingHelper;
import com.example.vsharko.factoryzadatak.main.view.MainActivityView;
import com.example.vsharko.factoryzadatak.model.FakeModel;
import com.example.vsharko.factoryzadatak.pojo.Article;
import java.util.List;

public class MainPresenterImpl implements MainPresenter{

    private MainActivityView view;
    private FakeModel model;
    private NetworkingHelper networkingHelper;


    public MainPresenterImpl(MainActivityView view, NetworkingHelper networkingHelper) {
        this.view = view;
        this.networkingHelper = networkingHelper;
        this.model = FakeModel.getInstance();
    }

    private void getArticlesFromAPI() {
        view.setRefreshingStart();
        networkingHelper.getNewsFromAPI(new ResponseListener<List<Article>>() {

            @Override
            public void onSuccess(List<Article> callback) {
                model.setListOfArticles(callback);
                view.updateAdapterData(model.getArticles());
                view.setRefreshingEnd();
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setRefreshingEnd();
                view.showFailurePopup();
            }
        });
    }

    @Override
    public void getArticles() {
        getArticlesFromAPI();
    }
}
