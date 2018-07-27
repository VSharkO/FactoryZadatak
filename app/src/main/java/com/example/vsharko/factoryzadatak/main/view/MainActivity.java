package com.example.vsharko.factoryzadatak.main.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.vsharko.factoryzadatak.App;
import com.example.vsharko.factoryzadatak.adapters.RecyclerViewAdapter;
import com.example.vsharko.factoryzadatak.main.OnArticleClickListener;
import com.example.vsharko.factoryzadatak.main.presenter.MainPresenterImpl;
import com.example.vsharko.factoryzadatak.main.presenter.MainPresenter;
import com.example.vsharko.factoryzadatak.R;
import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.pager.activity.view.ArticlePagerActivity;
import com.example.vsharko.factoryzadatak.utils.Constants;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityView, OnArticleClickListener {

    @BindView(R.id.recycler)RecyclerView recyclerView;
    @BindView(R.id.swipeRefresh)SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerViewAdapter adapter;
    private MainPresenter presenter;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initPresenter();
        initAlertDialog();
        initRecyclerView();
        initSwipeRefresh();
    }

    private void initRecyclerView() {
        adapter = new RecyclerViewAdapter(this);
        presenter.getArticles();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initPresenter() {
        this.presenter = new MainPresenterImpl(this, App.getInstance().getNetworkingHelper());
    }

    private void initAlertDialog(){
        alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(Constants.NO_CONNECTION_MASSAGE);
        alertDialogBuilder.setPositiveButton(Constants.YES,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });
    }

    private void initSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        presenter.getArticles();
                    }
                }
        );
    }

    @Override
    public void updateAdapterData(List<Article> articles) {
        adapter.fillData(articles);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showFailurePopup() {
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void setRefreshingEnd(){
       swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setRefreshingStart(){
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(this, ArticlePagerActivity.class);
        intent.putExtra(Constants.INTENT_PUT_EXTRA_CONSTANT,position);
        startActivity(intent);
    }
}
