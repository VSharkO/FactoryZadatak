package com.example.vsharko.factoryzadatak.main.presenter;
import com.example.vsharko.factoryzadatak.App;
import com.example.vsharko.factoryzadatak.helpers.ResponseListener;
import com.example.vsharko.factoryzadatak.helpers.networking.NetworkingHelper;
import com.example.vsharko.factoryzadatak.main.view.MainActivityView;
import com.example.vsharko.factoryzadatak.model.fakeModel;
import com.example.vsharko.factoryzadatak.pojo.Article;
import com.example.vsharko.factoryzadatak.pojo.ArticlesList;

import java.util.List;

public class MainPresenterImpl implements MainPresenter {

    private MainActivityView view;
    private fakeModel model;
    NetworkingHelper networkingHelper;

    public MainPresenterImpl(MainActivityView view) {
       setView(view);
       model = fakeModel.getInstance();
       networkingHelper = App.getInstance().getNetworkingHelper();
    }

    @Override
    public void setView(MainActivityView view) {
        this.view = view;
    }

    @Override
    public List<Article> getArticles() {
        return model.getArticles();
    }

    @Override
    public void updateModelWithArticles() {
        model.setListOfArticles(getArticlesFromAPI().getArticles());
    }

    public ArticlesList getArticlesFromAPI(){
        final ArticlesList[] articles = {new ArticlesList()};

        networkingHelper.getNewsFromAPI(new ResponseListener<ArticlesList>() {

            @Override
            public void onSuccess(ArticlesList callback) {
                articles[0] = (ArticlesList) callback.getArticles();
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });

        return articles[0];
    }
}
