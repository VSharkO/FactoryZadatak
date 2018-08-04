package com.example.vsharko.factoryzadatak.networking.helpers;

import android.support.annotation.NonNull;

import com.example.vsharko.factoryzadatak.networking.NewsAPIService;
import com.example.vsharko.factoryzadatak.networking.ResponseListener;
import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.model.ArticlesList;
import com.example.vsharko.factoryzadatak.utils.Constants;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class NetworkingHelperImpl implements NetworkingHelper {

    private final NewsAPIService service;

    public NetworkingHelperImpl(NewsAPIService service) {
        this.service = service;
    }

    @Override
    public void getNewsFromAPI(final ResponseListener<List<Article>> listener) {
        service.getNews(Constants.VERSION,Constants.SOURCE,Constants.SORT_BY,Constants.API_KEY).enqueue(new Callback<ArticlesList>() {
            @Override
            public void onResponse(@NonNull Call<ArticlesList> call,@NonNull Response<ArticlesList> response) {
                if (response.body()!=null){
                    ArticlesList data = response.body();
                    if(data!=null)
                        listener.onSuccess(data.getArticles());
                    Timber.i("ušo");
                }

            }

            @Override
            public void onFailure(@NonNull Call<ArticlesList> call,@NonNull Throwable t) {
                listener.onFailure(t);
            }
        });
    }
}
