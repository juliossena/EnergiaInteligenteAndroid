package com.example.julio.energiainteligente.ui.login;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.julio.energiainteligente.R;
import com.example.julio.energiainteligente.ui.util.AlertMessage;
import com.example.julio.energiainteligente.ui.util.HideKeyboard;
import com.example.julio.energiainteligente.util.Constants;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class EsqueciMinhaSenhaActivity extends Activity {

    private Button btnVoltar;
    private EditText edtEmail;
    private EditText edtCpf;
    private Button btnRecuperarSenha;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_minha_senha);

        findId();

        //Mascara CPF
        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtw = new MaskTextWatcher(edtCpf, smf);
        edtCpf.addTextChangedListener(mtw);

        btnRecuperarSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtEmail.getText().toString().length() > 0 && edtCpf.getText().toString().length() > 0) {

                } else {
                    AlertMessage.showMessage(EsqueciMinhaSenhaActivity.this, Constants.preencherCampos, Constants.atencao);
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HideKeyboard.hide(EsqueciMinhaSenhaActivity.this);
            }
        });
    }

    protected void findId() {
        btnVoltar = (Button) findViewById(R.id.activity_esqueci_minha_senha_voltar);
        edtCpf = (EditText) findViewById(R.id.activity_esqueci_minha_senha_cpf);
        edtEmail = (EditText) findViewById(R.id.activity_esqueci_minha_senha_email);
        btnRecuperarSenha = (Button) findViewById(R.id.activity_esqueci_minha_senha_recuperar_senha);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_esqueci_minha_senha_relative_layout);
    }
}
