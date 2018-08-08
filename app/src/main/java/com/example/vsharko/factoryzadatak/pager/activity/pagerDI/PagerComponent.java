package com.example.vsharko.factoryzadatak.pager.activity.pagerDI;

import com.example.vsharko.factoryzadatak.AppComponent;
import com.example.vsharko.factoryzadatak.pager.activity.view.ArticlePagerActivity;
import com.example.vsharko.factoryzadatak.scopes.PerActivity;

import javax.inject.Singleton;

import dagger.Component;

@PerActivity
@Component(modules = PagerModule.class, dependencies = AppComponent.class)
public interface PagerComponent {
    void inject(ArticlePagerActivity articlePagerActivity);
}
