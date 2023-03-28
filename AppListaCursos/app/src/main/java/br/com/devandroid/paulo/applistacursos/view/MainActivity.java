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

import java.util.List;

import br.com.devandroid.paulo.applistacursos.R;
import br.com.devandroid.paulo.applistacursos.controller.CursoController;
import br.com.devandroid.paulo.applistacursos.controller.PessoaController;
import br.com.devandroid.paulo.applistacursos.model.Curso;
import br.com.devandroid.paulo.applistacursos.model.Pessoa;
import br.com.devandroid.paulo.applistacursos.utils.MaskEditUtil;

//classe que vai instaciar o xml do layout
public class MainActivity extends AppCompatActivity {


   PessoaController pessoaController;

   CursoController cursoContrller;
    //objeto pessoa
    Pessoa pessoa;

    List<Curso> listaDeCursos; //lista para receber o getlista do contrller

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

        //controller pessoa
        pessoaController = new PessoaController(MainActivity.this);

       cursoContrller = new CursoController();

        listaDeCursos =  cursoContrller.getListaDeCursos(); //aqui ele chama o metodo getlista e manda pra nossa lista no main
        //agora pode ser mostradona view

        //instanciando o objto
        pessoa = new Pessoa();

        //agora chama o metodo para pegar a pessoa
        pessoaController.buscar(pessoa);


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


        //atribui o valor que veio no objeto pessoa aos elementos que compoe a tela
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

                pessoaController.limpar();


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

                //manda pra controladora para salvar
                pessoaController.salvar(pessoa);
            }
        });


        Log.i("POOAndroid", pessoa.toString());

    }
}