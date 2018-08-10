package com.example.vsharko.factoryzadatak.utils;

import com.example.vsharko.factoryzadatak.model.Article;

import java.util.List;

public interface DbResponseListener {
    void onSuccess(List<Article> callback);
    void onFailure(Throwable throwable);
}
