package com.example.vsharko.factoryzadatak.main.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.vsharko.factoryzadatak.main.presenter.MainPresenterImpl;
import com.example.vsharko.factoryzadatak.main.presenter.MainPresenter;
import com.example.vsharko.factoryzadatak.R;
import com.example.vsharko.factoryzadatak.main.ArticlesAdapter;
import com.example.vsharko.factoryzadatak.pojo.Article;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @BindView(R.id.recycler) RecyclerView recyclerView;

    private ArticlesAdapter adapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPresenter(this);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void initPresenter(MainActivityView view) {
        this.presenter = new MainPresenterImpl(this);
    }

    @Override
    public void setAdapter(List<Article> articles){
        adapter = new ArticlesAdapter(articles);
    }
}
