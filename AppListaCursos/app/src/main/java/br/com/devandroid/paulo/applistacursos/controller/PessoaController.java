package br.com.devandroid.paulo.applistacursos.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import br.com.devandroid.paulo.applistacursos.model.Pessoa;
import br.com.devandroid.paulo.applistacursos.view.MainActivity;

public class PessoaController {
    //CRIAR UM OBJETO DO TIPO SHAREDPREFERENCES
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    //constante com o nome do arquivo sharedpref
    public static final String NOME_PREFERENCES = "pref_listavip";


    //consttura CRIA UM SHARED PREFERENCES E COLOCA ELE PARA EDITAR NUMA LISTA

    public PessoaController(MainActivity mainActivity){
        this.preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        listaVip = preferences.edit(); //abrindo o arquivo para edição

    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciada");
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome", pessoa.getSobreNome());
        listaVip.putString("curso", pessoa.getCursoDesejado());
        listaVip.putString("telefone", pessoa.getTelefoneDeContato());
         listaVip.apply();
        Log.d("MVC_Controller", "Salvo : "+pessoa.toString());

    }


    public Pessoa buscar(Pessoa pessoa){
         pessoa.setPrimeiroNome(preferences.getString("primeiroNome",""));
         pessoa.setSobreNome(preferences.getString("sobrenome",""));
         pessoa.setCursoDesejado(preferences.getString("curso",""));
         pessoa.setTelefoneDeContato(preferences.getString("telefone", ""));

         return pessoa; //manda o objeto ja preenchido

    }

    public void limpar(){
        //limpando o sharedpreferences

         listaVip.clear();
        listaVip.apply();;

    }
}
