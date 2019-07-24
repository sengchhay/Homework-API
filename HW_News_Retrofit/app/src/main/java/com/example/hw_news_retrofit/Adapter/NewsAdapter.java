package com.example.hw_news_retrofit.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hw_news_retrofit.R;
import com.example.hw_news_retrofit.model.Response.Article;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {


    private List<Article> articleList;
    private AppCompatActivity context;

    public NewsAdapter(List<Article> articleList, AppCompatActivity context) {
        this.articleList = articleList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_news, viewGroup,false);

        return new NewsAdapter.ViewHolder(view);
    }

    public void addMoreItems(List<Article>articles){
        int previousPos=this.articleList.size();
        this.articleList.addAll(articles);
        notifyItemRangeInserted(previousPos-1,this.articleList.size());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Article article=articleList.get(position);

        holder.tvTitle.setText(article.getTitle());
        holder.tvDate.setText(article.getDate());
        holder.tvContent.setText(article.getContent());
        holder.tvAuthor.setText(article.getAuthor());

        Glide.with(context).load(article.getImage()).override(450,350).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvTitle,tvContent,tvAuthor,tvDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvDate=itemView.findViewById(R.id.tvDate);
            tvContent=itemView.findViewById(R.id.tvContent);
            tvAuthor=itemView.findViewById(R.id.tvAuthor);

        }
    }
}
