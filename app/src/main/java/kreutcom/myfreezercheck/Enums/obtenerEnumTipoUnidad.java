package kreutcom.myfreezercheck.Enums;

public class obtenerEnumTipoUnidad {
    public String obtenerTipoUnidadSegunEnum(int numero){
        switch (numero){
            case 0:
                return "kg";     //kg, gr, libra, onza, unidad, docena, litro, pack, galon
            case 1:
                return "gr";
            case 2:
                return "libra";
            case 3:
                return "onza";
            case 4:
                return "unidad";
            case 5:
                return "docena";
            case 6:
                return "litro";
            case 7:
                return "pack";
            case 8:
                return "galon";
                default:break;
        }
        return "Asd";
    }
}
