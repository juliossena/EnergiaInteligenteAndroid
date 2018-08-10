package com.example.julio.energiainteligente.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.ui.util.AlertMessage;
import com.example.julio.energiainteligente.ui.util.HideKeyboard;
import com.example.julio.energiainteligente.util.Constants;

public class LoginActivity extends Activity {

    private TextView esqueciMinhaSenha;
    private Button fazerLogin;
    private EditText edtEmail;
    private EditText edtSenha;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findId();

        esqueciMinhaSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), EsqueciMinhaSenhaActivity.class));
            }
        });

        fazerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtEmail.getText().toString().length() > 0 && edtSenha.getText().toString().length() > 0) {

                } else {
                    AlertMessage.showMessage(LoginActivity.this, Constants.preencherCampos, Constants.atencao);
                }
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HideKeyboard.hide(LoginActivity.this);
            }
        });
    }

    private void findId() {
        esqueciMinhaSenha = (TextView) findViewById(R.id.activity_login_esqueci_minha_senha);
        fazerLogin = (Button) findViewById(R.id.activity_login_entrar);
        edtEmail = (EditText) findViewById(R.id.activity_login_email);
        edtSenha = (EditText) findViewById(R.id.activity_login_senha);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_login_relative_layout);
    }
}
