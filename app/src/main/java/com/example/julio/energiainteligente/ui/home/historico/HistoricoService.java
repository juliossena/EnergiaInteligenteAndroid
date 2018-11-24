package com.example.julio.energiainteligente.ui.home.historico;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

import com.example.julio.energiainteligente.R;
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
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoricoService {

    public static void listarHistoricos(final Context context, Date dataInicio, Date dataTermino,
                                        final List<Dispositivo> dispositivos, final Typeface mTfLight,
                                        final PieChart mChart) {

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

                        HistoricoFragment.atualizarDados(dispositivos);
                        setData(context, dispositivos, mTfLight, mChart);

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

    static int[] mColors = ColorTemplate.COLORFUL_COLORS;

    public static void setData(Context context, List<Dispositivo> dispositivos, Typeface mTfLight, PieChart mChart) {
        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (Dispositivo dispositivo : dispositivos) {
            entries.add(new PieEntry(dispositivo.getHistorico().getConsumoTotal(),
                    dispositivo.getNome(),
                    context.getResources().getDrawable(R.drawable.icon)));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Legenda");

        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        dataSet.setColors(mColors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        data.setValueTypeface(mTfLight);
        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        mChart.invalidate();
    }
}
