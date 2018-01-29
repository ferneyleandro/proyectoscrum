package com.seminario.appscrum;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import Data.DataBase_OH;
import Data.Rol;

public class Roles extends AppCompatActivity implements View.OnClickListener {
    DataBase_OH helper = new DataBase_OH(this);

    String nombre_rol;
    boolean estado_rol;
    Cursor resultado;
    Button btn_crear_rol;
    ListView listv_rol;

    ArrayList<String> listaRol;
    ArrayAdapter<String> listaR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roles);

        listv_rol = (ListView)findViewById(R.id.listv_rol);
        btn_crear_rol = (Button)findViewById(R.id.btn_crear_rol);
        btn_crear_rol.setOnClickListener(this);

        Rol u = new Rol(nombre_rol, estado_rol);
        resultado = u.listarRol(helper.getReadableDatabase());

        listaRol = new ArrayList<String>();

        while(resultado.moveToNext()){
            listaRol.add(resultado.getString(1));
        }

        listaR = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaRol);
        listaR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listv_rol.setAdapter(listaR);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(btn_crear_rol)){
            Intent intent = new Intent(this, Crear_rol.class);
            intent.putExtra("id_usr", getIntent().getExtras().getString("id_usr"));
            startActivity(intent);
        }
    }
}
