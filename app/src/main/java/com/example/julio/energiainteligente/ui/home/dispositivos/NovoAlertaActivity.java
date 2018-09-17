package com.example.julio.energiainteligente.ui.home.dispositivos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.models.Dispositivo;
import com.example.julio.energiainteligente.models.enuns.TipoExcedente;
import com.example.julio.energiainteligente.models.enuns.TipoProgramacao;
import com.example.julio.energiainteligente.models.enuns.TipoType;
import com.example.julio.energiainteligente.models.modelRequest.ProgramacaoExcedenteRequest;
import com.example.julio.energiainteligente.ui.util.AlertMessage;
import com.example.julio.energiainteligente.util.Constants;

public class NovoAlertaActivity extends AppCompatActivity {

    private Dispositivo dispositivo;
    private Toolbar toolbar;
    private EditText nomeProgramacao;
    private RadioButton mudancaEstado;
    private RadioButton excessoBaixoConsumo;
    private RadioButton excessoConsumo;
    private RadioButton baixoConsumo;
    private EditText qtdWatts;
    private RadioButton ligarDispositivo;
    private RadioButton desligarDispositivo;
    private Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_alerta);

        findById();
        dispositivo = (Dispositivo) getIntent().getExtras().get(Constants.Cache.passarDispositivo);

        toolbar.setTitle(Constants.Alert.novoAlerta);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        mudancaEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ligarDispositivo.setVisibility(View.VISIBLE);
                desligarDispositivo.setVisibility(View.VISIBLE);

                excessoConsumo.setVisibility(View.INVISIBLE);
                baixoConsumo.setVisibility(View.INVISIBLE);
                qtdWatts.setVisibility(View.INVISIBLE);
            }
        });

        excessoBaixoConsumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ligarDispositivo.setVisibility(View.INVISIBLE);
                desligarDispositivo.setVisibility(View.INVISIBLE);

                excessoConsumo.setVisibility(View.VISIBLE);
                baixoConsumo.setVisibility(View.VISIBLE);
                qtdWatts.setVisibility(View.VISIBLE);
            }
        });

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mudancaEstado.isChecked()) {

                } else if(excessoBaixoConsumo.isChecked()) {
                    ProgramacaoExcedenteRequest programa = new ProgramacaoExcedenteRequest();
                    programa.setNome(nomeProgramacao.getText().toString());
                    programa.setPotencia(Float.parseFloat(qtdWatts.getText().toString()));
                    programa.setTipoProgramacao(TipoProgramacao.ALERTA_EXCEDENTE);
                    programa.setType(TipoType.PROGRAMACAO_EXCEDENTE.getDescricao());

                    if (excessoConsumo.isChecked()) {
                        programa.setTipoExcedente(TipoExcedente.MAIOR);
                        DispositivoService.inserirProgramacaoExcesso(NovoAlertaActivity.this, programa,dispositivo);
                    } else if(baixoConsumo.isChecked()) {
                        programa.setTipoExcedente(TipoExcedente.MENOR);
                    } else {
                        AlertMessage.showMessage(NovoAlertaActivity.this, Constants.Alert.preencherCampos, Constants.Alert.atencao);
                    }

                } else {
                    AlertMessage.showMessage(NovoAlertaActivity.this, Constants.Alert.preencherCampos, Constants.Alert.atencao);
                }
            }
        });
    }

    private void findById() {
        toolbar = (Toolbar) findViewById(R.id.activity_novo_alerta_toolbar);
        nomeProgramacao = (EditText) findViewById(R.id.activity_novo_alerta_nova_programacao);
        mudancaEstado = (RadioButton) findViewById(R.id.activity_novo_alerta_radio_mudanca_estado);
        excessoBaixoConsumo = (RadioButton) findViewById(R.id.activity_novo_alerta_radio_excesso);
        excessoConsumo = (RadioButton) findViewById(R.id.activity_novo_alerta_excesso);
        baixoConsumo = (RadioButton) findViewById(R.id.activity_novo_alerta_abaixo);
        qtdWatts = (EditText) findViewById(R.id.activity_novo_alerta_watts);
        ligarDispositivo = (RadioButton) findViewById(R.id.activity_novo_alerta_ligar_dispositivo);
        desligarDispositivo = (RadioButton) findViewById(R.id.activity_novo_alerta_desligar_dispositivo);
        salvar = (Button) findViewById(R.id.activity_novo_alerta_salvar);
    }
}
