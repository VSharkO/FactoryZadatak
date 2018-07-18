package com.example.vsharko.factoryzadatak.helpers.networking;

import com.example.vsharko.factoryzadatak.helpers.ResponseListener;
import com.example.vsharko.factoryzadatak.model.Article;

import java.util.List;


public interface NetworkingHelper {
    void getNewsFromAPI(ResponseListener<List<Article>> listener);
}
