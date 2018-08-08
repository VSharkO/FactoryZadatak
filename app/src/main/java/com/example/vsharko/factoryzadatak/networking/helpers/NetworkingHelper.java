package com.example.vsharko.factoryzadatak.networking.helpers;

import com.example.vsharko.factoryzadatak.networking.ResponseListener;
import com.example.vsharko.factoryzadatak.model.Article;
import java.util.List;

public interface NetworkingHelper {
    void getNewsFromAPI(ResponseListener<List<Article>> listener);
}
