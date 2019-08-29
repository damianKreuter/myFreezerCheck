package kreutcom.myfreezercheck.BaseDeDatos.Utilidades;

public class Utilidades {

    //Constantes campos tabla usuario
    public static final String TABLA_USER="usuario";
    public static final String USER_ID="id_user";
    public static final String USER_NOMBRE="nombre_user";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            ""+TABLA_USER+" ("+USER_ID+" " +
            "INTEGER, "+USER_NOMBRE+" TEXT)";

    //Constantes campos tabla mascota
    public static final String TABLA_GRUPO="grupo";
    public static final String GRUPO_ID="id_GRUPO";
    public static final String GRUPO_NOMBRE="nombre_grupo";

    public static final String CREAR_TABLA_MASCOTA="CREATE TABLE " +
            ""+TABLA_GRUPO+" ("+GRUPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +GRUPO_NOMBRE+" TEXT)";

    public static final String TABLA_ALMACEN="almacen";
    public static final String ALMACEN_GRUPO="grupo_almacen";
    public static final String ALMACEN_ID="id_almacen";
    public static final String ALMACEN_TIPO="tipo_almacen";


}
