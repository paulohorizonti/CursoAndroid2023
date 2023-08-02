package br.com.devandroid.paulo.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import br.com.devandroid.paulo.appgaseta.R;
import br.com.devandroid.paulo.appgaseta.model.Combustivel;
import br.com.devandroid.paulo.appgaseta.util.AppUtilGasEta;

public class GasEtaActivity extends AppCompatActivity {
    //declarar a classe compbusivel
    Combustivel combustivelGsolina;
    Combustivel combustivelEtanol;

    TextInputEditText edtMudarGasolina, edtMudarEtanol;
    Button btnCalcular, btnLimpar, btnSalvar, btnFinalizar;

    //variaveis para pegar os valores
    double precoGasolina;
    double precoEtanol;
    String recomendacao;
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




                boolean isDadosOk = true;

               if(TextUtils.isEmpty(edtMudarGasolina.getText())){
                   edtMudarGasolina.setError("* Obrigatório");
                   edtMudarGasolina.requestFocus();
                   isDadosOk = false;
               }

                if(TextUtils.isEmpty(edtMudarEtanol.getText())){
                    edtMudarEtanol.setError("* Obrigatório");
                    edtMudarEtanol.requestFocus();
                    isDadosOk = false;
                }

                if(isDadosOk)
                {
                    precoGasolina = Double.valueOf(edtMudarGasolina.getText().toString());
                    precoEtanol = Double.valueOf(edtMudarEtanol.getText().toString());

                    String resultado =   AppUtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol);
                    txtResultado.setText(resultado);
                }else {
                    Toast.makeText(GasEtaActivity.this, "DADOS INVÁLIDOS, /n TENTE NOVAMENTE", Toast.LENGTH_LONG).show();

                }

/*

*/
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
                edtMudarGasolina.setText("");
                edtMudarEtanol.setText("");
                txtResultado.requestFocus();


            }
        });


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TO-DO Desabilitar o botao salvar
                combustivelGsolina = new Combustivel();
                combustivelEtanol = new Combustivel();

                combustivelGsolina.setNomeCombustivel("GASOLINA");
                combustivelGsolina.setPrecoCombustivel(precoGasolina);
                combustivelGsolina.setRecomendacao(AppUtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));

                combustivelEtanol.setNomeCombustivel("ETANOL");
                combustivelEtanol.setPrecoCombustivel(precoEtanol);
                combustivelEtanol.setRecomendacao(AppUtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));

            }
        });

    }
}