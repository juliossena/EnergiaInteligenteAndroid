package com.example.julio.energiainteligente.manager;

import com.example.julio.energiainteligente.modelRequest.LoginRequest;
import com.example.julio.energiainteligente.modelResponse.CircuitoDispositivoResponse;
import com.example.julio.energiainteligente.modelResponse.LoginResponse;
import com.example.julio.energiainteligente.modelResponse.LogoffResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DispositivosManagerInterface {

    @GET("circuito")
    Call<List<CircuitoDispositivoResponse>> listarDispositivos();


}
