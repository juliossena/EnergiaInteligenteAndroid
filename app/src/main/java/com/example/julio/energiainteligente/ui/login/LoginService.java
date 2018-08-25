package com.example.julio.energiainteligente.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Switch;

import com.example.julio.energiainteligente.manager.LoginManagerInterface;
import com.example.julio.energiainteligente.modelRequest.LoginRequest;
import com.example.julio.energiainteligente.modelResponse.LoginResponse;
import com.example.julio.energiainteligente.service.ServiceGenerator;
import com.example.julio.energiainteligente.service.exceptions.FalhaInternetException;
import com.example.julio.energiainteligente.service.exceptions.LoginException;
import com.example.julio.energiainteligente.ui.home.HomeActivity;
import com.example.julio.energiainteligente.ui.util.AlertMessage;
import com.example.julio.energiainteligente.ui.util.LoadingOverlay;
import com.example.julio.energiainteligente.util.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginService {

    public static void fazerLogin(final Activity activity, final Switch manterLogado, final LoginRequest loginRequest) {

        final LoginManagerInterface loginManagerInterface = ServiceGenerator.createService(LoginManagerInterface.class);

        LoadingOverlay.getInstance(activity).showLoading();

        loginManagerInterface.login(loginRequest).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response)  {

                LoadingOverlay.getInstance(activity).hideLoading();

                try {
                    if (response.isSuccessful()) {

                        Constants.Session.tokenAcesso = response.body().getToken();

                        if (manterLogado.isChecked()) {

                            SharedPreferences sharedPreferences = activity.getSharedPreferences(Constants.Cache.nomeSalvarAplicativo, 0);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString(Constants.Cache.salvarAplicativoEmail, loginRequest.getEmail());
                            editor.putString(Constants.Cache.salvarAplicativoSenha, loginRequest.getSenha());
                            editor.commit();

                        }

                        activity.startActivity(new Intent(activity.getBaseContext(), HomeActivity.class));
                        activity.finish();

                    } else if (response.code() == 403) {

                        throw new LoginException(Constants.Alert.usuarioSenhaInvalido);

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
            public void onFailure(Call<LoginResponse> call, Throwable t) {

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
