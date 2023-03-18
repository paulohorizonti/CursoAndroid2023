package br.com.devandroid.paulo.applistacursos.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import br.com.devandroid.paulo.applistacursos.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller Iniciada");
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {

        Log.d("MVC_Controller", "Salvo : "+pessoa.toString());

    }
}
