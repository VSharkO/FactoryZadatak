package com.example.vsharko.factoryzadatak.helpers.networking;

import com.example.vsharko.factoryzadatak.helpers.ResponseListener;
import com.example.vsharko.factoryzadatak.pojo.ArticlesList;


public interface NetworkingHelper {
    void getNewsFromAPI(ResponseListener<ArticlesList> listener);
}
