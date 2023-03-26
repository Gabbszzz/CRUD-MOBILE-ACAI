package com.example.acai.repositorio;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.acai.R;
import com.example.acai.bd.BDControler;
import com.example.acai.bd.CriaBD;

public class listar extends AppCompatActivity {


    ListView lista;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar);
        lista = findViewById(R.id.list);



        BDControler controlador = new BDControler(listar.this);

       Cursor cursor = controlador.listarDados();
       CriaBD banco = new CriaBD(listar.this);

        String[] campos = new String[]{banco.ID,banco.tamanho,banco.quantidade, banco.preco, banco.acompanhamento};
        int[] idviews = new int[]{R.id.id,R.id.txtTam,R.id.txtQtd, R.id.txtPreco, R.id.textAcom};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(listar.this, R.layout.item, cursor, campos, idviews);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String id;
                cursor.moveToPosition(i);
                id = cursor.getString(cursor.getColumnIndexOrThrow(banco.ID));
                Intent intent = new Intent(listar.this, atualizar.class);
                intent.putExtra("codigo", id);
                startActivity(intent);
            }
        });

    }
}