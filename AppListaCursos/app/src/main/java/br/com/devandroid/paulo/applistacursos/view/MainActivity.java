package br.com.devandroid.paulo.applistacursos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import br.com.devandroid.paulo.applistacursos.R;
import br.com.devandroid.paulo.applistacursos.controller.PessoaController;
import br.com.devandroid.paulo.applistacursos.model.Pessoa;
import br.com.devandroid.paulo.applistacursos.utils.MaskEditUtil;

//classe que vai instaciar o xml do layout
public class MainActivity extends AppCompatActivity {


    //CRIAR UM OBJETO DO TIPO SHAREDPREFERENCES
    SharedPreferences preferences;

    //contante
    public static final String NOME_PREFERENCES = "pref_listavip";
    PessoaController pessoaController;
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
        pessoaController = new PessoaController();
        //o nome e o modo de acesso do arquivo de preferences
        preferences = getSharedPreferences(NOME_PREFERENCES, 0);

        SharedPreferences.Editor listaVip = preferences.edit(); //abrindo o arquivo para edição

        //instanciando o objto
        pessoa = new Pessoa();
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome",""));
        pessoa.setSobreNome(preferences.getString("sobrenome",""));
        pessoa.setCursoDesejado(preferences.getString("curso",""));
        pessoa.setTelefoneDeContato(preferences.getString("telefone", ""));


        dadosPessoa = "Primeiro Nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa = "Sobrenome: ";
        dadosPessoa += pessoa.getSobreNome();

        edtNomeAlterar = (TextInputEditText) findViewById(R.id.edtNomeAlterar);
        edtSobrenomeAlterar = (TextInputEditText) findViewById(R.id.edtSobrenomeAlterar);
        edtTelefoneAlterar = (TextInputEditText) findViewById(R.id.edtTelefoneAlterar);
        edtCursoAlterar = (TextInputEditText) findViewById(R.id.edtCursoAlterar);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);


        edtNomeAlterar.setText(pessoa.getPrimeiroNome());
        edtSobrenomeAlterar.setText(pessoa.getSobreNome());
        edtCursoAlterar.setText(pessoa.getCursoDesejado());
        edtTelefoneAlterar.setText(pessoa.getTelefoneDeContato());

        //APLICANDO A MASCARA
        edtTelefoneAlterar.addTextChangedListener(MaskEditUtil.mask(edtTelefoneAlterar, MaskEditUtil.FORMAT_FONE));





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

                Toast.makeText(MainActivity.this, "Salvo : " + pessoa.toString(), Toast.LENGTH_LONG).show();

                listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaVip.putString("sobrenome", pessoa.getSobreNome());
                listaVip.putString("curso", pessoa.getCursoDesejado());
                listaVip.putString("telefone", pessoa.getTelefoneDeContato());

                listaVip.apply();

                pessoaController.salvar(pessoa);
            }
        });


        Log.i("POOAndroid", pessoa.toString());

    }
}