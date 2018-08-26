package com.example.julio.energiainteligente.manager;

import com.example.julio.energiainteligente.models.modelRequest.CircuitoRequest;
import com.example.julio.energiainteligente.models.modelRequest.ProgramacaoMudancaRequest;
import com.example.julio.energiainteligente.models.modelResponse.CircuitoDispositivoResponse;
import com.example.julio.energiainteligente.models.modelResponse.CircuitoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DispositivosManagerInterface {

    @GET("circuito")
    Call<List<CircuitoDispositivoResponse>> listarDispositivos();

    @PUT("circuito")
    Call<CircuitoResponse> atualizarDispositivo(@Body CircuitoRequest circuitoRequest);

    @POST("programacao/2/{idCircuito}")
    Call<CircuitoResponse> inserirProgramacaoMudanca(@Body ProgramacaoMudancaRequest programacaoMudancaRequest, @Path("idCircuito") Integer idCircuito);

}
