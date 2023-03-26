package com.example.acai.repositorio;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.acai.R;
import com.example.acai.bd.BDControler;

public class cadastrar extends AppCompatActivity {


    EditText txtTam, txtQtd, txtAcom, txtPreco;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar);


        txtTam = findViewById(R.id.txtTam);
        txtQtd = findViewById(R.id.txtQtd);
        txtAcom = findViewById(R.id.txtAcom);
        txtPreco = findViewById(R.id.txtPreco);

        but = findViewById(R.id.but);


//Evento para cadastar os produtos
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    BDControler controlador = new BDControler(cadastrar.this);
                    controlador.inserirDados(Integer.parseInt(String.valueOf(txtTam.getText())),Integer.parseInt(String.valueOf(txtPreco.getText())),
                            String.valueOf(txtQtd.getText()),String.valueOf(txtAcom.getText()));

                }catch (Exception e){
                    Toast.makeText(cadastrar.this, "Açaí cadastrado", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}