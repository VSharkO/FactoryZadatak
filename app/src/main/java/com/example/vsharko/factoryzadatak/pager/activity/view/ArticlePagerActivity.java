package com.example.vsharko.factoryzadatak.pager.activity.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.vsharko.factoryzadatak.R;
import com.example.vsharko.factoryzadatak.adapters.ViewPagerFragmentAdapter;
import com.example.vsharko.factoryzadatak.pager.activity.presenter.ArticlePagerPresenter;
import com.example.vsharko.factoryzadatak.pager.activity.presenter.ArticlePagerPresenterImpl;
import com.example.vsharko.factoryzadatak.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticlePagerActivity extends FragmentActivity implements ArticlePagerActivityView {

    @BindView(R.id.pager)
    ViewPager mPager;

    int index;
    private ArticlePagerPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);
        ButterKnife.bind(this);
        initPresenter();
        index = getIntent().getIntExtra(Constants.INTENT_PUT_EXTRA_CONSTANT,0);
        ViewPagerFragmentAdapter mPagerAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());
        mPagerAdapter.setAdapterData(presenter.getData());
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(index);
    }

    private void initPresenter() {
        presenter = new ArticlePagerPresenterImpl(this);
    }
}
