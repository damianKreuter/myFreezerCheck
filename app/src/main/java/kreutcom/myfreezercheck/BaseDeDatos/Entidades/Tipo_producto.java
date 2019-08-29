package kreutcom.myfreezercheck.BaseDeDatos.Entidades;

import kreutcom.myfreezercheck.BaseDeDatos.Entidades.General.Entidad_general;
import kreutcom.myfreezercheck.BaseDeDatos.Entidades.General.Estados_y_tipos_general;
import kreutcom.myfreezercheck.BaseDeDatos.Entidades.General.Tipos_con_imagen_generales;

public class Tipo_producto extends Tipos_con_imagen_generales {

    public Tipo_producto(Integer id, String descripcionTipo, Integer imagen) {
        super(id, descripcionTipo, imagen);
    }

}
