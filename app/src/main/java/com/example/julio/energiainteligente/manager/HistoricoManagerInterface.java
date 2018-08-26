package com.example.julio.energiainteligente.manager;

import com.example.julio.energiainteligente.models.modelResponse.CircuitoResponse;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HistoricoManagerInterface {

    @GET("historico/inicio={dataInicial}&final={dataFinal}")
    Call<List<CircuitoResponse>> listarHistorico(@Path("dataInicial") Long dataInicial, @Path("dataFinal") Long dataFinal);


}
