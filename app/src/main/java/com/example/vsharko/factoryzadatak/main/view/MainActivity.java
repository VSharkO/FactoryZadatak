package com.example.vsharko.factoryzadatak.main.view;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.vsharko.factoryzadatak.adapters.RecyclerViewAdapter;
import com.example.vsharko.factoryzadatak.database.repository.repositoryDI.RepositoryModule;
import com.example.vsharko.factoryzadatak.main.OnArticleClickListener;
import com.example.vsharko.factoryzadatak.main.mainDI.DaggerMainComponent;
import com.example.vsharko.factoryzadatak.main.mainDI.MainActivityModule;
import com.example.vsharko.factoryzadatak.main.mainDI.MainComponent;
import com.example.vsharko.factoryzadatak.main.mainDI.MainModule;
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

    public MainPresenter presenter;
    public AlertDialog alertDialog;
    public RecyclerViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MainComponent component = DaggerMainComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .repositoryModule(new RepositoryModule(this))
                .build();

        presenter = component.injectPresenter();
        alertDialog = component.injectAlertDialog();
        provideRecyclerViewAdapter();
        initSwipeRefresh();
    }

    public void provideRecyclerViewAdapter() {
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
