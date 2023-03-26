package com.example.acai.repositorio;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.acai.R;
import com.example.acai.bd.BDControler;
import com.example.acai.bd.CriaBD;

public class atualizar extends AppCompatActivity {

    EditText txtTam,txtQtd, txtAcom, txtPreco;
    Button atualizar, deletar;
    String id;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atualizar);

        txtTam = findViewById(R.id.txtTam);
        txtQtd = findViewById(R.id.txtQtd);
        txtAcom = findViewById(R.id.txtAcom);
        txtPreco = findViewById(R.id.txtPreco);
        atualizar = findViewById(R.id.btnatualizar);
        deletar = findViewById(R.id.btndeletar);

        id = this.getIntent().getStringExtra("codigo");

        BDControler controlador = new BDControler(com.example.acai.repositorio.atualizar.this);
        cursor = controlador.carregarCampos(Integer.parseInt(id));

        CriaBD banco = new CriaBD(com.example.acai.repositorio.atualizar.this);

        txtTam.setText(cursor.getString(cursor.getColumnIndexOrThrow(banco.tamanho)));
        txtQtd.setText(cursor.getString(cursor.getColumnIndexOrThrow(banco.quantidade)));
        txtAcom.setText(cursor.getString(cursor.getColumnIndexOrThrow(banco.acompanhamento)));
        txtPreco.setText(cursor.getString(cursor.getColumnIndexOrThrow(banco.preco)));

        atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controlador.alterarProduto(Integer.parseInt(id),Integer.parseInt(String.valueOf(txtTam.getText())),Integer.parseInt(String.valueOf(txtQtd.getText())),
                        Double.parseDouble(String.valueOf(txtPreco.getText())), String.valueOf(txtAcom.getText()));
                Intent intent = new Intent(com.example.acai.repositorio.atualizar.this,listar.class);
                startActivity(intent);
                finish();
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controlador.deletarProduto(Integer.parseInt(id));
                Intent intent = new Intent(com.example.acai.repositorio.atualizar.this, listar.class);
                startActivity(intent);
            }
        });

    }
}