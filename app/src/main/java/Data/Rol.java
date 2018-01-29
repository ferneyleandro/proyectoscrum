package Data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ESTACION on 22/01/2018.
 */

public class Rol implements Entidad {

    public int id_rol;
    public String nombre_rol;
    public boolean estado_rol;

    public Rol(String nombre_rol, boolean estado_rol) {

        this.nombre_rol = nombre_rol;
        this.estado_rol = estado_rol;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public boolean isEstado_rol() {
        return estado_rol;
    }

    public void setEstado_rol(boolean estado_rol) {
        this.estado_rol = estado_rol;
    }

    @Override
    public long nuevoRegistro(SQLiteDatabase db) {
        return db.insert(Scrumcontract.RolEntry.TABLE_NAME, null, toContentValues());
    }

    @Override
    public long ActualizarRegistro(SQLiteDatabase db) {
        return 0;
    }

    @Override
    public Cursor buscarRegistro(SQLiteDatabase db, int id) {
        return db.rawQuery("SELECT * FROM "
                +Scrumcontract.RolEntry.TABLE_NAME
                +" WHERE "
                +Scrumcontract.RolEntry.IDROL+" = "
                +id,null
        );
    }

    public  Cursor listarRol(SQLiteDatabase db){
        return db.rawQuery("SELECT * FROM "
            +Scrumcontract.RolEntry.TABLE_NAME, null
        );
    }

    @Override
    public Cursor listarRegistro(SQLiteDatabase db, int id) {

        return db.rawQuery("SELECT * FROM "
                +Scrumcontract.RolEntry.TABLE_NAME
                +" WHERE "
                +Scrumcontract.RolEntry.ESTADO_ROL+" = "
                +id,null
        );
    }

    @Override
    public long borrarRegistro(SQLiteDatabase db, int id) {
        return 0;
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues cv = new ContentValues();

        cv.put(Scrumcontract.RolEntry.NOMBRE_ROL, getNombre_rol());
        cv.put(Scrumcontract.RolEntry.ESTADO_ROL, isEstado_rol());

        return cv;
    }
}
