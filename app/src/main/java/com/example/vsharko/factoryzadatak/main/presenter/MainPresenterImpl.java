package com.example.vsharko.factoryzadatak.main.presenter;
import com.example.vsharko.factoryzadatak.networking.ResponseListener;
import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelper;
import com.example.vsharko.factoryzadatak.main.view.MainActivityView;
import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepository;
import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.utils.DbResponseListener;

import java.util.Calendar;
import java.util.List;

public class MainPresenterImpl implements MainPresenter{

    private final MainActivityView view;
    private final ArticlesRepository model;
    private final NetworkingHelper networkingHelper;

    public MainPresenterImpl(MainActivityView view, NetworkingHelper networkingHelper,
                             ArticlesRepository articlesRepository) {

        this.view = view;
        this.networkingHelper = networkingHelper;
        this.model = articlesRepository;
    }

    private void getArticlesFromAPI() {
        view.setRefreshingStart();
        networkingHelper.getNewsFromAPI(new ResponseListener<List<Article>>() {

            @Override
            public void onSuccess(List<Article> callback) {
                model.setListOfArticles(callback);
                model.getArticles(listener);
            }

            @Override
            public void onFailure(Throwable throwable) {
                model.getArticles(listener);
                view.showFailurePopup();
            }
        });
    }

    @Override
    public void getArticles() {
        model.getArticles(listener);
    }

    public void updateAdapterData(List<Article> mArticles){
        //5min = 300000milisec
        long milliSeconds = 300000;

        //first time that app is running
        if(mArticles == null || mArticles.size()==0){
            getArticlesFromAPI();
        }

        else if(mArticles.get(1).getDate().getTime()
                +milliSeconds < Calendar.getInstance().getTimeInMillis()){
            getArticlesFromAPI();
        }

        else{
            view.updateAdapterData(mArticles);
            view.setRefreshingEnd();
        }


    }

    private DbResponseListener listener = new DbResponseListener() {
        @Override
        public void onSuccess(List<Article> callback) {
            updateAdapterData(callback);
        }

        @Override
        public void onFailure(Throwable throwable) {
            view.showFailurePopup();
        }
    };

}
