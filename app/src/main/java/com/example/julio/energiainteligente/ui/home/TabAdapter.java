package com.example.julio.energiainteligente.ui.home;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.julio.energiainteligente.ui.home.atual.AtualFragment;
import com.example.julio.energiainteligente.ui.home.dispositivos.DispositivoFragment;
import com.example.julio.energiainteligente.ui.home.historico.HistoricoFragment;

public class TabAdapter extends FragmentStatePagerAdapter{

    private String [] tituloAbas = {"ATUAL", "HISTORICO", "DISPOSITIVOS"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment = new AtualFragment();
                break;
            case 1:
                fragment = new HistoricoFragment();
                break;
            case 2:
                fragment = new DispositivoFragment();
                break;
            default:
                fragment = new AtualFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tituloAbas.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        return tituloAbas[position];
    }
}
