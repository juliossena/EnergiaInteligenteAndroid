package com.example.julio.energiainteligente.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.modelRequest.LoginRequest;
import com.example.julio.energiainteligente.ui.home.HomeActivity;
import com.example.julio.energiainteligente.ui.util.AlertMessage;
import com.example.julio.energiainteligente.ui.util.HideKeyboard;
import com.example.julio.energiainteligente.util.Constants;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class LoginActivity extends Activity {

    private TextView esqueciMinhaSenha;
    private Button fazerLogin;
    private EditText edtEmail;
    private EditText edtSenha;
    private RelativeLayout relativeLayout;
    private Switch manterLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findId();

        Constants.Session.tokenFirebase = FirebaseInstanceId.getInstance().getToken();

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

                    LoginService.fazerLogin(LoginActivity.this, manterLogado, new LoginRequest(
                            edtEmail.getText().toString(),
                            edtSenha.getText().toString(),
                            Constants.Session.tokenFirebase
                    ));
                } else {
                    AlertMessage.showMessage(LoginActivity.this, Constants.Alert.preencherCampos, Constants.Alert.atencao);
                }
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HideKeyboard.hide(LoginActivity.this);
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(Constants.Cache.nomeSalvarAplicativo, 0);
        if (sharedPreferences.contains(Constants.Cache.salvarAplicativoEmail) &&
                !sharedPreferences.getString(Constants.Cache.salvarAplicativoEmail, "").equals("")) {
            String email = sharedPreferences.getString(Constants.Cache.salvarAplicativoEmail, "");
            String senha = sharedPreferences.getString(Constants.Cache.salvarAplicativoSenha, "");

            edtEmail.setText(email);
            edtSenha.setText(senha);
            manterLogado.setChecked(true);

            LoginService.fazerLogin(LoginActivity.this, manterLogado, new LoginRequest(
                    email,
                    senha,
                    Constants.Session.tokenFirebase
            ));
        }
    }

    private void findId() {
        esqueciMinhaSenha = (TextView) findViewById(R.id.activity_login_esqueci_minha_senha);
        fazerLogin = (Button) findViewById(R.id.activity_login_entrar);
        edtEmail = (EditText) findViewById(R.id.activity_login_email);
        edtSenha = (EditText) findViewById(R.id.activity_login_senha);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_login_relative_layout);
        manterLogado = (Switch) findViewById(R.id.activity_login_manter_logado);
    }
}
