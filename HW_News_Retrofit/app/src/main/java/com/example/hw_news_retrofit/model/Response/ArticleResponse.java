package com.example.hw_news_retrofit.model.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleResponse {

    private String status;

    private Integer totalResults;
    @SerializedName("articles")
    private List<Article> articleList;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        return "ArticleResponse{" +
                "status='" + status + '\'' +
                ", totalResults=" + totalResults +
                ", articleList=" + articleList +
                '}';
    }
}
