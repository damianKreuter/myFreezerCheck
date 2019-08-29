package kreutcom.myfreezercheck.BaseDeDatos.Entidades.General;

public class Estados_y_tipos_general extends Entidad_general{
    private String descripcionTipo;

    public Estados_y_tipos_general(Integer id, String descripcionTipo) {
        super(id);
        this.descripcionTipo = descripcionTipo;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }
}
