package com.example.julio.energiainteligente.manager;

import com.example.julio.energiainteligente.modelRequest.LoginRequest;
import com.example.julio.energiainteligente.modelResponse.LoginResponse;
import com.example.julio.energiainteligente.modelResponse.LogoffResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginManagerInterface {

    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @GET("auth/logoff/{idDispositivo}")
    Call<LogoffResponse> logoff(@Path("idDispositivo") String idDispositivo);


}
