package com.example.vsharko.factoryzadatak.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    private List<Article> mArticles;


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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout,
                parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Article article = mArticles.get(position);
        viewHolder.mTitle.setText(article.getTitle());
        Glide.with(App.getInstance().getApplicationContext()).load(article.getUrlToImage())
                .into(viewHolder.mImage);
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }
}
