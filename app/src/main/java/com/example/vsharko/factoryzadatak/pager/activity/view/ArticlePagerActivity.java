package com.example.vsharko.factoryzadatak.pager.activity.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.vsharko.factoryzadatak.App;
import com.example.vsharko.factoryzadatak.R;
import com.example.vsharko.factoryzadatak.adapters.ViewPagerFragmentAdapter;
import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.pager.activity.pagerDI.DaggerPagerComponent;
import com.example.vsharko.factoryzadatak.pager.activity.pagerDI.PagerComponent;
import com.example.vsharko.factoryzadatak.pager.activity.pagerDI.PagerModule;
import com.example.vsharko.factoryzadatak.pager.activity.presenter.ArticlePagerPresenter;
import com.example.vsharko.factoryzadatak.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticlePagerActivity extends FragmentActivity implements ArticlePagerActivityView {

    @BindView(R.id.pager)
    ViewPager mPager;
    private int index;

    @Inject
    public ArticlePagerPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);
        ButterKnife.bind(this);
        PagerComponent component = DaggerPagerComponent.builder()
                .appComponent(App.getInstance().getAppComponent())
                .pagerModule(new PagerModule(this))
                .build();

        component.inject(this);

        index = getIntent().getIntExtra(Constants.INTENT_PUT_EXTRA_CONSTANT,0);
        presenter.getData();

    }

    public void setupPager(List<Article> articles){
        ViewPagerFragmentAdapter mPagerAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());
        mPagerAdapter.setAdapterData(articles);
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(index);
    }

}
