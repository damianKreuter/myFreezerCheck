package kreutcom.myfreezercheck.ListaDeCompras.crearLista;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import kreutcom.myfreezercheck.Heladeras.crearHeladera.crearHeladeraDialogFragment;
import kreutcom.myfreezercheck.R;

public class dialogo_crear_lista_para_eliminar_toda_la_lista extends DialogFragment {

    private TextView elimnar;
    private TextView noEliminar;

    public interface interfazEliminarTodaLaLista{
        void elimnarLista();
    }
    public interfazEliminarTodaLaLista mOnInputSelected;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_para_comprar_de_1_grupo_eliminar_toda_la_lista, container, false);

        elimnar = view.findViewById(R.id.dialogo_lista_para_comprar_general_eliminar_todo);
        noEliminar = view.findViewById(R.id.dialogo_lista_para_comprar_general_no_eliminar);

        elimnar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SE ENVIA LA SOLICITUD PARA ELIMINAR TODA LA LISTA, HABIERNDO AVISADO PREVIAMENTE AL USUARIO
                mOnInputSelected.elimnarLista();

                getDialog().dismiss();
            }
        });
        noEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mOnInputSelected = (interfazEliminarTodaLaLista) getTargetFragment();
        }catch (ClassCastException e){
            Log.e("taf", "onAttach: ClassCastException : " + e.getMessage() );
        }
    }


}
