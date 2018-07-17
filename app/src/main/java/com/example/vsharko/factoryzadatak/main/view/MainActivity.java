package com.example.vsharko.factoryzadatak.main.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.vsharko.factoryzadatak.App;
import com.example.vsharko.factoryzadatak.main.presenter.MainPresenterImpl;
import com.example.vsharko.factoryzadatak.main.presenter.MainPresenter;
import com.example.vsharko.factoryzadatak.R;
import com.example.vsharko.factoryzadatak.main.ArticlesAdapter;
import com.example.vsharko.factoryzadatak.pojo.Article;
import com.example.vsharko.factoryzadatak.pojo.ArticlesList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @BindView(R.id.recycler) RecyclerView recyclerView;
    private List<Article> articleList = new ArrayList<>();
    private ArticlesAdapter adapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.presenter = new MainPresenterImpl(this, App.getInstance().getNetworkingHelper());
        adapter = new ArticlesAdapter(articleList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        presenter.getArticles();
    }

    @Override
    public void setAdapterData(ArticlesList articles){
        articleList = articles.getArticles();
        adapter.notifyDataSetChanged();
    }
}
