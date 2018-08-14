package com.example.julio.energiainteligente.ui.home.dispositivos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.helper.SlidingTabLayout;
import com.example.julio.energiainteligente.models.Dispositivo;
import com.example.julio.energiainteligente.models.Programacao;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DispositivoFragment extends Fragment {

    private ListView tabela;
    private ArrayList<Dispositivo> listaDispositivos = new ArrayList<>();
    private DispositivoAdapter dispositivoAdapter;

    public DispositivoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dispositivo, container, false);
        findId(view);

        //TODO Dados Mocados
        Dispositivo d = new Dispositivo();
        d.setId(1);
        d.setNome("teste");
        d.setLigado(true);
        Programacao p = new Programacao();
        d.addProgramacao(p);
        listaDispositivos.add(d);

        d = new Dispositivo();
        d.setId(2);
        d.setNome("teste2");
        d.setLigado(false);
        p = new Programacao();
        d.addProgramacao(p);
        listaDispositivos.add(d);

        d = new Dispositivo();
        d.setId(3);
        d.setNome("teste3");
        d.setLigado(true);
        p = new Programacao();
        d.addProgramacao(p);
        listaDispositivos.add(d);
        //Termino dados mocados

        dispositivoAdapter = new DispositivoAdapter(listaDispositivos, inflater);

        tabela.setAdapter(dispositivoAdapter);




        return view;
    }

    private void findId(View view) {
        tabela = view.findViewById(R.id.fragment_dispositivo_lista);
    }
}
