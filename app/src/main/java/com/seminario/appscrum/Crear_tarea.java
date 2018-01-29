package com.seminario.appscrum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import Data.DataBase_OH;

public class Crear_tarea extends AppCompatActivity implements View.OnClickListener {
    DataBase_OH helper = new DataBase_OH(this);

    EditText txt_title_tarea;
    EditText txt_desc_tarea;
    Spinner spinner_estado_tarea;
    EditText fecha_creacion;
    EditText fecha_crea;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_tarea);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
