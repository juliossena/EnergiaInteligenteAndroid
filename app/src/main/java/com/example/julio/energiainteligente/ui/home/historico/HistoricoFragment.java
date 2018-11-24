package com.example.julio.energiainteligente.ui.home.historico;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.models.Dispositivo;
import com.example.julio.energiainteligente.models.Historico;
import com.example.julio.energiainteligente.ui.home.dispositivos.DispositivoService;
import com.example.julio.energiainteligente.util.Utils;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.internal.Util;

public class HistoricoFragment extends Fragment  implements SeekBar.OnSeekBarChangeListener,
        OnChartValueSelectedListener {

    private PieChart mChart;
    private EditText inicio;
    private EditText termino;
    private LayoutInflater inflater;
    private List<Dispositivo> dispositivos = new ArrayList<>();
    private Button atualizar;

    protected Typeface mTfRegular;
    protected Typeface mTfLight;

    private static TextView consumoTotal;
    private static TextView mediaConsumo;
    private static TextView horarioPico;
    private static TextView consumoPico;
    private static TextView consumoReais;

    protected float getRandom(float range, float startsfrom) {
        return (float) (Math.random() * range) + startsfrom;
    }

    public HistoricoFragment() {
        // Required empty public constructor
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        if (menuVisible) {
            Date dataInicio = new Date(new Date().getTime() - 604800000);
            Date dataTermino = new Date();

            inicio.setText(Utils.dataHoraBrasil().format(dataInicio));
            termino.setText(Utils.dataHoraBrasil().format(dataTermino));

            try {
                dataInicio = Utils.dataHoraBrasil().parse(inicio.getText().toString());
                dataTermino = Utils.dataHoraBrasil().parse(termino.getText().toString());


            } catch (ParseException e) {
                e.printStackTrace();
            }
            dispositivos = new ArrayList<>();
            HistoricoService.listarHistoricos(inflater.getContext(), dataInicio, dataTermino, dispositivos, mTfLight, mChart);
        }
        super.setMenuVisibility(menuVisible);
    }

    public static void atualizarDados(List<Dispositivo> dispositivos) {
        Historico historico = new Historico();
        historico.setHorarioPico(new Date());
        float somaMediaConsumo = (float) 0.0;

        for (Dispositivo dispositivo : dispositivos) {
            if (historico.getConsumoPico() < dispositivo.getHistorico().getConsumoPico()) {
                historico.setConsumoPico(dispositivo.getHistorico().getConsumoPico());
            }
            historico.setConsumoReais(dispositivo.getHistorico().getConsumoReais() + historico.getConsumoReais());
            historico.setConsumoTotal(dispositivo.getHistorico().getConsumoTotal() + historico.getConsumoTotal());
            if (historico.getConsumoPico() == dispositivo.getHistorico().getConsumoPico()) {
                historico.setHorarioPico(dispositivo.getHistorico().getHorarioPico());
            }


            somaMediaConsumo = dispositivo.getHistorico().getMediaConsumo();
        }
        historico.setMediaConsumo(somaMediaConsumo / dispositivos.size());

        consumoTotal.setText(Utils.decimalFormat().format(historico.getConsumoTotal()) + " Watts");
        mediaConsumo.setText(Utils.decimalFormat().format(historico.getMediaConsumo()) + " Watts/h");
        horarioPico.setText(Utils.dataHoraBrasil().format(historico.getHorarioPico()));
        consumoPico.setText(Utils.decimalFormat().format(historico.getConsumoPico()) + " Watts/h");
        consumoReais.setText("R$: " + Utils.decimalFormat().format(historico.getConsumoReais()));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.inflater = inflater;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_historico, container, false);

        findId(view);

        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String dataInicio = inicio.getText().toString();
                final String dateTermino = termino.getText().toString();
                dispositivos = new ArrayList<>();
                try {
                    HistoricoService.listarHistoricos(HistoricoFragment.this.getContext(),
                            Utils.dataHoraBrasil().parse(dataInicio),
                            Utils.dataHoraBrasil().parse(dateTermino),
                            dispositivos, mTfLight, mChart);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        //Mascara Data
        SimpleMaskFormatter smf = new SimpleMaskFormatter("NN/NN/NNNN NN:NN:NN");
        MaskTextWatcher mtw = new MaskTextWatcher(inicio, smf);
        inicio.addTextChangedListener(mtw);
        MaskTextWatcher mtw2 = new MaskTextWatcher(termino, smf);
        termino.addTextChangedListener(mtw2);




        /*mSeekBarX = view.findViewById(R.id.seekBar1);
        mSeekBarY = view.findViewById(R.id.seekBar2);
        mSeekBarX.setProgress(4);
        mSeekBarY.setProgress(10);*/

        mChart = view.findViewById(R.id.chart1);
        mChart.setUsePercentValues(true);
        mChart.getDescription().setEnabled(false);
        mChart.setExtraOffsets(5, 10, 5, 5);

        mChart.setDragDecelerationFrictionCoef(0.95f);

        mChart.setCenterTextTypeface(mTfLight);
        mChart.setCenterText(generateCenterSpannableText());

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);

        mChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);

        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        mChart.setOnChartValueSelectedListener(this);

        //mChart.animateY(1400, Easing.EaseInOutQuad);
        // mChart.spin(2000, 0, 360);

        /*mSeekBarX.setOnSeekBarChangeListener(this);
        mSeekBarY.setOnSeekBarChangeListener(this);*/

        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        mChart.setEntryLabelColor(Color.WHITE);
        mChart.setEntryLabelTypeface(mTfRegular);
        mChart.setEntryLabelTextSize(12f);
        return view;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
    }


    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("CONSUMO\npor dispositivo");
        s.setSpan(new RelativeSizeSpan(1.7f), 0, 7, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 7, s.length(), 0);
        s.setSpan(new RelativeSizeSpan(.8f), 7, s.length(), 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 15, s.length(), 0);
        return s;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

        List<Dispositivo> dispositivos = new ArrayList<>();
        dispositivos.add(this.dispositivos.get((int) h.getX()));
        atualizarDados(dispositivos);

    }

    @Override
    public void onNothingSelected() {
        atualizarDados(dispositivos);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    private void findId(View view) {
        inicio = (EditText) view.findViewById(R.id.fragment_historico_inicio);
        termino = (EditText) view.findViewById(R.id.fragment_historico_termino);
        atualizar = (Button) view.findViewById(R.id.fragment_historico_atualizar);
        consumoTotal = (TextView) view.findViewById(R.id.fragment_historico_consumo_total);
        mediaConsumo = (TextView) view.findViewById(R.id.fragment_historico_media_consumo);
        horarioPico = (TextView) view.findViewById(R.id.fragment_historico_horario_pico);
        consumoPico = (TextView) view.findViewById(R.id.fragment_historico_consumo_pico);
        consumoReais = (TextView) view.findViewById(R.id.fragment_historico_consumo_reais);
    }

}
