package com.example.julio.energiainteligente.ui.home.dispositivos;

import android.app.Activity;
import android.content.Context;

import com.example.julio.energiainteligente.manager.DispositivosManagerInterface;
import com.example.julio.energiainteligente.models.Programacao;
import com.example.julio.energiainteligente.models.modelRequest.CircuitoRequest;
import com.example.julio.energiainteligente.models.modelRequest.ProgramacaoExcedenteRequest;
import com.example.julio.energiainteligente.models.modelRequest.ProgramacaoMudancaRequest;
import com.example.julio.energiainteligente.models.modelResponse.CircuitoDispositivoResponse;
import com.example.julio.energiainteligente.models.modelResponse.CircuitoResponse;
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

    public static void atualizarDispositivo(final Context context, Dispositivo dispositivo) {
        CircuitoRequest circuitoRequest = new CircuitoRequest(dispositivo);

        DispositivosManagerInterface dispositivosManagerInterface =
                ServiceGenerator.createService(DispositivosManagerInterface.class);

        LoadingOverlay.getInstance(context).showLoading();

        dispositivosManagerInterface.atualizarDispositivo(circuitoRequest)
                .enqueue(new Callback<CircuitoResponse>() {
                    @Override
                    public void onResponse(Call<CircuitoResponse> call, Response<CircuitoResponse> response) {
                        LoadingOverlay.getInstance(context).hideLoading();

                        try {
                            if (response.code() == 200) {

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
                    public void onFailure(Call<CircuitoResponse> call, Throwable t) {
                        LoadingOverlay.getInstance(context).hideLoading();
                        try {

                            throw new FalhaInternetException(Constants.Alert.falhaInternet);

                        } catch (FalhaInternetException e) {

                            AlertMessage.showMessage(context, e.getMessage(), Constants.Alert.atencao);

                        }
                    }
                });
    }

    public static void inserirProgramacaoMudanca(final Activity activity, ProgramacaoMudancaRequest programacaoMudancaRequest,
                                                 Dispositivo dispositivo) {

        DispositivosManagerInterface dispositivosManagerInterface =
                ServiceGenerator.createService(DispositivosManagerInterface.class);

        LoadingOverlay.getInstance(activity).showLoading();

        dispositivosManagerInterface.inserirProgramacaoMudanca(programacaoMudancaRequest,
                dispositivo.getId()).enqueue(new Callback<CircuitoResponse>() {
            @Override
            public void onResponse(Call<CircuitoResponse> call, Response<CircuitoResponse> response) {
                LoadingOverlay.getInstance(activity).hideLoading();

                try {
                    if (response.code() == 200) {
                        AlertMessage.showMessageFinish(activity, Constants.Alert.programacaoInserida, Constants.Alert.sucesso);

                    }else if (response.code() == 403) {

                        throw new LoginException(Constants.Alert.usuarioDeslogado);

                    } else {

                        throw new FalhaInternetException(Constants.Alert.falhaInternet);

                    }

                } catch (LoginException e) {

                    AlertMessage.showMessage(activity, e.getMessage(), Constants.Alert.atencao);

                } catch (FalhaInternetException e) {

                    AlertMessage.showMessage(activity, e.getMessage(), Constants.Alert.atencao);

                }
            }

            @Override
            public void onFailure(Call<CircuitoResponse> call, Throwable t) {
                LoadingOverlay.getInstance(activity).hideLoading();
                try {

                    throw new FalhaInternetException(Constants.Alert.falhaInternet);

                } catch (FalhaInternetException e) {

                    AlertMessage.showMessage(activity, e.getMessage(), Constants.Alert.atencao);

                }
            }
        });
    }

    public static void deletarProgramacao(final Activity activity, Programacao programacao){
        DispositivosManagerInterface dispositivosManagerInterface =
                ServiceGenerator.createService(DispositivosManagerInterface.class);
        LoadingOverlay.getInstance(activity).showLoading();

        dispositivosManagerInterface.deletarProgramacao(programacao.getId()).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                LoadingOverlay.getInstance(activity).hideLoading();
                if (response.code() == 204) {
                    AlertMessage.showMessageFinish(activity, Constants.Alert.programacaoDeletada, Constants.Alert.sucesso);
                } else {
                    try {

                        throw new FalhaInternetException(Constants.Alert.falhaInternet);

                    } catch (FalhaInternetException e) {

                        AlertMessage.showMessage(activity, e.getMessage(), Constants.Alert.atencao);

                    }
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                LoadingOverlay.getInstance(activity).hideLoading();
                try {

                    throw new FalhaInternetException(Constants.Alert.falhaInternet);

                } catch (FalhaInternetException e) {

                    AlertMessage.showMessage(activity, e.getMessage(), Constants.Alert.atencao);

                }
            }
        });
    }

    public static void inserirProgramacaoExcesso(final Activity activity, ProgramacaoExcedenteRequest programacao, Dispositivo dispositivo) {
        DispositivosManagerInterface dispositivosManagerInterface =
                ServiceGenerator.createService(DispositivosManagerInterface.class);

        LoadingOverlay.getInstance(activity).showLoading();

        dispositivosManagerInterface.inserirProgramacaoExcedente(programacao, dispositivo.getId()).enqueue(new Callback<CircuitoResponse>() {
            @Override
            public void onResponse(Call<CircuitoResponse> call, Response<CircuitoResponse> response) {
                LoadingOverlay.getInstance(activity).hideLoading();

                try {
                    if (response.code() == 200) {
                        AlertMessage.showMessageFinish(activity, Constants.Alert.programacaoInserida, Constants.Alert.sucesso);

                    }else if (response.code() == 403) {

                        throw new LoginException(Constants.Alert.usuarioDeslogado);

                    } else {

                        throw new FalhaInternetException(Constants.Alert.falhaInternet);

                    }

                } catch (LoginException e) {

                    AlertMessage.showMessage(activity, e.getMessage(), Constants.Alert.atencao);

                } catch (FalhaInternetException e) {

                    AlertMessage.showMessage(activity, e.getMessage(), Constants.Alert.atencao);

                }
            }

            @Override
            public void onFailure(Call<CircuitoResponse> call, Throwable t) {
                LoadingOverlay.getInstance(activity).hideLoading();
                try {

                    throw new FalhaInternetException(Constants.Alert.falhaInternet);

                } catch (FalhaInternetException e) {

                    AlertMessage.showMessage(activity, e.getMessage(), Constants.Alert.atencao);

                }
            }
        });
    }
}
