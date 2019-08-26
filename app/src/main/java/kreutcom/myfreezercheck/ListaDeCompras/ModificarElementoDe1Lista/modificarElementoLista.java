package kreutcom.myfreezercheck.ListaDeCompras.ModificarElementoDe1Lista;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Arrays;

import kreutcom.myfreezercheck.Enums.enum_tipoUnidad;
import kreutcom.myfreezercheck.R;
import kreutcom.myfreezercheck.bibliotecaGeneral.Biblioteca;
import kreutcom.myfreezercheck.bibliotecaGeneral.MyOwnNumerPicker;

public class modificarElementoLista extends DialogFragment {

    private static final String TAG = "MyCustomDialog";

    public interface creacionOModificacionDeNuevoElemento{
        void pasar_datos_modificados(String nombreElemento, int cantidad, int tipoUnidad, int posicionOriginal);
    }

    public modificarElementoLista.creacionOModificacionDeNuevoElemento mOnInputSelected;

    //widgets
    private EditText nombreArticulo;

    private Spinner spinnerTipos;

    private int posicionDeElementoSiHay;
    private Button volver, crear_modificar;

    private int tipoUnidadADevolver;

    private String tipoUnidad;

    private MyOwnNumerPicker numberPicker;
    private  NumberPicker tipoUnidad_picker;

    private static final int size = enum_tipoUnidad.values().length-1;

    public static String[] nombreDeEnumTipoUnidad() {
        return Arrays.toString(enum_tipoUnidad.values()).replaceAll("^.|.$", "").split(", ");
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogo_modificar_elemento_lista_template, container, false);


        //SET UP, OBTENGO TODOS LOS REFERIDOS DE LA VIEW
        volver= view.findViewById(R.id.dialogo_modificar_crear_1_alimento_volver);
        crear_modificar= view.findViewById(R.id.dialogo_modificar_crear_1_alimento_accion);

        numberPicker = view.findViewById(R.id.num_pucker_dialogo_crear_modificar_elemento);

        nombreArticulo = view.findViewById(R.id.dialogo_modificar_crear_1_elemento_nombre_alimento);
        tipoUnidad_picker = view.findViewById(R.id.tipo_unidad_picker_dialogo_crear_modificar_elemento);

        tipoUnidad_picker.setMinValue(0);
        tipoUnidad_picker.setMaxValue(size);
        tipoUnidad_picker.setDisplayedValues(nombreDeEnumTipoUnidad());

/*
        ArrayAdapter<CharSequence> adaptadorTipos = ArrayAdapter.createFromResource(
                getContext(), R.array.combo_tipo_medida_cantidad_alimentos, R.layout.support_simple_spinner_dropdown_item);

        spinnerTipos.setAdapter(adaptadorTipos);
*/
        //    spinnerGrupos = view.findViewById(R.id.spinnerGrupoCrearHeladera);

        //PONGO LOS VALORES QUE TENGO YA

        Bundle bundle = getArguments();
        Log.e("Datos obtenidos:", bundle.getInt("posicion") + " " + bundle.getString("nombre")
                + " "+ bundle.getInt("numero") + " " + bundle.getString("tipoUnidad"));

        posicionDeElementoSiHay = bundle.getInt("posicion");

        numberPicker.setValue(bundle.getInt("numero"));
        tipoUnidad = bundle.getString("tipoUnidad");
        nombreArticulo.setText(bundle.getString("nombre"));

        tipoUnidadADevolver =-1;

        crear_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Biblioteca biblioteca = new Biblioteca();
                String nom = nombreArticulo.getText().toString();
                if(biblioteca.noEsStringVacio(nom)) {
                    mOnInputSelected.pasar_datos_modificados(nom, numberPicker.getValue(), tipoUnidad_picker.getValue(), posicionDeElementoSiHay);
                    getDialog().dismiss();
                } else {
                    nombreArticulo.setBackgroundColor(Color.RED);
                }
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
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
            mOnInputSelected = (modificarElementoLista.creacionOModificacionDeNuevoElemento) getTargetFragment();
        }catch (ClassCastException e){
            Log.e(TAG, "onAttach: ClassCastException : " + e.getMessage() );
        }
    }

}
