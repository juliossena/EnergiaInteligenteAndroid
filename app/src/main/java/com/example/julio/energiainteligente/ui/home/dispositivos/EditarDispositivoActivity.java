package com.example.julio.energiainteligente.ui.home.dispositivos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.models.Dispositivo;
import com.example.julio.energiainteligente.util.Constants;

public class EditarDispositivoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Dispositivo dispositivo;
    private EditText nomeDispositivo;
    private ListView listaProgramacoes;
    private Button btnAdicionarProgramacao;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_dispositivo);

        findId();

        dispositivo = (Dispositivo) getIntent().getExtras().get(Constants.Cache.passarDispositivo);

        toolbar.setTitle(dispositivo.getNome());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nomeDispositivo.setText(dispositivo.getNome());
    }

    private void findId() {
        toolbar = (Toolbar) findViewById(R.id.activity_editar_dispositivo_toolbar);
        nomeDispositivo = (EditText) findViewById(R.id.activity_editar_dispositivo_nome);
        listaProgramacoes = (ListView) findViewById(R.id.activity_editar_dispositivo_programacoes);
        btnAdicionarProgramacao = (Button) findViewById(R.id.activity_editar_dispositivo_adicionar_programacao);
        btnSalvar = (Button) findViewById(R.id.activity_editar_dispositivo_salvar);
    }
}
