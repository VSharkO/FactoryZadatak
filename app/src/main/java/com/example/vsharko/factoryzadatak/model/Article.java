package com.example.vsharko.factoryzadatak.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "articles_table")
public class Article {

    private String author;
    @PrimaryKey
    @NonNull
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;

    public String getAuthor(){
        return author;
    }
    public void setAuthor(String input){
        this.author = input;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String input){
        this.title = input;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String input){
        this.description = input;
    }
    public String getUrl(){
        return url;
    }
    public void setUrl(String input){
        this.url = input;
    }
    public String getUrlToImage(){
        return urlToImage;
    }
    public void setUrlToImage(String input){
        this.urlToImage = input;
    }
    public String getPublishedAt(){
        return publishedAt;
    }
    public void setPublishedAt(String input){
        this.publishedAt = input;
    }
}