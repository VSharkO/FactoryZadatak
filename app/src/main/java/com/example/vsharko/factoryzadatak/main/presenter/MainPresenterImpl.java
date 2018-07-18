package com.example.vsharko.factoryzadatak.main.presenter;
import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepositoryRoom;
import com.example.vsharko.factoryzadatak.helpers.ResponseListener;
import com.example.vsharko.factoryzadatak.helpers.networking.NetworkingHelper;
import com.example.vsharko.factoryzadatak.main.view.MainActivityView;
import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepository;
import com.example.vsharko.factoryzadatak.model.Article;

import java.util.Calendar;
import java.util.List;

public class MainPresenterImpl implements MainPresenter{

    private MainActivityView view;
    private ArticlesRepository model;
    private NetworkingHelper networkingHelper;

    public MainPresenterImpl(MainActivityView view, NetworkingHelper networkingHelper) {
        this.view = view;
        this.networkingHelper = networkingHelper;
        this.model = new ArticlesRepositoryRoom();
    }

    private void getArticlesFromAPI() {
        view.setRefreshingStart();
        networkingHelper.getNewsFromAPI(new ResponseListener<List<Article>>() {

            @Override
            public void onSuccess(List<Article> callback) {
                model.setListOfArticles(callback);
                view.updateAdapterData(model.getArticles());
                view.setRefreshingEnd();
                //Log.i("Usao","Usao");
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.setRefreshingEnd();
                view.showFailurePopup();
            }
        });
    }

    private void getArticlesFromDB(){
        view.updateAdapterData(model.getArticles());
        view.setRefreshingEnd();
        model.getArticles();
    }

    @Override
    public void getArticles() {
        //5min = 300000milisec
        long MinValueInMilisec = 300000;

        if(model.getArticles().get(1).getDate().getTime()+MinValueInMilisec < Calendar.getInstance().getTimeInMillis())
            getArticlesFromAPI();
        else{
            getArticlesFromDB();
        }
    }

}
