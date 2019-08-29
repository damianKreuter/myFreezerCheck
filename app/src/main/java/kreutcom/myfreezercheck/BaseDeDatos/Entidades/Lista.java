package kreutcom.myfreezercheck.BaseDeDatos.Entidades;

import java.util.ArrayList;
import java.util.Date;

import kreutcom.myfreezercheck.BaseDeDatos.Entidades.General.Entidad_general;
import kreutcom.myfreezercheck.BaseDeDatos.Entidades.General.Estados_y_tipos_general;

public class Lista extends Entidad_general {

    private ArrayList<Producto> productos;
    private String nombreGrupo;
    private Date ultimaActualizacion;

    public Lista(Integer id, String nombreGrupo, ArrayList<Producto> productos, Date ultimaActualizacion) {
        super(id);
        this.nombreGrupo = nombreGrupo;
        this.productos = productos;
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public Date getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void setUltimaActualizacion(Date ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }
}
