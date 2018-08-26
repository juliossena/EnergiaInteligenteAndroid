package com.example.julio.energiainteligente.ui.home.historico;

import android.content.Context;

import com.example.julio.energiainteligente.manager.HistoricoManagerInterface;
import com.example.julio.energiainteligente.models.Dispositivo;
import com.example.julio.energiainteligente.models.modelResponse.CircuitoDispositivoResponse;
import com.example.julio.energiainteligente.models.modelResponse.CircuitoResponse;
import com.example.julio.energiainteligente.service.ServiceGenerator;
import com.example.julio.energiainteligente.service.exceptions.FalhaInternetException;
import com.example.julio.energiainteligente.service.exceptions.LoginException;
import com.example.julio.energiainteligente.ui.util.AlertMessage;
import com.example.julio.energiainteligente.ui.util.LoadingOverlay;
import com.example.julio.energiainteligente.util.Constants;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoricoService {

    public static void listarHistoricos(final Context context, Date dataInicio, Date dataTermino, final List<Dispositivo> dispositivos) {

        HistoricoManagerInterface historicoManagerInterface
                = ServiceGenerator.createService(HistoricoManagerInterface.class);

        LoadingOverlay.getInstance(context).showLoading();

        historicoManagerInterface.listarHistorico(dataInicio.getTime(), dataTermino.getTime()).enqueue(new Callback<List<CircuitoResponse>>() {
            @Override
            public void onResponse(Call<List<CircuitoResponse>> call, Response<List<CircuitoResponse>> response) {
                LoadingOverlay.getInstance(context).hideLoading();

                try {
                    if (response.code() == 200) {

                        for (CircuitoResponse circuitoResponse : response.body() ) {
                            dispositivos.add(new Dispositivo(circuitoResponse));
                        }

                    }else if (response.code() == 403) {

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
            public void onFailure(Call<List<CircuitoResponse>> call, Throwable t) {
                LoadingOverlay.getInstance(context).hideLoading();
                try {

                    throw new FalhaInternetException(Constants.Alert.falhaInternet);

                } catch (FalhaInternetException e) {

                    AlertMessage.showMessage(context, e.getMessage(), Constants.Alert.atencao);

                }
            }
        });
    }
}
