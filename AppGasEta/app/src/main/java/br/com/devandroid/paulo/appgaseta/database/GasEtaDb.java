package br.com.devandroid.paulo.appgaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

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


}
