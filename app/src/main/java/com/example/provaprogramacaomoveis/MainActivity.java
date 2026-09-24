package com.example.provaprogramacaomoveis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button btnNotas;
    private Button btnCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotas = findViewById(R.id.btnNotas);
        btnCadastro = findViewById(R.id.btnCadastro);

        btnNotas.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NotasActivity.class);
            startActivity(intent);
        });

        btnCadastro.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(intent);
        });
    }
}
