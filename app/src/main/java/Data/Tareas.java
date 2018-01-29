package Data;

import java.util.Date;

/**
 * Created by ESTACION on 22/01/2018.
 */

public class Tareas {

    private int id_tareas;
    private String titulo;
    private String descripcion;
    private int estado_idestado;
    private Date fecha_creaciont;
    private Date fecha_entregat;
    private Date fecha_cierre;
    private int proyecto_idproyecto;
    private int miembros_idmiembros;

    public int getId_tareas() {
        return id_tareas;
    }

    public void setId_tareas(int id_tareas) {
        this.id_tareas = id_tareas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado_idestado() {
        return estado_idestado;
    }

    public void setEstado_idestado(int estado_idestado) {
        this.estado_idestado = estado_idestado;
    }

    public Date getFecha_creaciont() {
        return fecha_creaciont;
    }

    public void setFecha_creaciont(Date fecha_creaciont) {
        this.fecha_creaciont = fecha_creaciont;
    }

    public Date getFecha_entregat() {
        return fecha_entregat;
    }

    public void setFecha_entregat(Date fecha_entregat) {
        this.fecha_entregat = fecha_entregat;
    }

    public Date getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(Date fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public int getProyecto_idproyecto() {
        return proyecto_idproyecto;
    }

    public void setProyecto_idproyecto(int proyecto_idproyecto) {
        this.proyecto_idproyecto = proyecto_idproyecto;
    }

    public int getMiembros_idmiembros() {
        return miembros_idmiembros;
    }

    public void setMiembros_idmiembros(int miembros_idmiembros) {
        this.miembros_idmiembros = miembros_idmiembros;
    }

    public Tareas(int id_tareas, String titulo, String descripcion, int estado_idestado, Date fecha_creaciont, Date fecha_entregat, Date fecha_cierre, int proyecto_idproyecto, int miembros_idmiembros) {
        this.id_tareas = id_tareas;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado_idestado = estado_idestado;
        this.fecha_creaciont = fecha_creaciont;
        this.fecha_entregat = fecha_entregat;
        this.fecha_cierre = fecha_cierre;
        this.proyecto_idproyecto = proyecto_idproyecto;
        this.miembros_idmiembros = miembros_idmiembros;
    }
}
