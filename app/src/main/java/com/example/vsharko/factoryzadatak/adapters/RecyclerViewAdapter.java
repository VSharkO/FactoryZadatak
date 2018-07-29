package com.example.vsharko.factoryzadatak.adapters;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.vsharko.factoryzadatak.R;
import com.example.vsharko.factoryzadatak.main.OnArticleClickListener;
import com.example.vsharko.factoryzadatak.model.Article;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ArticlesViewHolder>{
    private final List<Article> articleList = new ArrayList<>();
    private final OnArticleClickListener listener;

    public RecyclerViewAdapter(OnArticleClickListener listener) {
        this.listener = listener;
    }

    public void fillData(List<Article> articles){
        articleList.clear();
        articleList.addAll(articles);
    }

    @NonNull
    @Override
    public ArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_layout,parent,false);
        return new ArticlesViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesViewHolder holder, int position) {
        Article article = articleList.get(position);
        Glide.with(holder.image.getContext())
                .load(article.getUrlToImage())
                .into(holder.image);
        holder.title.setText(article.getTitle());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class ArticlesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.titleview_article) TextView title;
        @BindView(R.id.imageview_article) ImageView image;

        ArticlesViewHolder(View itemView, OnArticleClickListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick
        public void onTaskClick(){
            listener.onClick(getAdapterPosition());
        }
    }
}
