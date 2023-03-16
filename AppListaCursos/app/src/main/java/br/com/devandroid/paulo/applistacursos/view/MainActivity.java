package br.com.devandroid.paulo.applistacursos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import br.com.devandroid.paulo.applistacursos.R;
import br.com.devandroid.paulo.applistacursos.model.Pessoa;
import br.com.devandroid.paulo.applistacursos.utils.MaskEditUtil;

//classe que vai instaciar o xml do layout
public class MainActivity extends AppCompatActivity {
    //objeto pessoa
    Pessoa pessoa;

    String dadosPessoa;

    //componentes do layout, tendo o mesmo ID que esta no xml
    TextInputEditText edtNomeAlterar;
    TextInputEditText edtSobrenomeAlterar;
    TextInputEditText edtCursoAlterar;
    TextInputEditText edtTelefoneAlterar;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciando o objto
        pessoa = new Pessoa();

        pessoa.setPrimeiroNome("PAULO ROBERTO");
        pessoa.setSobreNome("NOGUEIRA");
        pessoa.setCursoDesejado("ANDRODID");
        pessoa.setTelefoneDeContato("63-992062543");

        dadosPessoa = "Primeiro Nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa = "Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();

        edtNomeAlterar = (TextInputEditText)findViewById(R.id.edtNomeAlterar);
        edtSobrenomeAlterar = (TextInputEditText)findViewById(R.id.edtSobrenomeAlterar);
        edtTelefoneAlterar = (TextInputEditText)findViewById(R.id.edtTelefoneAlterar);
        edtCursoAlterar =(TextInputEditText) findViewById(R.id.edtCursoAlterar);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        //APLICANDO A MASCARA
        edtTelefoneAlterar.addTextChangedListener(MaskEditUtil.mask(edtTelefoneAlterar, MaskEditUtil.FORMAT_FONE));


        edtNomeAlterar.setText(pessoa.getPrimeiroNome());
        edtSobrenomeAlterar.setText(pessoa.getSobreNome());
        edtTelefoneAlterar.setText(pessoa.getTelefoneDeContato());
        edtCursoAlterar.setText(pessoa.getCursoDesejado());


        //metodo do botao
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                edtNomeAlterar.setText("");
                edtSobrenomeAlterar.setText("");
                edtTelefoneAlterar.setText("");
                edtCursoAlterar.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre !", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(edtNomeAlterar.getText().toString());
                pessoa.setSobreNome(edtSobrenomeAlterar.getText().toString());
                pessoa.setTelefoneDeContato(edtTelefoneAlterar.getText().toString());
                pessoa.setCursoDesejado(edtCursoAlterar.getText().toString());


                Toast.makeText(MainActivity.this, "Salvo : "+pessoa.toString(), Toast.LENGTH_LONG).show();
            }
        });



        Log.i("POOAndroid", pessoa.toString());

    }
}