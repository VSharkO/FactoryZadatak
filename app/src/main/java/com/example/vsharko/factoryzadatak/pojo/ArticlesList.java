package com.example.vsharko.factoryzadatak.pojo;


import java.util.List;

public class ArticlesList {

    private String status;
    private String source;
    private String sortBy;
    private List<Article> articles;

    public String getStatus(){
        return status;
    }
    public void setStatus(String input){
        this.status = input;
    }
    public String getSource(){
        return source;
    }
    public void setSource(String input){
        this.source = input;
    }
    public String getSortBy(){
        return sortBy;
    }
    public void setSortBy(String input){
        this.sortBy = input;
    }
    public List<Article> getArticles(){
        return articles;
    }
    public void setArticles(List<Article> input){
        this.articles = input;
    }
}
