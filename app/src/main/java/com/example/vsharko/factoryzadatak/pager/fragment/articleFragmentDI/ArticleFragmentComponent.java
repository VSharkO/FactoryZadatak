package com.example.vsharko.factoryzadatak.pager.fragment.articleFragmentDI;

import com.example.vsharko.factoryzadatak.AppComponent;
import com.example.vsharko.factoryzadatak.pager.fragment.view.ArticleFragment;
import com.example.vsharko.factoryzadatak.scopes.PerFragment;

import dagger.Component;

@PerFragment
@Component(modules = ArticleFragmentModule.class, dependencies = AppComponent.class)
public interface ArticleFragmentComponent {
    void inject(ArticleFragment articleFragment);
}
