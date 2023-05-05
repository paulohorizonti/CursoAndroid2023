package br.com.devandroid.paulo.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import br.com.devandroid.paulo.appgaseta.R;
import br.com.devandroid.paulo.appgaseta.util.AppUtilGasEta;

public class GasEtaActivity extends AppCompatActivity {
    TextInputEditText edtMudarGasolina, edtMudarEtanol;
    Button btnCalcular, btnLimpar, btnSalvar, btnFinalizar;

    TextView txtResultado;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Esta linha contém o código necessário.10,
        setContentView(R.layout.activity_gaseta);


        edtMudarGasolina = (TextInputEditText) findViewById(R.id.edtMudarGasolina);
        edtMudarEtanol = (TextInputEditText) findViewById(R.id.edtMudarEtanol);

        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar= findViewById(R.id.btnFinalizar);



        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String resultado =   AppUtilGasEta.calcularMelhorOpcao(Double.valueOf(edtMudarGasolina.getText().toString()), Double.valueOf(edtMudarEtanol.getText().toString()));
              txtResultado.setText(resultado);

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaActivity.this, AppUtilGasEta.mensagem(), Toast.LENGTH_LONG).show();
                finish();
            }
        });


        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResultado.setText("RESULTADO");
            }
        });

    }
}