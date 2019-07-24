package com.example.hw_news_retrofit.data;

import com.example.hw_news_retrofit.model.Response.ArticleResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArticleService {

    @GET("/v2/everything")
    Call<ArticleResponse> getArticle(@Query("q") String q,
                                     @Query("apiKey") String apiKey);

}
