package com.example.julio.energiainteligente.manager;

import com.example.julio.energiainteligente.models.modelRequest.CircuitoRequest;
import com.example.julio.energiainteligente.models.modelResponse.CircuitoDispositivoResponse;
import com.example.julio.energiainteligente.models.modelResponse.CircuitoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface DispositivosManagerInterface {

    @GET("circuito")
    Call<List<CircuitoDispositivoResponse>> listarDispositivos();

    @PUT("circuito")
    Call<CircuitoResponse> atualizarDispositivo(@Body CircuitoRequest circuitoRequest);

}
