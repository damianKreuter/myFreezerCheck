package kreutcom.myfreezercheck.ListaDeCompras;

import android.icu.util.Calendar;

import java.nio.IntBuffer;
import java.util.Arrays;

import kreutcom.myfreezercheck.Enums.enum_tipoUnidad;
import kreutcom.myfreezercheck.Enums.obtenerEnumTipoUnidad;

public class claseElementoListaParaComprar {
    private String nombreProducto;
    private int numero;
    private int tipoUnidad; //UTILIZA LOS NÚMEROS DEL ENUM_TIPOUNIDAD

    public claseElementoListaParaComprar(String nombre, int numero, int tipoUnidad) {
        this.nombreProducto = nombre;
        this.numero = numero;
        this.tipoUnidad = tipoUnidad;
    }

    public String getNombreTipoUnidad(){
        obtenerEnumTipoUnidad tipoEnum = new obtenerEnumTipoUnidad();
        return tipoEnum.obtenerTipoUnidadSegunEnum(tipoUnidad);
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(int tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public void Modificar_de_a_1(double numero){
        this.numero += numero;
    }
}
