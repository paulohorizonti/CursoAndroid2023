package br.com.devandroid.paulo.appgaseta.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GasEtaDb extends SQLiteOpenHelper {

    public static final String DB_NAME = "gaseta.db";
    public static final int DB_VERSION = 1;

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
}
