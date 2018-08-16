package com.example.julio.energiainteligente.ui.home.dispositivos;

import android.app.Activity;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.models.Dispositivo;
import com.example.julio.energiainteligente.models.Programacao;

import java.util.List;

public class ProgramacaoAdapter extends BaseAdapter {

    private final List<Programacao> programacaos;
    private final Activity act;

    public ProgramacaoAdapter(List<Programacao> programacaos, Activity act) {
        this.programacaos = programacaos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return programacaos.size();
    }

    @Override
    public Object getItem(int i) {
        return programacaos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewAdapter = act.getLayoutInflater().inflate(R.layout.item_programacao_adapter, viewGroup, false);

        Programacao programacao = programacaos.get(i);

        TextView nomeProgramacao = (TextView) viewAdapter.findViewById(R.id.item_programacao_adapter_nome_programacao);
        TextView proximaProgramacao = (TextView) viewAdapter.findViewById(R.id.item_programacao_adapter_proxima);
        TextView tipoProgramacao = (TextView) viewAdapter.findViewById(R.id.item_programacao_adapter_tipo);
        ImageView btnExcluir = (ImageView) viewAdapter.findViewById(R.id.item_programacao_adapter_excluir);

        nomeProgramacao.setText("Dispositivo 1");
        proximaProgramacao.setText("Proxima programacao");
        tipoProgramacao.setText("Mais um moc");

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("foi", "foi");
            }
        });

        return viewAdapter;
    }
}
