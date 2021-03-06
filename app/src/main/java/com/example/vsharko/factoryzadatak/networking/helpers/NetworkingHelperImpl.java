package com.example.vsharko.factoryzadatak.networking.helpers;

import android.support.annotation.NonNull;

import com.example.vsharko.factoryzadatak.networking.NewsAPIService;
import com.example.vsharko.factoryzadatak.networking.ResponseListener;
import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.model.ArticlesList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkingHelperImpl implements NetworkingHelper {

    private final NewsAPIService service;

    public NetworkingHelperImpl(NewsAPIService service) {
        this.service = service;
    }

    @Override
    public void getNewsFromAPI(final ResponseListener<List<Article>> listener) {
        service.getNews().enqueue(new Callback<ArticlesList>() {
            @Override
            public void onResponse(@NonNull Call<ArticlesList> call,@NonNull Response<ArticlesList> response) {
                if (response.body()!=null){
                    ArticlesList data = response.body();
                    if(data!=null)
                        listener.onSuccess(data.getArticles());
                }

            }

            @Override
            public void onFailure(@NonNull Call<ArticlesList> call,@NonNull Throwable t) {
                listener.onFailure(t);
            }
        });
    }
}
