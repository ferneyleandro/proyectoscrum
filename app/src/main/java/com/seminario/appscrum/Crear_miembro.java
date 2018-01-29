package com.seminario.appscrum;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Data.DataBase_OH;
import Data.Miembros;
import Data.Rol;

public class Crear_miembro extends AppCompatActivity implements OnClickListener {
    DataBase_OH helper = new DataBase_OH(this);

    EditText txt_name_miembro;
    Spinner spiner_rol;
    Button btn_new_miembro;
    Button btn_return_miembro;

    String nombre_rol_t;
    boolean estado_rol_t;
    int cont = 0;
    String cod_rol;


    Cursor resultado;
    HashMap<Integer,String> arrayRol;
    List<String> ls_roles;
    ArrayAdapter<String> combo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_miembro);



        Rol u = new Rol(nombre_rol_t, estado_rol_t);
        resultado = u.listarRegistro(helper.getReadableDatabase(), 1);

        ls_roles = new ArrayList<String>();
        arrayRol = new HashMap<Integer, String>();

        while(resultado.moveToNext()){
            arrayRol.put(cont, resultado.getString(0));
            ls_roles.add(resultado.getString(1));
            cont++;
        }
        

        combo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ls_roles);
        combo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner_rol.setAdapter(combo);

        btn_new_miembro.setOnClickListener(this);
        btn_return_miembro.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.equals(btn_new_miembro)){

            cod_rol = arrayRol.get(spiner_rol.getSelectedItemPosition());
            String name_miembro = txt_name_miembro.getText().toString();

            //como sacar de aqui el codigo del rol?
            Miembros u = new Miembros(name_miembro, 1);
            u.nuevoRegistro(helper.getWritableDatabase());

            Intent intent = new Intent(this, Proyectos.class);
            startActivity(intent);
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
