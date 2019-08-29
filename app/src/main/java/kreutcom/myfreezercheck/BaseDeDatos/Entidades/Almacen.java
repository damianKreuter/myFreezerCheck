package kreutcom.myfreezercheck.BaseDeDatos.Entidades;

public class Almacen {
    private Integer id_almacen;
    private String nombre_almacen;
    private Integer tipo_almacen;

    public Almacen(String nombre_almacen, Integer tipo_almacen) {
        this.nombre_almacen = nombre_almacen;
        this.tipo_almacen = tipo_almacen;
    }

    public String getNombre_almacen() {
        return nombre_almacen;
    }

    public void setNombre_almacen(String nombre_almacen) {
        this.nombre_almacen = nombre_almacen;
    }

    public Integer getTipo_almacen() {
        return tipo_almacen;
    }

    public void setTipo_almacen(Integer tipo_almacen) {
        this.tipo_almacen = tipo_almacen;
    }

    public Integer getId_almacen() {
        return id_almacen;
    }
}
