package br.com.devandroid.paulo.applistacursos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.devandroid.paulo.applistacursos.R;
import br.com.devandroid.paulo.applistacursos.model.Pessoa;

//classe que vai instaciar o xml do layout
public class MainActivity extends AppCompatActivity {
    //objeto pessoa
    Pessoa pessoa;

    String dadosPessoa;

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
    }
}