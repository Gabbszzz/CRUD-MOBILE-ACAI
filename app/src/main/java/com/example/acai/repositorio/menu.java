package com.example.acai.repositorio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.acai.R;

public class menu extends AppCompatActivity {

    Button cad, listar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        cad = findViewById(R.id.cad);
        listar = findViewById(R.id.listar);

        cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o = new Intent(menu.this,cadastrar.class);
                startActivity(o);
            }});

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(menu.this,listar.class);
                startActivity(i);
            }
        });
    }
}
