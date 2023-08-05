package br.com.devandroid.paulo.appgaseta.controller;

import android.content.SharedPreferences;

import br.com.devandroid.paulo.appgaseta.model.Combustivel;
import br.com.devandroid.paulo.appgaseta.view.GasEtaActivity;

public class CombustivelController {

    SharedPreferences preferences;

    SharedPreferences.Editor dadosPrefernces;

    public static final String NOME_PREFERENCES = "pref_gaseta";

    //construtor
    public CombustivelController(GasEtaActivity activity)
    {
        //instaciar o arquivo ṕara salvar os dados
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);

        dadosPrefernces = preferences.edit();
    }

    //metodo salvar
    public void salvar(Combustivel combustivel)
    {
        dadosPrefernces.putString("combustivel", combustivel.getNomeCombustivel());
        dadosPrefernces.putFloat("precoDoCombustive", (float) combustivel.getPrecoCombustivel());
        dadosPrefernces.putString("recomentacao", combustivel.getRecomendacao());

        dadosPrefernces.apply();
    }

    public void limpar()
    {
        dadosPrefernces.clear();
        dadosPrefernces.apply();
    }
}
