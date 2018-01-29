package com.seminario.appscrum;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Data.DataBase_OH;
import Data.Rol;

public class Roles extends AppCompatActivity implements View.OnClickListener {

    DataBase_OH helper = new DataBase_OH(this);
    ListView listv_rol;
    Button btn_crear_rol;
    String nombre_rol;
    Boolean estado_rol;
    Cursor resultado;
    ArrayList<String> listaRoles;
    ArrayAdapter<String> listaP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roles);

        Rol u = new Rol(nombre_rol,estado_rol);
        resultado = u.buscarRegistro(helper.getReadableDatabase(), Integer.parseInt(getIntent().getExtras().getString("id_rol")));

        listv_rol = (ListView)findViewById(R.id.listv_rol);

        listaRoles = new ArrayList<String>();
        while(resultado.moveToNext()){
            listaRoles.add(resultado.getString(1));
            Toast.makeText(this, "test "+resultado.getString(1), Toast.LENGTH_LONG).show();
        }

        listaP = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaRoles);
        listv_rol.setAdapter(listaP);

        btn_crear_rol = (Button) findViewById(R.id.btn_crear_rol);
        btn_crear_rol.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.equals(btn_crear_rol)){
            Intent intent = new Intent(this, Crear_rol.class);
            //intent.putExtra("id_usr", getIntent().getExtras().getString("id_usr"));
            startActivity(intent);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
