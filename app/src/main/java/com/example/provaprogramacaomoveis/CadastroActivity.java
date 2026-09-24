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

    private SharedPreferences preferences;

    private static final String NOME_ARQUIVO = "dados_aluno";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtRA = findViewById(R.id.edtRA);
        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);

        btnSalvar = findViewById(R.id.btnSalvar);

        preferences = getSharedPreferences(
                NOME_ARQUIVO,
                MODE_PRIVATE
        );

        carregarDados();

        btnSalvar.setOnClickListener(v -> salvarDados());
    }

    private void salvarDados() {

        String ra = edtRA.getText().toString().trim();
        String nome = edtNome.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();

        if (ra.isEmpty() || nome.isEmpty() || email.isEmpty()) {

            Toast.makeText(this,
                    "Preencha todos os campos.",
                    Toast.LENGTH_SHORT).show();

            return;
        }

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("ra", ra);
        editor.putString("nome", nome);
        editor.putString("email", email);

        editor.apply();

        Toast.makeText(this,
                "Dados salvos com sucesso!",
                Toast.LENGTH_SHORT).show();
    }

    private void carregarDados() {

        String ra = preferences.getString("ra", "");
        String nome = preferences.getString("nome", "");
        String email = preferences.getString("email", "");

        edtRA.setText(ra);
        edtNome.setText(nome);
        edtEmail.setText(email);
    }
}

