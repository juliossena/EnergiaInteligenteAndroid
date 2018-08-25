package com.example.julio.energiainteligente.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.helper.SlidingTabLayout;
import com.example.julio.energiainteligente.ui.login.LoginActivity;
import com.example.julio.energiainteligente.util.Constants;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findId();

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);

        //Configurando slidingTabLayout
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this, R.color.verde_escuro));

        slidingTabLayout.setViewPager(viewPager);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Energia Inteligente");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_sair:
                deslogarUsuario();
                return true;
            case R.id.item_configuracoes:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void deslogarUsuario(){
        SharedPreferences sharedPreferences = HomeActivity.this.getSharedPreferences(Constants.Cache.nomeSalvarAplicativo, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.Cache.salvarAplicativoEmail, "");
        editor.putString(Constants.Cache.salvarAplicativoSenha, "");
        editor.commit();

        HomeService.fazerLogoff(HomeActivity.this);
        startActivity(new Intent(getBaseContext(), LoginActivity.class));
        finish();
    }

    private void findId() {
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs);
        viewPager = (ViewPager) findViewById(R.id.vp_pagina);
    }
}
