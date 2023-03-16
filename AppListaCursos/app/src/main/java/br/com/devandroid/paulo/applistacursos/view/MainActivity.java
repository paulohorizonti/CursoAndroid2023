package br.com.devandroid.paulo.applistacursos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.devandroid.paulo.applistacursos.R;
import br.com.devandroid.paulo.applistacursos.model.Pessoa;

//classe que vai instaciar o xml do layout
public class MainActivity extends AppCompatActivity {
    //objeto pessoa
    Pessoa pessoa;

    String dadosPessoa;

    //componentes do layout, tendo o mesmo ID que esta no xml
    EditText edtNome;
    EditText edtSobrenome;
    EditText edtCurso;
    EditText edtTelefone;

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

        edtNome = findViewById(R.id.edtNome);
        edtSobrenome = findViewById(R.id.edtSobrenome);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtCurso = findViewById(R.id.edtCurso);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        edtNome.setText(pessoa.getPrimeiroNome());
        edtSobrenome.setText(pessoa.getSobreNome());
        edtTelefone.setText(pessoa.getTelefoneDeContato());
        edtCurso.setText(pessoa.getCursoDesejado());


        //metodo do botao
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                edtNome.setText("");
                edtSobrenome.setText("");
                edtTelefone.setText("");
                edtCurso.setText("");
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
                pessoa.setPrimeiroNome(edtNome.getText().toString());
                pessoa.setSobreNome(edtSobrenome.getText().toString());
                pessoa.setTelefoneDeContato(edtTelefone.getText().toString());
                pessoa.setCursoDesejado(edtCurso.getText().toString());


                Toast.makeText(MainActivity.this, "Salvo : "+pessoa.toString(), Toast.LENGTH_LONG).show();
            }
        });



        Log.i("POOAndroid", pessoa.toString());

    }
}