package com.example.vsharko.factoryzadatak.pager.activity.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.vsharko.factoryzadatak.R;
import com.example.vsharko.factoryzadatak.adapters.ViewPagerFragmentAdapter;
import com.example.vsharko.factoryzadatak.pager.activity.presenter.ArticlePagerPresenter;
import com.example.vsharko.factoryzadatak.pager.activity.presenter.ArticlePagerPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticlePagerActivity extends FragmentActivity implements ArticlePagerActivityView {

    private ViewPagerFragmentAdapter mPagerAdapter;

    @BindView(R.id.pager)
    ViewPager mPager;

    private ArticlePagerPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);
        ButterKnife.bind(this);
        initPresenter();

        mPagerAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());
        mPagerAdapter.setAdapterData(presenter.getData());
        mPager.setAdapter(mPagerAdapter);
    }

    private void initPresenter() {
        presenter = new ArticlePagerPresenterImpl(this);
    }
}
