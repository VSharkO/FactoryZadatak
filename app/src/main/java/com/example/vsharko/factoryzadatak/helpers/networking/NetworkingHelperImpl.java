package com.example.vsharko.factoryzadatak.helpers.networking;

import com.example.vsharko.factoryzadatak.helpers.ResponseListener;
import com.example.vsharko.factoryzadatak.pojo.ArticlesList;
import com.example.vsharko.factoryzadatak.utils.Constants;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkingHelperImpl implements NetworkingHelper {

    private NewsAPIService service;

    public NetworkingHelperImpl(NewsAPIService service) {
        this.service = service;
    }

    @Override
    public void getNewsFromAPI(final ResponseListener<ArticlesList> listener) {
        service.getNews(Constants.NEWS_API_LINK).enqueue(new Callback<ArticlesList>() {
            @Override
            public void onResponse(Call<ArticlesList> call, Response<ArticlesList> response) {
                ArticlesList data = response.body();
                listener.onSuccess(data);
            }

            @Override
            public void onFailure(Call<ArticlesList> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }
}
