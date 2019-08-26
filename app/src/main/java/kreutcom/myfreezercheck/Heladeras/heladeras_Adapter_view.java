package kreutcom.myfreezercheck.Heladeras;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import kreutcom.myfreezercheck.R;

public class heladeras_Adapter_view extends RecyclerView.Adapter<heladeras_Adapter_view.ViewHolderDatos> {

    ArrayList<claseElementoHeladeraAlmacenamiento> listDatos;

    public heladeras_Adapter_view(ArrayList<claseElementoHeladeraAlmacenamiento> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.heladera_y_listas_lista_heladeras_elementos_y_datos, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int i) {
        viewHolderDatos.asignarDatos(listDatos.get(i));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    int[] imagenesHeladera =
            {
                    R.drawable.heladera,        //0
                    R.drawable.alacena,     //1
                    R.drawable.freezer,     //2
                    R.drawable.minibar      //3
            };

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView nombre;
        TextView fecha;
        TextView grupo;
        ImageView imagen;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txt_elemento_heladera_nombre);
            fecha = itemView.findViewById(R.id.txt_elemento_heladera_ultima_actualizacion);
            imagen = itemView.findViewById(R.id.imageView_elemento_heladera);
            grupo = itemView.findViewById(R.id.txt_elemento_heladera_grupo);
        }

        public void asignarDatos(claseElementoHeladeraAlmacenamiento claseElementoAlmacenamiento) {
            nombre.setText(claseElementoAlmacenamiento.getNombre());
            fecha.setText(claseElementoAlmacenamiento.getCurrentTime().toString());
            imagen.setImageResource(imagenesHeladera[claseElementoAlmacenamiento.getImagen()]);
        }
    }
}