package kreutcom.myfreezercheck.BaseDeDatos.Entidades.General;

public class Tipos_con_imagen_generales extends Estados_y_tipos_general{
    private Integer imagen;

    public Tipos_con_imagen_generales(Integer id, String descripcionTipo, Integer imagen) {
        super(id, descripcionTipo);
        this.imagen = imagen;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }
}
