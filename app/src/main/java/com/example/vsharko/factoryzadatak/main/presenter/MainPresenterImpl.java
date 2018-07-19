package com.example.vsharko.factoryzadatak.main.presenter;
import android.os.AsyncTask;
import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepositoryRoom;
import com.example.vsharko.factoryzadatak.networking.ResponseListener;
import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelper;
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
                new GetArticlesAsyncFromDB().execute();
                //Log.i("Op","Tu je");
            }

            @Override
            public void onFailure(Throwable throwable) {
                new GetArticlesAsyncFromDB().execute();
                view.showFailurePopup();
            }
        });
    }

    private void getArticlesFromDB(List<Article> articles){
        view.updateAdapterData(articles);
        view.setRefreshingEnd();
    }

    @Override
    public void getArticles() {
        //5min = 300000milisec
        long milliSeconds = 300000;

        //first time that app is running
        if(model.getArticles().size()==0){
            getArticlesFromAPI();
        }

        else if(model.getArticles().get(1).getDate().getTime()
                +milliSeconds < Calendar.getInstance().getTimeInMillis()){
            getArticlesFromAPI();
        }

        else{
            new GetArticlesAsyncFromDB().execute();
        }
    }

    private class GetArticlesAsyncFromDB extends AsyncTask<Void, Void, List<Article>> {

        @Override
        protected List<Article> doInBackground(Void... voids) {
            return model.getArticles();
        }

        protected void onPostExecute(List<Article> articles) {
           getArticlesFromDB(articles);
        }
    }
}
