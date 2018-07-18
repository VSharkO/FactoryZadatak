package com.example.vsharko.factoryzadatak.helpers.networking;

import com.example.vsharko.factoryzadatak.helpers.ResponseListener;
import com.example.vsharko.factoryzadatak.pojo.Article;
import com.example.vsharko.factoryzadatak.pojo.ArticlesList;
import com.example.vsharko.factoryzadatak.utils.Constants;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkingHelperImpl implements NetworkingHelper {

    private NewsAPIService service;

    public NetworkingHelperImpl(NewsAPIService service) {
        this.service = service;
    }

    @Override
    public void getNewsFromAPI(final ResponseListener<List<Article>> listener) {
        service.getNews(Constants.NEWS_API_LINK).enqueue(new Callback<ArticlesList>() {
            @Override
            public void onResponse(Call<ArticlesList> call, Response<ArticlesList> response) {
                if (response != null && response.body()!=null){
                    ArticlesList data = response.body();
                    if(data!=null)
                        listener.onSuccess(data.getArticles());

                }

            }

            @Override
            public void onFailure(Call<ArticlesList> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }
}
