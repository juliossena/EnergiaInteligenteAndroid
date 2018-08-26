package com.example.julio.energiainteligente.ui.home.atual;

import com.example.julio.energiainteligente.manager.AtualManagerInterface;
import com.example.julio.energiainteligente.models.modelResponse.CircuitoResponse;
import com.example.julio.energiainteligente.models.Dispositivo;
import com.example.julio.energiainteligente.service.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AtualService {

    public static void listarMedicoes() {
        AtualManagerInterface atualManagerInterface = ServiceGenerator.createService(AtualManagerInterface.class);

        atualManagerInterface.listaDeMedicoes().enqueue(new Callback<List<CircuitoResponse>>() {
            @Override
            public void onResponse(Call<List<CircuitoResponse>> call, Response<List<CircuitoResponse>> response) {
                List<Dispositivo> dispositivos = new ArrayList<>();
                for (CircuitoResponse circuitoResponse : response.body()) {
                    dispositivos.add(new Dispositivo(circuitoResponse));
                }
                AtualFragment.addEntry(dispositivos);
            }

            @Override
            public void onFailure(Call<List<CircuitoResponse>> call, Throwable t) {
            }
        });
    }
}
