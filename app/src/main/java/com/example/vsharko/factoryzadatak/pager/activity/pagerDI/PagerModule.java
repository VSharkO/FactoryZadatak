package com.example.vsharko.factoryzadatak.pager.activity.pagerDI;

import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepository;
import com.example.vsharko.factoryzadatak.pager.activity.presenter.ArticlePagerPresenter;
import com.example.vsharko.factoryzadatak.pager.activity.presenter.ArticlePagerPresenterImpl;
import com.example.vsharko.factoryzadatak.pager.activity.view.ArticlePagerActivity;
import com.example.vsharko.factoryzadatak.pager.activity.view.ArticlePagerActivityView;
import com.example.vsharko.factoryzadatak.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class PagerModule {

    ArticlePagerActivityView activity;

    public PagerModule(ArticlePagerActivity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    ArticlePagerPresenter presenter(ArticlePagerActivityView view, ArticlesRepository repository){
        return new ArticlePagerPresenterImpl(view,repository);
    }
    @PerActivity
    @Provides
    ArticlePagerActivityView getView(){
        return activity;
    }
}
