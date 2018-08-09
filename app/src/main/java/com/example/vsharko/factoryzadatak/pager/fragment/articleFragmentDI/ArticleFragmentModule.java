package com.example.vsharko.factoryzadatak.pager.fragment.articleFragmentDI;

import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepository;
import com.example.vsharko.factoryzadatak.pager.fragment.presenter.ArticleFragmentPresenter;
import com.example.vsharko.factoryzadatak.pager.fragment.presenter.ArticleFragmentPresenterImpl;
import com.example.vsharko.factoryzadatak.pager.fragment.view.ArticleFragment;
import com.example.vsharko.factoryzadatak.scopes.PerFragment;

import dagger.Module;
import dagger.Provides;


@Module
public class ArticleFragmentModule{
    ArticleFragment mView;

    public ArticleFragmentModule(ArticleFragment view) {
        mView = view;
    }

    @PerFragment
    @Provides
    ArticleFragmentPresenter providePresenter(ArticlesRepository repository){
        return new ArticleFragmentPresenterImpl(mView,repository);
    }
}
