package com.example.julio.energiainteligente.ui.home.dispositivos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.models.Dispositivo;
import com.example.julio.energiainteligente.ui.login.LoginActivity;
import com.example.julio.energiainteligente.ui.util.HideKeyboard;
import com.example.julio.energiainteligente.util.Constants;

public class EditarDispositivoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Dispositivo dispositivo;
    private EditText nomeDispositivo;
    private ListView listaProgramacoes;
    private Button btnAdicionarProgramacao;
    private Button btnSalvar;
    private ProgramacaoAdapter programacaoAdapter;
    private RelativeLayout relativeLayout;
    private Switch status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_dispositivo);

        findId();

        dispositivo = (Dispositivo) getIntent().getExtras().get(Constants.Cache.passarDispositivo);

        if (dispositivo.getLigado()) {
            status.setChecked(true);
            status.setText("Ligado: ");
        } else {
            status.setChecked(false);
            status.setText("Desligado: ");
        }

        toolbar.setTitle(dispositivo.getNome());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        programacaoAdapter = new ProgramacaoAdapter(dispositivo.getProgramacoes(), this);
        listaProgramacoes.setAdapter(programacaoAdapter);

        nomeDispositivo.setText(dispositivo.getNome());

        btnAdicionarProgramacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditarDispositivoActivity.this, NovaProgramacaoActivity.class);
                intent.putExtra(Constants.Cache.passarDispositivo, dispositivo);

                startActivity(intent);
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HideKeyboard.hide(EditarDispositivoActivity.this);
            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (status.isChecked()) {
                    status.setText("Ligado: ");
                } else {
                    status.setText("Desligado: ");
                }
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispositivo.setNome(nomeDispositivo.getText().toString());
                dispositivo.setLigado(status.isChecked());
                DispositivoService.atualizarDispositivo(EditarDispositivoActivity.this, dispositivo);
            }
        });

    }

    private void findId() {
        toolbar = (Toolbar) findViewById(R.id.activity_editar_dispositivo_toolbar);
        nomeDispositivo = (EditText) findViewById(R.id.activity_editar_dispositivo_nome);
        listaProgramacoes = (ListView) findViewById(R.id.activity_editar_dispositivo_programacoes);
        btnAdicionarProgramacao = (Button) findViewById(R.id.activity_editar_dispositivo_adicionar_programacao);
        btnSalvar = (Button) findViewById(R.id.activity_editar_dispositivo_salvar);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_editar_dispositivo_relative_layout);
        status = (Switch) findViewById(R.id.activity_editar_dispositivo_switch);
    }
}
