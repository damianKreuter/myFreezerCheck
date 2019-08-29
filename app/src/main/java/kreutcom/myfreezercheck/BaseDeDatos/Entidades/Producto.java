package kreutcom.myfreezercheck.BaseDeDatos.Entidades;

import kreutcom.myfreezercheck.BaseDeDatos.Entidades.General.Estados_y_tipos_general;

public class Producto extends Estados_y_tipos_general {
    private Integer tipo_producto;
    public Producto(Integer id, String descripcionTipo, Integer tipo) {
        super(id, descripcionTipo);
        tipo_producto = tipo;
    }

    public Integer getTipo_producto() {
        return tipo_producto;
    }
}
