package com.example.hw_news_retrofit.data;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {


    private static final String BASE_URL = "https://newsapi.org";
    private static final String API_KEY = "";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
    private static OkHttpClient.Builder okhttp = new OkHttpClient.Builder();

    public static <S> S createService(Class<S> serviceClass) {
        okhttp.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder requestBuilder = request.newBuilder()
                        .addHeader("Authorization", API_KEY)
                        .header("Accept", "application/json")
                        .method(request.method(), request.body());
                return chain.proceed(requestBuilder.build());
            }
        });
        return builder
                //.client(okHttp.build())
                .build().create(serviceClass);
    }
}
