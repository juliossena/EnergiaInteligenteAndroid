package com.example.julio.energiainteligente.ui.home.dispositivos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.ui.util.AlertMessage;
import com.example.julio.energiainteligente.util.Constants;

public class NovaProgramacaoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText nome;
    private RadioButton horario;
    private RadioButton proximidade;
    private EditText horarioProgramacao;
    private SeekBar distanciaSeek;
    private TextView distanciaText;
    private CheckBox segunda;
    private CheckBox terca;
    private CheckBox quarta;
    private CheckBox quinta;
    private CheckBox sexta;
    private CheckBox sabado;
    private CheckBox domingo;
    private RadioButton ligarDispositivo;
    private RadioButton desligarDispositivo;
    private Button salvarProgramacao;
    private LinearLayout layoutDistancia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_programacao);

        findId();

        toolbar.setTitle(Constants.Alert.novaProgramacao);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        horario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                horarioProgramacao.setVisibility(View.VISIBLE);
                layoutDistancia.setVisibility(View.INVISIBLE);
            }
        });

        proximidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                horarioProgramacao.setVisibility(View.INVISIBLE);
                layoutDistancia.setVisibility(View.VISIBLE);
            }
        });

        distanciaSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                distanciaText.setText(String.valueOf(progress) + "m");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        salvarProgramacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nome.getText().toString().length() == 0 ||
                        (horarioProgramacao.getText().toString().length() == 0 && !proximidade.isChecked()) ||
                        (!ligarDispositivo.isChecked() && !desligarDispositivo.isChecked())) {
                    AlertMessage.showMessage(NovaProgramacaoActivity.this, Constants.Alert.preencherCampos, Constants.Alert.atencao);
                } else {

                }
            }
        });
    }

    private void findId() {
        toolbar = (Toolbar) findViewById(R.id.activity_nova_programacao_toolbar);
        nome = (EditText) findViewById(R.id.activity_nova_programacao_nome);
        horario = (RadioButton) findViewById(R.id.activity_nova_programacao_horario);
        proximidade = (RadioButton) findViewById(R.id.activity_nova_programacao_proximidade);
        horarioProgramacao = (EditText) findViewById(R.id.activity_nova_programacao_data);
        distanciaSeek = (SeekBar) findViewById(R.id.activity_nova_programacao_distancia_seek);
        distanciaText = (TextView) findViewById(R.id.activity_nova_programacao_distancia_text);
        segunda = (CheckBox) findViewById(R.id.activity_nova_programacao_segunda);
        terca = (CheckBox) findViewById(R.id.activity_nova_programacao_terca);
        quarta = (CheckBox) findViewById(R.id.activity_nova_programacao_quarta);
        quinta = (CheckBox) findViewById(R.id.activity_nova_programacao_quinta);
        sexta = (CheckBox) findViewById(R.id.activity_nova_programacao_sexta);
        sabado = (CheckBox) findViewById(R.id.activity_nova_programacao_sabado);
        domingo = (CheckBox) findViewById(R.id.activity_nova_programacao_domingo);
        ligarDispositivo = (RadioButton) findViewById(R.id.activity_nova_programacao_ligar);
        desligarDispositivo = (RadioButton) findViewById(R.id.activity_nova_programacao_desligar);
        salvarProgramacao = (Button) findViewById(R.id.activity_nova_programacao_salvar);
        layoutDistancia = (LinearLayout) findViewById(R.id.activity_nova_programacao_linear_distancia);
    }
}
