package com.example.vsharko.factoryzadatak.helpers.networking;

import com.example.vsharko.factoryzadatak.model.ArticlesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NewsAPIService {
    @GET()
    Call<ArticlesList> getNews(@Url String url);
}
