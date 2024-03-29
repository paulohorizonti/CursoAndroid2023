package br.com.devandroid.paulo.appgaseta.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.widget.Toast;

import br.com.devandroid.paulo.appgaseta.database.GasEtaDb;
import br.com.devandroid.paulo.appgaseta.model.Combustivel;
import br.com.devandroid.paulo.appgaseta.view.GasEtaActivity;

public class CombustivelController extends GasEtaDb {

    SharedPreferences preferences;

    SharedPreferences.Editor dadosPrefernces;

    public static final String NOME_PREFERENCES = "pref_gaseta";

    //construtor
    public CombustivelController(GasEtaActivity activity)
    {
        super(activity);
        //instaciar o arquivo ṕara salvar os dados
        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);

        dadosPrefernces = preferences.edit();
    }

    //metodo salvar
    public void salvar(Combustivel combustivel)
    {

        ContentValues dados = new ContentValues();
        dadosPrefernces.putString("combustivel", combustivel.getNomeCombustivel());
        dadosPrefernces.putFloat("precoDoCombustive", (float) combustivel.getPrecoCombustivel());
        dadosPrefernces.putString("recomentacao", combustivel.getRecomendacao());
        dadosPrefernces.apply();

        //persistencia
        dados.put("nomeDoCombustivel",combustivel.getNomeCombustivel());
        dados.put("precoCombustivel",combustivel.getPrecoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        salvaObjeto("Combustivel", dados);



    }

    public void limpar()
    {
        dadosPrefernces.clear();
        dadosPrefernces.apply();
    }
}
