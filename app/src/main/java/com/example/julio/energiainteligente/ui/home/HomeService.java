package com.example.julio.energiainteligente.ui.home;

import android.app.Activity;

import com.example.julio.energiainteligente.manager.LoginManagerInterface;
import com.example.julio.energiainteligente.modelResponse.LogoffResponse;
import com.example.julio.energiainteligente.service.ServiceGenerator;
import com.example.julio.energiainteligente.ui.util.LoadingOverlay;
import com.example.julio.energiainteligente.util.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeService {

    public static void fazerLogoff(final Activity activity) {

        final LoginManagerInterface loginManagerInterface = ServiceGenerator.createService(LoginManagerInterface.class);

        LoadingOverlay.getInstance(activity).showLoading();

        loginManagerInterface.logoff(Constants.Session.tokenFirebase).enqueue(new Callback<LogoffResponse>() {
            @Override
            public void onResponse(Call<LogoffResponse> call, Response<LogoffResponse> response) {
                LoadingOverlay.getInstance(activity).hideLoading();
            }

            @Override
            public void onFailure(Call<LogoffResponse> call, Throwable t) {
                LoadingOverlay.getInstance(activity).hideLoading();
            }
        });
    }

}
