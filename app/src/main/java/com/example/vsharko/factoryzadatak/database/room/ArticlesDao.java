package com.example.vsharko.factoryzadatak.database.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.vsharko.factoryzadatak.model.Article;

import java.util.List;

@Dao
public interface ArticlesDao {

    @Insert
    void insert(Article article);

    @Query("SELECT * FROM articles_table ORDER BY publishedAt DESC")
    List<Article>getArticles();

    @Query("DELETE FROM articles_table")
    void deleteAllArticles();

}
