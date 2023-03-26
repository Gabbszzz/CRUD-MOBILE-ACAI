package com.example.acai.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BDControler {

    public  CriaBD banco;
    public SQLiteDatabase db;

    public BDControler(Context context){
        banco = new CriaBD(context);
    }

    //Método para inserir dados
    public String inserirDados(Integer tamanho, Integer quantidade, String preco, String acompanhamentos ){
        ContentValues valores;
        long result;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(banco.tamanho, tamanho);
        valores.put(banco.quantidade, quantidade);
        valores.put(banco.preco, preco);
        valores.put(banco.acompanhamento, acompanhamentos);

        result = db.insert(banco.tabela, null, valores);

        if (result==-1){
            return "Erro ao cadastar!";
        }else{
            return String.format("Item cadastrado %s", result);
        }
    }

    public Cursor listarDados(){
        Cursor cursor;
        String[] campos = {banco.ID, banco.quantidade, banco.tamanho, banco.preco, banco.acompanhamento};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.tabela, campos, null, null, null,null,null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregarCampos(int id){
        Cursor cursor;
        String[] campos = {banco.ID, banco.tamanho, banco.quantidade, banco.preco, banco.acompanhamento};
        String where = banco.ID+ "=" + id;
        db = banco.getReadableDatabase();

        cursor = db.query(banco.tabela, campos, where, null, null,null,null);

        if(cursor!=null){
            cursor.moveToFirst();
        }

        return cursor;

    }

    public void alterarProduto(int id, Integer tamanho, Integer quantidade, Double preco, String acompanhamento){

        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = banco.ID + "=" +id;

        valores = new ContentValues();
        valores.put(banco.tamanho, tamanho);
        valores.put(banco.quantidade, quantidade);
        valores.put(banco.preco, preco);
        valores.put(banco.acompanhamento, acompanhamento);

        db.update(banco.tabela, valores, where,null);
        db.close();


    }

    public void deletarProduto(int id){
        String where = banco.ID + "=" +id;

        db = banco.getReadableDatabase();
        db.delete(banco.tabela, where,null);
        db.close();
    }
}
