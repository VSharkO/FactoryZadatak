package com.example.vsharko.factoryzadatak.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vsharko.factoryzadatak.App;
import com.example.vsharko.factoryzadatak.R;
import com.example.vsharko.factoryzadatak.model.FakeModel;
import com.example.vsharko.factoryzadatak.pojo.Article;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {

    FakeModel model;
    List<Article> mArticles;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.titleview_article) TextView mTitle;
        @BindView(R.id.imageview_article) ImageView mImage;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

    public ArticlesAdapter(List<Article> articles) {
        this.mArticles = articles;
    }

    @NonNull
    @Override
    public ArticlesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout,
                parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Article article = mArticles.get(position);
        Glide.with(App.getInstance().getApplicationContext()).load(article.getUrlToImage())
                .into(viewHolder.mImage);
        viewHolder.mTitle.setText(article.getTitle());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
