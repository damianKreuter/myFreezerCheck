package kreutcom.myfreezercheck.bibliotecaGeneral;

import android.util.Log;

public class Biblioteca {
    public String obtenerPrimerSubstring(String s){
        int i, size = s.length();

        for(i = 0; i < size ; i++){
            if(s.charAt(i) == ' '){
                //HAY ESPACIO Y POR LO TANTO ES EL MAXIMO A DONDE DEBO LLEGAR
                return s.substring(0, i);
            }
        }
        //LO DEVUELVO COMO ESTABA PERO SIN ESPACIOS
        return s.trim();
    }

    public String obtenerUltimoSubstring(String s){
        int i, size = s.length(), ultimo = 0;

        for(i = 0; i < size ; i++){
            if(s.charAt(i) == ' '){
                //HAY ESPACIO Y POR LO TANTO DEBO TENERLO EN CUENTA
                ultimo = i+1;
            }
        }
        return s.substring(ultimo, size).trim();
    }

    public Boolean noEsStringVacio(String nombre){
        return !nombre.isEmpty();
    }
}
