package br.com.devandroid.paulo.appgaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import br.com.devandroid.paulo.appgaseta.model.Combustivel;
import br.com.devandroid.paulo.appgaseta.view.GasEtaActivity;

public class GasEtaDb extends SQLiteOpenHelper {

    private static final String DB_NAME = "gaseta.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public GasEtaDb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //QUERY PARA CRIAR UMA TABELA
        String sqlTabelaCombustivel
                = "CREATE TABLE Combustivel (id  INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "nomeDoCombustivel TEXT, "+
                "precoCombustivel REAL, "+
                "recomendacao TEXT)";

        db.execSQL(sqlTabelaCombustivel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //metodo para salvar
    public void salvaObjeto(String tabela, ContentValues dados)
    {
        String tab = tabela;

        try{
            db.insert(tabela,null, dados);

        }catch (Exception e)
        {


        }

    }

    public List<Combustivel> listarDados()
    {

        List<Combustivel> lista = new ArrayList<>();

        //represena um registro que ta salvo na tabela de combustivel do db
        Combustivel registro;

        String querySql = "SELECT * FROM Combustivel";

        cursor = db.rawQuery(querySql, null);

        if(cursor.moveToFirst()){
            //ser verdadeiro
            do{
                registro = new Combustivel();

                registro.setId(cursor.getInt(0));
                registro.setNomeCombustivel(cursor.getString(1));
                registro.setPrecoCombustivel(cursor.getDouble(2));
                registro.setRecomendacao(cursor.getString(3));

                lista.add(registro);


            }while(cursor.moveToNext());
        }else{
            //caso de ser falso
        }




        return lista;

    }

    //edição
    public void alterarObjeto(String tabela, ContentValues dados)
    {
        //Id do registro
        int id = dados.getAsInteger("id");

        db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)});

    }

    public void deletarObjeto(String tabela, int id)
    {
               db.delete(tabela, "id=?", new String[]{Integer.toString(id)});

    }



}
