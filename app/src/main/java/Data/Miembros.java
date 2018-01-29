package Data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ESTACION on 22/01/2018.
 */

public class Miembros implements Entidad {

    private int id_miembros;
    private String nombre_miembro;
    private int rol_idrol;

    public void setId_miembros(int id_miembros) {
        this.id_miembros = id_miembros;
    }

    public Miembros(String nombre_miembro, int rol_idrol) {
        //this.id_miembros = id_miembros;
        this.nombre_miembro = nombre_miembro;
        this.rol_idrol = rol_idrol;

    }

    public int getId_miembros() {
        return id_miembros;
    }

    public String getNombre_miembro() {
        return nombre_miembro;
    }

    public void setNombre_miembro(String nombre_miembro) {
        this.nombre_miembro = nombre_miembro;
    }

    public int getRol_idrol() {
        return rol_idrol;
    }

    public void setRol_idrol(int rol_idrol) {
        this.rol_idrol = rol_idrol;
    }


    @Override
    public long nuevoRegistro(SQLiteDatabase db) {
        return 0;
    }

    @Override
    public long ActualizarRegistro(SQLiteDatabase db) {
        return 0;
    }

    @Override
    public Cursor buscarRegistro(SQLiteDatabase db, int id) {
        return db.rawQuery("SELECT * FROM "
                +Scrumcontract.MiembrosEntry.TABLE_NAME
                +" WHERE "
                +Scrumcontract.MiembrosEntry.ROL_ID+" = "
                +id,null
        );
    }

    @Override
    public Cursor listarRegistro(SQLiteDatabase db, int id) {
        return null;
    }

    @Override
    public long borrarRegistro(SQLiteDatabase db, int id) {
        return 0;
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues cv = new ContentValues();

        cv.put(Scrumcontract.MiembrosEntry.NOMBRE_MIEMBRO, getNombre_miembro());
        cv.put(Scrumcontract.MiembrosEntry.ROL_ID, getRol_idrol());

        return cv;
    }
}
