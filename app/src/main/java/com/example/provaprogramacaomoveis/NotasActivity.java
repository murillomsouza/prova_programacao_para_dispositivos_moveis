package com.example.provaprogramacaomoveis;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class NotasActivity extends Activity {

    private EditText edtProva1;
    private EditText edtProva2;
    private EditText edtTrabalho;
    private EditText edtAtividade;

    private Button btnCalcular;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        edtProva1 = findViewById(R.id.edtProva1);
        edtProva2 = findViewById(R.id.edtProva2);
        edtTrabalho = findViewById(R.id.edtTrabalho);
        edtAtividade = findViewById(R.id.edtAtividade);

        btnCalcular = findViewById(R.id.btnCalcularMedia);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(v -> calcularMedia());
    }

}
