package com.example.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editGasolina;
    private EditText editEtanol;
    private ImageView imageViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);
        imageViewResultado = findViewById(R.id.imageViewResultado);


    }

    public void calcularVantagem(View view) {
        String precoGasolina = editGasolina.getText().toString();
        String precoEtanol = editEtanol.getText().toString();
        if (!precoGasolina.isEmpty() && !precoEtanol.isEmpty()) {
            if (Double.parseDouble(precoGasolina) > 0 && Double.parseDouble(precoEtanol) > 0) {
                Double resultado = Double.parseDouble(precoEtanol) / Double.parseDouble(precoGasolina);

                if (resultado >= 0.7) {
                    imageViewResultado.setVisibility(View.VISIBLE);
                    imageViewResultado.setImageResource(R.drawable.gasolina);
                } else {
                    imageViewResultado.setVisibility(View.VISIBLE);
                    imageViewResultado.setImageResource(R.drawable.etanol);
                }
            } else {
                imageViewResultado.setVisibility(View.VISIBLE);
                imageViewResultado.setImageResource(R.drawable.erro);
            }
        } else {
            imageViewResultado.setVisibility(View.VISIBLE);
            imageViewResultado.setImageResource(R.drawable.erro);
        }

    }

}