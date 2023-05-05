package br.com.devandroid.paulo.appgaseta.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import br.com.devandroid.paulo.appgaseta.R;

public class GasEtaActivity3 extends AppCompatActivity {

    TextInputEditText edtMudarGasolina;
    TextInputEditText edtMudarEtanol;

    TextView txtResultado;
    Button btnCalcular;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasetaold);


        edtMudarGasolina = (TextInputEditText) findViewById(R.id.edtMudarGasolina);
        edtMudarEtanol = (TextInputEditText) findViewById(R.id.edtMudarEtanol);

        txtResultado  = findViewById(R.id.txtResultado);


        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaActivity3.this, "Volte Sempre !", Toast.LENGTH_LONG).show();

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(GasEtaActivity3.this, "Volte Sempre !", Toast.LENGTH_LONG).show();
                finish();

            }
        });



    }
}
