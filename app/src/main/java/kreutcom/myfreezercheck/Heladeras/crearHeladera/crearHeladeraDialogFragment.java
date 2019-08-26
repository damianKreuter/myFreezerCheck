package kreutcom.myfreezercheck.Heladeras.crearHeladera;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import kreutcom.myfreezercheck.R;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class crearHeladeraDialogFragment extends DialogFragment {

    private static final String TAG = "MyCustomDialog";

    public interface OnInputSelected{
        void sendInput(String input, int tipo, String grupo);
    }
    public OnInputSelected mOnInputSelected;

    //widgets
    private EditText mInput;
    private TextView mActionOk;

    private Spinner spinnerTipos, spinnerGrupos;

    private String grupoSeleccionado;
    private int tipoSeleccionado;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crear_heladera_dialog, container, false);

        mActionOk = view.findViewById(R.id.dialog_crear_heladera_boton);
        mInput = view.findViewById(R.id.edit_text_crear_heladera_nombre_a_poner);
        spinnerTipos = view.findViewById(R.id.spinnerTipoCrearHeladera);
        spinnerGrupos = view.findViewById(R.id.spinnerGrupoCrearHeladera);
        ArrayAdapter<CharSequence> adaptadorTipos = ArrayAdapter.createFromResource(
                getContext(), R.array.combo_tipos, R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adaptadorGrupos = ArrayAdapter.createFromResource(
                getContext(), R.array.combo_grupos_disponibles, R.layout.support_simple_spinner_dropdown_item);

        spinnerTipos.setAdapter(adaptadorTipos);
        spinnerGrupos.setAdapter(adaptadorGrupos);
    //    spinnerGrupos = view.findViewById(R.id.spinnerGrupoCrearHeladera);

        spinnerTipos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoSeleccionado  = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tipoSeleccionado  = 0;
            }
        });

        spinnerGrupos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                grupoSeleccionado  = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                grupoSeleccionado  = parent.getItemAtPosition(0).toString();
            }
        });

        mActionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = mInput.getText().toString();
                if(!input.equals("")){
//
//                    //Easiest way: just set the value.
//                    MainFragment fragment = (MainFragment) getActivity().getFragmentManager().findFragmentByTag("MainFragment");
//                    fragment.mInputDisplay.setText(input);

                    mOnInputSelected.sendInput(input, tipoSeleccionado, grupoSeleccionado);
                }


                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mOnInputSelected = (OnInputSelected) getTargetFragment();
        }catch (ClassCastException e){
            Log.e(TAG, "onAttach: ClassCastException : " + e.getMessage() );
        }
    }
}

