package com.example.julio.energiainteligente.manager;

import com.example.julio.energiainteligente.models.modelResponse.CircuitoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AtualManagerInterface {

    @GET("circuito/medicoes")
    Call<List<CircuitoResponse>> listaDeMedicoes();


}
