package com.example.hw_news_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.hw_news_retrofit.Adapter.NewsAdapter;
import com.example.hw_news_retrofit.data.ArticleService;
import com.example.hw_news_retrofit.data.ServiceGenerator;
import com.example.hw_news_retrofit.model.Response.Article;
import com.example.hw_news_retrofit.model.Response.ArticleResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcNews;
     NewsAdapter adapter;
     ArticleService articleService;
     List<Article> articleList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        articleService= ServiceGenerator.createService(ArticleService.class);
        initView();
        getArticle();
    }

    private static final String TAG = "MainActivity";
    private void getArticle() {
        Call<ArticleResponse> call = articleService.getArticle("bitcoin","a2e55b6e6c0e40668a5c5042aab4ce82");
        call.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                Log.e(TAG, "onResponse: "+ response.body().getArticleList());
                adapter.addMoreItems(response.body().getArticleList());

            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {

            }
        });
    }

    private void initView() {
        rcNews=findViewById(R.id.rcNews);
        rcNews.setLayoutManager(new LinearLayoutManager(this));
        adapter=new NewsAdapter(articleList,this);
        rcNews.setAdapter(adapter);
    }
}
