package com.example.julio.energiainteligente.ui.home.dispositivos;

import android.content.Context;

import com.example.julio.energiainteligente.manager.DispositivosManagerInterface;
import com.example.julio.energiainteligente.modelResponse.CircuitoDispositivoResponse;
import com.example.julio.energiainteligente.models.Dispositivo;
import com.example.julio.energiainteligente.service.ServiceGenerator;
import com.example.julio.energiainteligente.service.exceptions.FalhaInternetException;
import com.example.julio.energiainteligente.service.exceptions.LoginException;
import com.example.julio.energiainteligente.ui.util.AlertMessage;
import com.example.julio.energiainteligente.ui.util.LoadingOverlay;
import com.example.julio.energiainteligente.util.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DispositivoService {

    public static void listarDispositivos(final Context context, final ArrayList<Dispositivo>
            listaDispositivos, final DispositivoAdapter adapter) {

        DispositivosManagerInterface dispositivosManagerInterface = ServiceGenerator
                .createService(DispositivosManagerInterface.class);

        LoadingOverlay.getInstance(context).showLoading();

        dispositivosManagerInterface.listarDispositivos()
                .enqueue(new Callback<List<CircuitoDispositivoResponse>>() {
            @Override
            public void onResponse(Call<List<CircuitoDispositivoResponse>> call,
                                   Response<List<CircuitoDispositivoResponse>> response) {
                LoadingOverlay.getInstance(context).hideLoading();

                try {
                    if (response.isSuccessful()) {

                        listaDispositivos.clear();
                        for (CircuitoDispositivoResponse circuitoDispositivoResponse : response.body()) {
                            Dispositivo dispositivo = new Dispositivo(circuitoDispositivoResponse);
                            listaDispositivos.add(dispositivo);
                        }

                        adapter.notifyDataSetChanged();

                    } else if (response.code() == 403) {

                        throw new LoginException(Constants.Alert.usuarioDeslogado);

                    } else {

                        throw new FalhaInternetException(Constants.Alert.falhaInternet);

                    }

                } catch (LoginException e) {

                    AlertMessage.showMessage(context, e.getMessage(), Constants.Alert.atencao);

                } catch (FalhaInternetException e) {

                    AlertMessage.showMessage(context, e.getMessage(), Constants.Alert.atencao);

                }
            }

            @Override
            public void onFailure(Call<List<CircuitoDispositivoResponse>> call, Throwable t) {
                LoadingOverlay.getInstance(context).hideLoading();
            }
        });
    }
}
