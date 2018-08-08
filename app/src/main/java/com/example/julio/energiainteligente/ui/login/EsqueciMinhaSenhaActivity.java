package com.example.julio.energiainteligente.ui.login;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.julio.energiainteligente.R;

public class EsqueciMinhaSenhaActivity extends Activity {

    private Button btnVoltar;
    private EditText edtEmail;
    private EditText edtCpf;
    private Button btnRecuperarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_minha_senha);

        findId();

        btnRecuperarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    protected void findId() {
        btnVoltar = (Button) findViewById(R.id.activity_esqueci_minha_senha_voltar);
        edtCpf = (EditText) findViewById(R.id.activity_esqueci_minha_senha_cpf);
        edtEmail = (EditText) findViewById(R.id.activity_esqueci_minha_senha_email);
        btnRecuperarSenha = (Button) findViewById(R.id.activity_esqueci_minha_senha_recuperar_senha);
    }
}
