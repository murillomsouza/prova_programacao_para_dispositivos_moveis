package com.example.provaprogramacaomoveis;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
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

        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(v -> calcularMedia());
    }

    private void calcularMedia() {

        String valorProva1 = edtProva1.getText().toString().trim();
        String valorProva2 = edtProva2.getText().toString().trim();
        String valorTrabalho = edtTrabalho.getText().toString().trim();
        String valorAtividade = edtAtividade.getText().toString().trim();

        if (valorProva1.isEmpty() ||
                valorProva2.isEmpty() ||
                valorTrabalho.isEmpty() ||
                valorAtividade.isEmpty()) {

            Toast.makeText(this,
                    "Preencha todas as notas.",
                    Toast.LENGTH_SHORT).show();

            return;
        }

        try {

            double prova1 = Double.parseDouble(valorProva1.replace(",", "."));
            double prova2 = Double.parseDouble(valorProva2.replace(",", "."));
            double trabalho = Double.parseDouble(valorTrabalho.replace(",", "."));
            double atividade = Double.parseDouble(valorAtividade.replace(",", "."));

            if (!notaValida(prova1) ||
                    !notaValida(prova2) ||
                    !notaValida(trabalho) ||
                    !notaValida(atividade)) {

                Toast.makeText(this,
                        "As notas devem estar entre 0 e 10.",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            double media = (prova1 + prova2 + trabalho + atividade) / 4;

            txtResultado.setText(
                    String.format(Locale.getDefault(),
                            "Média Final: %.2f",
                            media)
            );

        } catch (NumberFormatException e) {

            Toast.makeText(this,
                    "Digite apenas valores numéricos.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private boolean notaValida(double nota) {
        return nota >= 0 && nota <= 10;
    }
}
