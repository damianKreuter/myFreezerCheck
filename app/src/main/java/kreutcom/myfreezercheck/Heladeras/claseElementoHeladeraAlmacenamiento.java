package kreutcom.myfreezercheck.Heladeras;

import android.icu.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class claseElementoHeladeraAlmacenamiento {
    private String nombre;
    private String currentTime;
    private String grupo;
    private long id;
    private SimpleDateFormat dateFormat;
    private int imagen;

    public claseElementoHeladeraAlmacenamiento(String nombre, String grupo, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.grupo = grupo;
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        this.id = crearNuevoID();

        this.currentTime = dateFormat.format(Calendar.getInstance().getTime()).toString();
    }

    private long crearNuevoID(){
        return 1;       //TEMPORAL, DESPUES CON FIREBASE DEBE ASIGNARLE 1 ID UNICO
    }

    public long getId() { return id; }

    public String getNombre() {
        return nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public int getImagen() {
        return imagen;
    }

    public void setCurrentTime(Calendar currentTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        this.currentTime = dateFormat.format(Calendar.getInstance().getTime()).toString();
    }

    public void setGrupo(String grupo) { this.grupo = grupo; }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}