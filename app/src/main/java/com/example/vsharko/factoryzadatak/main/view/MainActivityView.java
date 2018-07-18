package com.example.vsharko.factoryzadatak.main.view;


import com.example.vsharko.factoryzadatak.pojo.Article;

import java.util.List;

public interface MainActivityView {
    void updateAdapterData(List<Article> articles);
    void showFailurePopup();
    void setRefreshingEnd();
    void setRefreshingStart();
}
