package com.example.acai.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBD extends SQLiteOpenHelper {


    public String nomeBD = "acaii.db";
    public String tabela = "acai";
    public String ID = "_id";
    public String tamanho = "tamanho";
    public String acompanhamento = "acompanhamento";
    public String quantidade = "qtd";
    public String preco = "preco";
    public int versao = 1;

    public  CriaBD(Context context){
        super(context, "acaii.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " +  tabela + "("+
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                quantidade + " INTERGER NOT NULL,"+
                tamanho + " INTERGER NOT NULL," +
                acompanhamento + " VARCHAR(155) NOT NULL," +
                preco + " DOUBLE NOT NULL);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS " + tabela;
        db.execSQL(sql);
        onCreate(db);
    }
}

