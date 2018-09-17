package com.example.julio.energiainteligente.ui.home.dispositivos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.models.Dispositivo;
import com.example.julio.energiainteligente.util.Constants;

public class TipoNovaProgramacaoActivity extends AppCompatActivity {

    ListView lista;
    private Dispositivo dispositivo;
    private String[] opcoes = {
            "Alerta", "Mudança de Estado"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_nova_programacao);

        findById();
        dispositivo = (Dispositivo) getIntent().getExtras().get(Constants.Cache.passarDispositivo);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.select_dialog_item,
                android.R.id.text1,
                opcoes
        );

        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(TipoNovaProgramacaoActivity.this, NovoAlertaActivity.class);
                    intent.putExtra(Constants.Cache.passarDispositivo, dispositivo);

                    startActivity(intent);
                    TipoNovaProgramacaoActivity.this.finish();
                } else if(i == 1) {
                    Intent intent = new Intent(TipoNovaProgramacaoActivity.this, NovaProgramacaoActivity.class);
                    intent.putExtra(Constants.Cache.passarDispositivo, dispositivo);

                    startActivity(intent);
                    TipoNovaProgramacaoActivity.this.finish();
                }
            }
        });

    }

    private void findById() {
        this.lista = (ListView) findViewById(R.id.activity_tipo_nova_programacao_lista);
    }
}
