package kreutcom.myfreezercheck.BaseDeDatos.Entidades;

import java.io.Serializable;
import java.net.PasswordAuthentication;

import kreutcom.myfreezercheck.BaseDeDatos.Entidades.General.Tipos_con_imagen_generales;

public class User extends Tipos_con_imagen_generales implements Serializable  {

    private Integer id_user;
    private String nombre_user;
    private String passwordAuthentication;
    //TENGO QUE ENCRIPTARLA LUEGO PARA EVITAR QUE ROBEN DATOS LOS JOPUTAS


    public User(Integer id, String nombre_user, Integer imagen, String passwordAuthentication) {
        super(id, nombre_user, imagen);
    }

    public Integer getId_user() {
        return id_user;
    }

    public String getNombre_user() {
        return nombre_user;
    }

    public String getPasswordAuthentication() {
        return passwordAuthentication;
    }

    public void setPasswordAuthentication(String passwordAuthentication) {
        this.passwordAuthentication = passwordAuthentication;
    }

    public Boolean cambiarContraseña(String viejaContra, String nuevaContra){
        if(viejaContra.equals(passwordAuthentication)){
            setPasswordAuthentication(nuevaContra);
            return true;
        }
        return false;
    }
}
