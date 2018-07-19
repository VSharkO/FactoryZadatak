package com.example.vsharko.factoryzadatak.networking.helpers;

import com.example.vsharko.factoryzadatak.networking.NewsAPIService;
import com.example.vsharko.factoryzadatak.networking.ResponseListener;
import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.model.ArticlesList;
import com.example.vsharko.factoryzadatak.utils.Constants;


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
                if (response.body()!=null){
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
