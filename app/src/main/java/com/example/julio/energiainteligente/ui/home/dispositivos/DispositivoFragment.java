package com.example.julio.energiainteligente.ui.home.dispositivos;


import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.models.Dispositivo;
import com.example.julio.energiainteligente.models.Programacao;
import com.example.julio.energiainteligente.util.Constants;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DispositivoFragment extends Fragment {

    private ListView tabela;
    private ArrayList<Dispositivo> listaDispositivos = new ArrayList<>();
    private DispositivoAdapter dispositivoAdapter;
    private LayoutInflater inflater;

    public DispositivoFragment() {
        // Required empty public constructor
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        if (menuVisible) {
            DispositivoService.listarDispositivos(inflater.getContext(), listaDispositivos, dispositivoAdapter);
        }

        super.setMenuVisibility(menuVisible);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.inflater = inflater;
        View view = inflater.inflate(R.layout.fragment_dispositivo, container, false);
        findId(view);

        dispositivoAdapter = new DispositivoAdapter(listaDispositivos, inflater);

        tabela.setAdapter(dispositivoAdapter);

        tabela.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(inflater.getContext(), EditarDispositivoActivity.class);
                intent.putExtra(Constants.Cache.passarDispositivo, listaDispositivos.get(i));

                startActivity(intent);
            }
        });


        return view;
    }



    private void findId(View view) {
        tabela = view.findViewById(R.id.fragment_dispositivo_lista);
    }
}
