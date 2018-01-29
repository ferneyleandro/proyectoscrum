package com.seminario.appscrum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import java.util.StringJoiner;

import Data.DataBase_OH;
import Data.Rol;

public class Crear_rol extends AppCompatActivity implements View.OnClickListener {
    DataBase_OH helper = new DataBase_OH(this);

    EditText txt_new_rol;
    Switch swicht_active_rol;
    Button btn_new_rol;
    Button btn_return;

    String nombreRol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_rol);

        txt_new_rol = (EditText)findViewById(R.id.txt_new_rol);
        swicht_active_rol = (Switch)findViewById(R.id.swich_active_rol);
        btn_new_rol = (Button)findViewById(R.id.btn_new_rol);
        btn_return = (Button)findViewById(R.id.btn_return);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(btn_new_rol)){

            String name_rol = txt_new_rol.getText().toString();
            Boolean active = swicht_active_rol.getShowText();
            //int id_usurio = Integer.parseInt(getIntent().getExtras().getString("id_usr"));

            Rol u = new Rol(name_rol, active);
            u.nuevoRegistro(helper.getWritableDatabase());

            Intent intent = new Intent(this, Rol.class);
            intent.putExtra("id_usr", getIntent().getExtras().getString("id_usr"));
            startActivity(intent);
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
