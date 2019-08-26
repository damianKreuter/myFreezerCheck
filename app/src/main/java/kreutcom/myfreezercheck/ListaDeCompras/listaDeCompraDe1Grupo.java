package kreutcom.myfreezercheck.ListaDeCompras;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kreutcom.myfreezercheck.ListaDeCompras.crearLista.dialogo_crear_lista_para_eliminar_toda_la_lista;
import kreutcom.myfreezercheck.ListaDeCompras.ModificarElementoDe1Lista.modificarElementoLista;
import kreutcom.myfreezercheck.bibliotecaGeneral.Biblioteca;
import kreutcom.myfreezercheck.R;

public class listaDeCompraDe1Grupo extends Fragment implements dialogo_crear_lista_para_eliminar_toda_la_lista.interfazEliminarTodaLaLista,
        AdaptadorListaCompraDe1Grupo.OnAdaptadorDeListaAHacerClick, modificarElementoLista.creacionOModificacionDeNuevoElemento
{
    ArrayList<claseElementoListaParaComprar> lista;

    RecyclerView reciclador;
    ImageButton botonCrearOAniadirLista, botonEliminarTodaLaLista;
    TextView textoRealizaLaLista, listaDeCompraNombreGrupo, descripcionDelObjeto;

    AdaptadorListaCompraDe1Grupo adapHeladeras;

    private String nombreGrupo, ultimaFechaDeCambio;
    private Long id;
    private Boolean huboCambios;


    @Override
    public void pasar_datos_modificados(String nombreElemento, int cantidad, int tipoUnidad, int posicionOriginal) {
        if(posicionOriginal!=-1){
            //EXISTE LA POSICION EN LA LISTA YA MENCIONADA
            claseElementoListaParaComprar elemento = obtenerElementoDeLaLista(posicionOriginal);
            elemento.setNumero(cantidad);
            elemento.setTipoUnidad(tipoUnidad);
            elemento.setNombreProducto(nombreElemento);
        } else {
            //SE CREA 1 NUEVO ELEMENTO A LA LISTA AUNQUE DEBERIA CHEQUEAR SI YA EXISTE EL ELEMENTO
            // ASÍ EN EL CASO DE QUE SI COMPARTEN EL MISMO TIPO DE UNIDAD SOLO SUMO LA CANTIDAD NUEVA
            // CON LA YA EXISTENTE. SINO SE LA CREA APARTE POR INCOMPATIBILIDAD DE TIPOUNIDAD
            lista.add(new claseElementoListaParaComprar(nombreElemento, cantidad, tipoUnidad));
        }
        hayCambiosEnLaLista(true);
        reiniciarLista();
    }

    @Override
    public void onSumarORestar1NumeroClick(Boolean esSuma, int posicion){
        claseElementoListaParaComprar elemento = lista.get(posicion);
        if(esSuma) {
            elemento.Modificar_de_a_1(1);
        } else {
            elemento.Modificar_de_a_1(-1);
        }
        hayCambiosEnLaLista(true);
        reiniciarLista();
    }

    @Override
    public void onElementoListaNumeroClick(int posicion) {
        //CLICKEO 1 ELEMENTO Y DEBE ABRIR 1 DIALOGO PARA QUE SE PUEDA MODIFICAR PERO NO ELIMINAR EL CONTENIDO

        //SEGUN EL CRITERIO DEBO PONER COMO SE MODIFICARIAN
        modificarElementoLista dialogo = crearDialogoParaModificarNumeroDe1Elemento(lista, posicion);
        dialogo.setTargetFragment(listaDeCompraDe1Grupo.this, 1);
        dialogo.show(getFragmentManager(), "Mi dialogo para modificar elemento de 1 lista");
    }

    public static modificarElementoLista crearDialogoParaModificarNumeroDe1Elemento(
                                                                        ArrayList<claseElementoListaParaComprar> lista, int posicion) {
        modificarElementoLista f = new modificarElementoLista();
        // Supply num input as an argument.
        Bundle bundle = new Bundle();
        bundle.putString("nombre", lista.get(posicion).getNombreProducto());
        bundle.putInt("posicion", posicion);
        bundle.putInt("numero", lista.get(posicion).getNumero());
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void elimnarLista() {
        //PROCEDO A ELIMINAR TODA LA LISTA

        //PARA EVITAR BARDO, EN 1 FUTURO 1 LISTA ELIMINADA ENVIARÁ 1 NOTIFICACIÓN
        //Y HABRÁ 1 BASURERO DONDE SE ENCONTRARÁ PARA QUE SE PUEDA RESTAURAR, PASADO LOS 5 DÍAS
        //SE ELIMINA AUTOMÁTICAMENTE, AVISANDO QUE SE VA A ELIMINAR 1 DÍA ANTES

        //SE ELIMINA 1 ELEMENTO DE LA LISTA
        //AUNQUE SE DEBERÍA MANDAR TODA ESTA COSA AL BASURERO, GENERANDO 1 COPIA
        //E INDICANDO EL USUARIO QUE LA ELIMINÓ
        lista.removeAll(lista);
        hayCambiosEnLaLista(true);
        reiniciarLista();
    }

    private void reiniciarLista(){
        adapHeladeras.actualizarDatos(lista);
        reciclador.setAdapter(adapHeladeras);

        /*A PARTIR DE AQUI SE DARÁ NO SE COMMITEARÁ LOS CAMBISO HASTA QUE EL SUJETO NO APRETE EL BOTON
        *   DE ACEPTAR CAMBIOS. UNA VEZ APRETADO SE COMITEARÁ TANTO A LA DB LOCAL COMO FIREBASE.
        */


    }

    private void hayCambiosEnLaLista(Boolean hayCambio){
        huboCambios = true;

        //TEXTO
        textoRealizaLaLista.setText("Confirmar cambios");
        //IMPORTANTE, SI SOLO CONFIRMA SE DEBERÍA ACTIVAR 1 ALERT DIALOG PARA DECIR QUE SE CONFIRMO
        //LA TRANSACCIÓN, CASO CONTRARIO SE DEBER´´IA ABRIR OTRA VENTANA
    }

    private void realizarCambiosEnLaLista(){
         /*
                    BUENO, si hubo cambios solo tengo que enviar la actualizacion
                     */
        //CASO GRUPO -> Solicita tener la ultima version de
        if(!esGrupoLocal(id)){
            //NO ES LOCAL
            //DEBO PEDIR A FIREBASE QUE ME DÉ LA ÚLTIMA ACTUALIZACION DE ESA LISTA Y MERGEARLA
        } else {
            //ES LOCAL, NO TIENE SENTIDO USAR FIREBASE AQUI
        }
        //AQUI DEBO ACTUALIZAR LA BASE DE DATOS
    }

    private void funcionesONCLICKListener(){

        textoRealizaLaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(huboCambios){
                    realizarCambiosEnLaLista();
                    textoRealizaLaLista.setText("Realizar compra");
                } else {
                    /*
                    ESTE CASO DEBO ENVIAR LA PETICIÓN A FIREBASE PARA QUE CAMBIE EL ESTADO DE LA LISA
                    ASI NADIE PUEDE CAMBIARLA MIENTRAS ESTÉ EN ESE ESTADO, AL FINALIZAR EL DÍA
                    (SI ES QUE NO LO HAN HECHO AÚN, ENVIO 1 NOTIFICACIÓN AL SUJETO QUE HIZO LA COMPRA
                    PARA QUE REGISTRE LO QUE COMPRO [PORQUE PUEDE SER QUE SE COMPRARON COSAS EXTRAS
                    O HAYAN COSAS FALTANTES ADEMÁS QUE DEBEN REGISTRAR LA FECHA DE VENCIMIENTO DE LOS
                    PRODUCTOS Y TAMBIÉN EL PRECIO DE ESTOS PARA EL CHEQUEO FINANCIERO MENSUAL (si que
                    quieren) El chequeo financiero no se subirá a Firebase por tema de privacidad, solo
                    se envia la información del total gastado para enviarse al resto, los cuales al bajarse
                    se guardarán en la base de datos local.
                     */
                    realizandoLaCompra();
                }
            }
        });

        botonEliminarTodaLaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DIALOGO, PARA PODER ELIMINAR 1 LISTA ENTERA, pasará a la Local DataBase para que
                //se pueda restaurar
                dialogo_crear_lista_para_eliminar_toda_la_lista dialogo = new dialogo_crear_lista_para_eliminar_toda_la_lista();
                dialogo.setTargetFragment(listaDeCompraDe1Grupo.this, 1);
                dialogo.show(getFragmentManager(), "Mi dialogo para norrar lista");

                //LUEGO HAY QUE PONER EN SQLITE
            }
        });
/*
        botonCrearOAniadirLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crear_o_armar_lista dialogo = new crear_o_armar_lista();

                //EMPIEZO A CREAR 1 LISTA O ACTUALIZARLA
            }
        });
*/

    }

    public void realizandoLaCompra() {
        return;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_para_comprar_de_1_heladera, container, false);

        reciclador = view.findViewById(R.id.recycler_view_lista_compra);

        textoRealizaLaLista = view.findViewById(R.id.listaDeCompraRealizarCompra);
        botonCrearOAniadirLista = view.findViewById(R.id.listaDeCompraImageButtonAniadir);
        botonEliminarTodaLaLista = view.findViewById(R.id.listaDeCompraImageEliminarLista);



        listaDeCompraNombreGrupo = view.findViewById(R.id.listaDeCompraNombreGrupo);

        listaDeCompraNombreGrupo.setText(nombreGrupo);

        funcionesONCLICKListener();

        reciclador.setLayoutManager(new LinearLayoutManager(getContext()));
        lista = new ArrayList<>();
        lista.add(new claseElementoListaParaComprar("Leche", 50, 0));
        lista.add(new claseElementoListaParaComprar("ASD", 2, 5));

        lista.add(new claseElementoListaParaComprar("Hdera", 10, 3));
        lista.add(new claseElementoListaParaComprar("Haberlos", 3, 2));

        adapHeladeras = new AdaptadorListaCompraDe1Grupo(getContext(), lista, this);
        reciclador.setAdapter(adapHeladeras);
        huboCambios = false;
        return view;
    }

    //ESTO DEBO PASARLO A 1 ABSTRACTO
    private boolean esGrupoLocal(Long id){
        //SI ES 0 ENTONCES ES LOCAL
        return id==0;
    }



    private claseElementoListaParaComprar obtenerElementoDeLaLista(int buscarEnPosicion){
        return lista.get(buscarEnPosicion);
    }


}
