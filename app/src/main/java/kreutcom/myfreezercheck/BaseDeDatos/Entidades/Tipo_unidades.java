package kreutcom.myfreezercheck.BaseDeDatos.Entidades;

import android.media.Image;

import kreutcom.myfreezercheck.BaseDeDatos.Entidades.General.Estados_y_tipos_general;

public class Tipo_unidades extends Estados_y_tipos_general {
    private String descripcion;

    public Tipo_unidades(Integer id, String descripcionTipo, String descripcion) {
        super(id, descripcionTipo);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
