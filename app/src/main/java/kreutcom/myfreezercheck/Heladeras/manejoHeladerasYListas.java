package kreutcom.myfreezercheck.Heladeras;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kreutcom.myfreezercheck.Heladeras.crearHeladera.crearHeladeraDialogFragment;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import kreutcom.myfreezercheck.R;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class manejoHeladerasYListas extends Fragment implements crearHeladeraDialogFragment.OnInputSelected,
        AdaptadorHeladeraRecycleView.OnAdaptadorHeladeraRecycler
{

    private ArrayList<claseElementoHeladeraAlmacenamiento> listaHeladeras;

    private RecyclerView reciclador;
    private FloatingActionButton botonCrearHeladera;
    private View.OnClickListener listener;
    protected NavController navController = null;


    @Override
    public void sendInput(String input, int tipo, String grupo) {
        //ENTRA INPUT
        listaHeladeras.add(new claseElementoHeladeraAlmacenamiento(input, "Hogar", tipo));

        AdaptadorHeladeraRecycleView adapHeladeras = new AdaptadorHeladeraRecycleView(getContext(), listaHeladeras,
                this);
        reciclador.setAdapter(adapHeladeras);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.heladera_y_listas_listas_heladeras, container, false);

        reciclador = view.findViewById(R.id.recyclerview_lista_heladeras_y_almacenes);
        botonCrearHeladera = view.findViewById(R.id.floatingActionButtonAgregarHeladera);

        botonCrearHeladera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ME CREA 1 DIALOGO ASÍ PARA CREAR 1 ALMACENAMIENTO
                //DESPUE DEBO CHEQUEAR SI EL GRUPO ES 1 POOL ENTONCES
                //DEBO LIMITARLO A 1 NUMERO MAXIMO SALVO QUE EL CREADOR
                //SEA PREMIUM

                //SI EL GRUPO ES INDIVIDUAL Y PARA SÍ MISMO PUEDE CREAR HASTA 6
                crearHeladeraDialogFragment dialogo = new crearHeladeraDialogFragment();
                dialogo.setTargetFragment(manejoHeladerasYListas.this, 1);
                dialogo.show(getFragmentManager(), "Mi dialogo para crear heladeras");


            }


        });

        reciclador.setLayoutManager(new LinearLayoutManager(getContext()));

        listaHeladeras = new ArrayList<>();
        listaHeladeras.add(new claseElementoHeladeraAlmacenamiento("Yoyo", "Hogar",3));
        listaHeladeras.add(new claseElementoHeladeraAlmacenamiento("kjh", "kk", 1));

        listaHeladeras.add(new claseElementoHeladeraAlmacenamiento("Hdera","Hogar", 2));
        listaHeladeras.add(new claseElementoHeladeraAlmacenamiento("xxxx","Hogar", 3));

        AdaptadorHeladeraRecycleView adapHeladeras = new AdaptadorHeladeraRecycleView(getContext(), listaHeladeras,
                this);
        reciclador.setAdapter(adapHeladeras);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(getActivity(), R.id.fragment_host);
  //      NavigationUI.setupActionBarWithNavController(this, navController, drawer);

     //   NavigationUI.setupWithNavController(navigationView, navController);
 //       navController = Navigation.findNavController(view);
    }

    @Override
    public void onElementoHeladeraClick(int posicion) {
        claseElementoHeladeraAlmacenamiento elemento = listaHeladeras.get(posicion);
   //     Toast.makeText(getContext(), "Clickié: " + elemento.getNombre(), Toast.LENGTH_SHORT).show();
        navController.navigate(R.id.action_manejoHeladerasYListas_to_listaDeCompraDe1Grupo);
    }
}