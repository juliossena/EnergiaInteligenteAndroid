package com.example.julio.energiainteligente.ui.home.atual;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.models.Dispositivo;
import com.example.julio.energiainteligente.models.Medicao;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class AtualFragment extends Fragment implements OnChartValueSelectedListener {

    private static LineChart mChart;
    public static int tempoDelay = 30000;

    public AtualFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_atual, container, false);

        mChart = view.findViewById(R.id.chart1);
        mChart.setOnChartValueSelectedListener(this);
        mChart.setDrawGridBackground(false);
        mChart.getDescription().setEnabled(false);

        mChart.setData(new LineData());

        mChart.invalidate();

        AtualService.listarMedicoes();

        return view;
    }

    static int[] mColors = ColorTemplate.COLORFUL_COLORS;

    public static void addCircuito(int count, Dispositivo dispositivo, LineData data) {
        ArrayList<Entry> yVals = new ArrayList<Entry>();

        yVals.add(new Entry(count, dispositivo.getMedicoes().get(0).getPotencia()));

        LineDataSet setMult = new LineDataSet(yVals, dispositivo.getNome());
        setMult.setLineWidth(2.5f);
        setMult.setCircleRadius(4.5f);

        int color = mColors[count % mColors.length];

        setMult.setColor(color);
        setMult.setCircleColor(color);
        setMult.setHighLightColor(color);
        setMult.setValueTextSize(10f);
        setMult.setValueTextColor(color);

        data.addDataSet(setMult);
        data.notifyDataChanged();
    }

    public static void addDadosCircuito(LineData data, int count, Dispositivo dispositivo) {
        data = mChart.getData();

        // choose a random dataSet
        float yValue = (float) dispositivo.getMedicoes().get(0).getPotencia();

        data.addEntry(new Entry(data.getDataSetByIndex(count).getEntryCount(), yValue), count);
        data.notifyDataChanged();

        mChart.notifyDataSetChanged();
        mChart.setVisibleXRangeMaximum(10);
    }

    public static void addEntry(List<Dispositivo> dispositivos) {

        LineData data = mChart.getData();
        int count = 0;
        if (data.getDataSetCount() < dispositivos.size()) {
            Medicao medicao = new Medicao();
            medicao.setPotencia((float) 0.0);
            for (Dispositivo dispositivo : dispositivos) {
                int novoTempo = 1000 * dispositivo.getConfiguracaoDispositivo().getTempoAtualizacao() / 3;

                if (novoTempo < tempoDelay) {
                    tempoDelay = novoTempo;
                }

                medicao.setPotencia(medicao.getPotencia() + dispositivo.getMedicoes().get(0).getPotencia());
                addCircuito(count, dispositivo, data);
                count++;
            }

            Dispositivo todosDispositivos = new Dispositivo();
            todosDispositivos.setNome("Todos");
            List<Medicao> medicoes = new ArrayList<>();
            medicoes.add(medicao);
            todosDispositivos.setMedicoes(medicoes);

            addCircuito(count, todosDispositivos, data);

        } else {
            Medicao medicao = new Medicao();
            medicao.setPotencia((float) 0.0);
            for (Dispositivo dispositivo : dispositivos) {
                medicao.setPotencia(medicao.getPotencia() + dispositivo.getMedicoes().get(0).getPotencia());
                addDadosCircuito(data, count, dispositivo);

                count++;
            }

            Dispositivo todosDispositivos = new Dispositivo();
            todosDispositivos.setNome("Todos");
            List<Medicao> medicoes = new ArrayList<>();
            medicoes.add(medicao);
            todosDispositivos.setMedicoes(medicoes);

            addDadosCircuito(data, count, todosDispositivos);

            mChart.moveViewTo(data.getEntryCount() - 7, 50f, YAxis.AxisDependency.LEFT);
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                AtualService.listarMedicoes();
            }
        }, tempoDelay);
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

}
