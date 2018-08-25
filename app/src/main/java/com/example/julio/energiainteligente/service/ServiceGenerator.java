package com.example.julio.energiainteligente.service;

import com.example.julio.energiainteligente.util.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static final String ENDPOINT = Constants.Build.endPoint;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(final Class<S> serviceClass) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Authorization", Constants.Session.tokenAcesso)
                        .header("Content-Type", "application/json")
                        .build();

                return chain.proceed(request);
            }
        });


        OkHttpClient client = httpClient.build();

        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);


    }


}
