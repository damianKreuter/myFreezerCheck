package kreutcom.myfreezercheck.Heladeras;

import android.content.Context;
import android.nfc.Tag;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import kreutcom.myfreezercheck.MainActivity;
import kreutcom.myfreezercheck.R;

public class AdaptadorHeladeraRecycleView extends RecyclerView.Adapter<AdaptadorHeladeraRecycleView.ViewHolderDatos> {
    ArrayList<claseElementoHeladeraAlmacenamiento> listDatos;
    private LayoutInflater inflater;
    private Context context;

    private OnAdaptadorHeladeraRecycler onAdaptadorHeladeraRecycler;


    public AdaptadorHeladeraRecycleView(Context context, ArrayList<claseElementoHeladeraAlmacenamiento> listDatos,
                                        OnAdaptadorHeladeraRecycler onAdaptadorHeladeraRecycler) {
        this.listDatos = listDatos;
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.onAdaptadorHeladeraRecycler = onAdaptadorHeladeraRecycler;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.heladera_y_listas_lista_heladeras_elementos_y_datos, viewGroup, false);
        ViewHolderDatos holder = new ViewHolderDatos(view, onAdaptadorHeladeraRecycler);
        holder.asignarDatos(listDatos.get(i));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(listDatos.get(position));
    }

    //    @Override
    /*
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        holder.asignarDatos(listDatos.get(position));
    }*/

  /*  @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int i) {
        viewHolderDatos.asignarDatos(listDatos.get(i));
    }
*/
    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    int[] imagenesHeladera =
            {
                    R.drawable.heladera,        //0
                    R.drawable.alacena,         //1
                    R.drawable.freezer,         //2
                    R.drawable.minibar          //3
            };

    private TextView nombre;
    private TextView fecha;
    private TextView grupo;
    private ImageView imagen;
    private LinearLayout contenedor;

    public class ViewHolderDatos extends RecyclerView.ViewHolder implements  View.OnClickListener {

        OnAdaptadorHeladeraRecycler monAdaptadorHeladeraRecycler;



        public ViewHolderDatos(@NonNull View itemView, OnAdaptadorHeladeraRecycler onAdaptadorListener) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txt_elemento_heladera_nombre);
            fecha = itemView.findViewById(R.id.txt_elemento_heladera_ultima_actualizacion);
            imagen = itemView.findViewById(R.id.imageView_elemento_heladera);
            grupo = itemView.findViewById(R.id.txt_elemento_heladera_grupo);
            contenedor = itemView.findViewById(R.id.recyclerView_objeto_elemento_heladera);

            monAdaptadorHeladeraRecycler = onAdaptadorListener;
            contenedor.setOnClickListener(this);
        }

        public void asignarDatos(claseElementoHeladeraAlmacenamiento claseElementoAlmacenamiento) {
            nombre.setText(claseElementoAlmacenamiento.getNombre());
            grupo.setText(claseElementoAlmacenamiento.getGrupo());
            fecha.setText(claseElementoAlmacenamiento.getCurrentTime());
            imagen.setImageResource(imagenesHeladera[claseElementoAlmacenamiento.getImagen()]);
        }

        @Override
        public void onClick(View v) {
            monAdaptadorHeladeraRecycler.onElementoHeladeraClick( getAdapterPosition());
        }
    }

    public interface OnAdaptadorHeladeraRecycler{
        void onElementoHeladeraClick(int posicion);
    }
}
