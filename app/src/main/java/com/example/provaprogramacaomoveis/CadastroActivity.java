package com.example.provaprogramacaomoveis;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends Activity {

    private EditText edtRA;
    private EditText edtNome;
    private EditText edtEmail;

    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtRA = findViewById(R.id.edtRA);
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);

        btnSalvar = findViewById(R.id.btnSalvarAluno);

        preferences = getSharedPreferences(
                NOME_ARQUIVO,
                MODE_PRIVATE
        );

        carregarDados();

        btnSalvar.setOnClickListener(v -> salvarDados());
    }

}

