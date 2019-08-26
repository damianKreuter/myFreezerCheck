package kreutcom.myfreezercheck.ListaDeCompras.crearLista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kreutcom.myfreezercheck.ListaDeCompras.AdaptadorListaCompraDe1Grupo;
import kreutcom.myfreezercheck.ListaDeCompras.claseElementoListaParaComprar;
import kreutcom.myfreezercheck.ListaDeCompras.listaDeCompraDe1Grupo;
import kreutcom.myfreezercheck.R;

public class crear_o_armar_lista extends Fragment {

    public void sendInput(String nombreProducto, int cantidad, int descripcion) {
        //ENTRA INPUT
        lista.add(new claseElementoListaParaComprar(nombreProducto, cantidad, descripcion));

   //     AdaptadorListaCompraDe1Grupo adapHeladeras = new AdaptadorListaCompraDe1Grupo(getContext(), lista, this);
   //     reciclador.setAdapter(adapHeladeras);
    }

    ArrayList<claseElementoListaParaComprar> lista;

    RecyclerView reciclador;
    TextView botonCrearOAniadirLista, botonEliminarTodaLaLista;
    TextView crearOActualizarEsto;
    TextView tituloAPoner, grupoPerteneciente;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_para_comprar_de_1_heladera, container, false);

        reciclador = view.findViewById(R.id.recycler_view_lista_compra);
        grupoPerteneciente = view.findViewById(R.id.listaDeCompra_creacion_oactualizacion_de_lista_nombreGrupo);

        tituloAPoner = view.findViewById(R.id.lista_para_comprar_crear_o_actualizar_lista_nombre_titulo);
        crearOActualizarEsto = view.findViewById(R.id.listaDeCompraRealizarCompra_crear_o_actualizar);
        botonCrearOAniadirLista = view.findViewById(R.id.listaDeCompraRealizarCompra_aniadir_elemento);
        botonEliminarTodaLaLista = view.findViewById(R.id.listaDeCompraRealizarCompra_limpiar_lista);

        //DISCLAMER
        //Cuando se entra aquí, se debe revisar si es 1 creacion o actualización para camibar TITULOAPONER

        crearOActualizarEsto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*2 CASOS
                //CASO CREAR
                //      -CREAR LA LISTA Y MANDARLA AL SERVIDOR
                //      -ENVIAR 1 NOTIFICACIÓN A CADA MIEMBRO DEL GRUPO QUE SE DESCARGARA NUEVO CONTENIDO EXCEPTO EL DUEÑO
                //CASO ACTUALIZAR
                //      -ACTUALIZAR EN EL LOCAL LOS DATOS
                        -REVISAR SI HAY MERGEO (SI EXISTE SE DETIENE LA OPERACION, VOLVIENDO ATRAS PARA QUE DESCARGUE
                            Y 1 VEZ DESCARGADO SE VUELVE A EMPEZAR
                        -SUBIR LA ACTUALIZACION
                        -SEGUIR EL ULTIMO PASO DE CREAR
                */


            }
        });

        botonCrearOAniadirLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   crearHeladeraDialogFragment dialogo = new crearHeladeraDialogFragment();
                dialogo.setTargetFragment(kreutcom.myfreezercheck.Heladeras.manejoHeladerasYListas.this, 1);
                dialogo.show(getFragmentManager(), "Mi dialogo para crear heladeras");
                */
            }
        });
        botonEliminarTodaLaLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo_crear_lista_para_eliminar_toda_la_lista dialogo = new dialogo_crear_lista_para_eliminar_toda_la_lista();
                dialogo.setTargetFragment(crear_o_armar_lista.this, 1);
                dialogo.show(getFragmentManager(), "Mi dialogo para norrar lista");
             /*   crearHeladeraDialogFragment dialogo = new crearHeladeraDialogFragment();
                dialogo.setTargetFragment(kreutcom.myfreezercheck.Heladeras.manejoHeladerasYListas.this, 1);
                dialogo.show(getFragmentManager(), "Mi dialogo para crear heladeras");
                */
            }
        });
/*
        botonCrearHeladera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearHeladeraDialogFragment dialogo = new crearHeladeraDialogFragment();
                dialogo.setTargetFragment(kreutcom.myfreezercheck.Heladeras.manejoHeladerasYListas.this, 1);
                dialogo.show(getFragmentManager(), "Mi dialogo para crear heladeras");


            }


        });
*/
        reciclador.setLayoutManager(new LinearLayoutManager(getContext()));
        lista = new ArrayList<>();
        lista.add(new claseElementoListaParaComprar("Leche", 50, 0));
        lista.add(new claseElementoListaParaComprar("ASD", 2, 5));

        lista.add(new claseElementoListaParaComprar("Hdera", 10, 3));
        lista.add(new claseElementoListaParaComprar("Haberlos", 3, 2));


        //       AdaptadorListaCompraDe1Grupo adapHeladeras = new AdaptadorListaCompraDe1Grupo(getContext(), lista, this);
  //      reciclador.setAdapter(adapHeladeras);
        return view;
    }

    private void levantarDialogoCreacionHeladeras() {

    }

}
