package com.example.julio.energiainteligente.ui.home.dispositivos;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.models.Dispositivo;

import java.util.List;

public class DispositivoAdapter extends BaseAdapter {

    private final List<Dispositivo> dispositivos;
    private final LayoutInflater act;

    public DispositivoAdapter(List<Dispositivo> dispositivos, LayoutInflater act) {
        this.dispositivos = dispositivos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return dispositivos.size();
    }

    @Override
    public Object getItem(int i) {
        return dispositivos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewAdapter = act.inflate(R.layout.item_dispositivo_adapter, viewGroup, false);

        Dispositivo disp = dispositivos.get(i);

        TextView nomeDispositivo = (TextView) viewAdapter.findViewById(R.id.item_dispositivo_adapter_nome_dispositivo);
        TextView qtdDispositivos = (TextView) viewAdapter.findViewById(R.id.item_dispositivo_adapter_qtd_programacoes);
        ImageView icone = (ImageView) viewAdapter.findViewById(R.id.item_dispositivo_adapter_icone);
        LinearLayout caixa = (LinearLayout) viewAdapter.findViewById(R.id.item_dispositivo_adapter_layout_caixa);
        LinearLayout caixaIcone = (LinearLayout) viewAdapter.findViewById(R.id.item_dispositivo_adapter_layout_icone);

        nomeDispositivo.setText(disp.getNome());
        qtdDispositivos.setText("PROGRAMAÇÕES: " + disp.getProgramacoes().size());

        if (disp.getLigado()) {
            icone.setImageResource(R.drawable.ic_assignment_turned_in);
        } else {
            nomeDispositivo.setTextColor(ContextCompat.getColor(act.getContext(), R.color.vermelho_escuro));
            qtdDispositivos.setTextColor(ContextCompat.getColor(act.getContext(), R.color.vermelho_escuro));

            final int sdk = android.os.Build.VERSION.SDK_INT;
            if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                caixa.setBackgroundDrawable(ContextCompat.getDrawable(act.getContext(), R.drawable.edit_text_arredondado_vermelho));
                caixaIcone.setBackgroundDrawable(ContextCompat.getDrawable(act.getContext(), R.drawable.botao_arredondado_vermelho));
            } else {
                caixa.setBackground(ContextCompat.getDrawable(act.getContext(), R.drawable.edit_text_arredondado_vermelho));
                caixaIcone.setBackground(ContextCompat.getDrawable(act.getContext(), R.drawable.botao_arredondado_vermelho));
            }
            icone.setImageResource(R.drawable.ic_assignment_late);
        }

        return viewAdapter;
    }
}
