package kreutcom.myfreezercheck.BaseDeDatos.Entidades.General;

public class Entidad_general {
    protected Integer id;

    public Entidad_general(Integer id) {
        this.id = id;
    }

    protected Integer getId() {
        return id;
    }

    protected Integer obtenerNuevoID(String tipoTabla){
        //LUEGO REVISARLO CUANDO SE IMPLEMENTA BIEN EN LOCAL
        return 1;
    }
}
