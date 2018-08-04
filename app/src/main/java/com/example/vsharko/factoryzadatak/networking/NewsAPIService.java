package com.example.vsharko.factoryzadatak.networking;

import com.example.vsharko.factoryzadatak.model.ArticlesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface NewsAPIService {

    @GET("/")
    Call<ArticlesList> getNews();
}