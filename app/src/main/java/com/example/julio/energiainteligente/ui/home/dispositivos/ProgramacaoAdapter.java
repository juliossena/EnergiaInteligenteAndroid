package com.example.julio.energiainteligente.ui.home.dispositivos;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.models.Programacao;
import com.example.julio.energiainteligente.models.enuns.TipoType;
import com.example.julio.energiainteligente.ui.util.DateConversoes;


import java.util.Date;
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

        proximaProgramacao.setText("");
        if(programacao.getHorario() != null) {
            proximaProgramacao.setText(DateConversoes.dataBR(programacao.getHorario()));
            if(programacao.getHorario().getTime() > new Date().getTime()) {
                if(programacao.getHorario().getDate() == new Date().getDate()) {
                    Integer tempoRestante = DateConversoes.diferencaMinutos(programacao.getHorario(), new Date());
                    proximaProgramacao.setText("Em " + tempoRestante + " minutos");
                }
            }

        }
        nomeProgramacao.setText(programacao.getNome());

        tipoProgramacao.setText("");
        if(programacao.getType().equals(TipoType.PROGRAMACAO_ESTADO)) {
            tipoProgramacao.setText("Alerta Mudança de Estado");
        } else if(programacao.getType().equals(TipoType.PROGRAMACAO_EXCEDENTE)) {
            tipoProgramacao.setText("Alerta Faixa de Consumo");
        } else if(programacao.getType().equals(TipoType.PROGRAMACAO_MUDANCA)) {
            tipoProgramacao.setText("Mudar estado");
        }


        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("foi", "foi");
            }
        });

        return viewAdapter;
    }
}
