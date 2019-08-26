package kreutcom.myfreezercheck.ListaDeCompras;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kreutcom.myfreezercheck.Heladeras.claseElementoHeladeraAlmacenamiento;
import kreutcom.myfreezercheck.R;

public class AdaptadorListaCompraDe1Grupo extends RecyclerView.Adapter<AdaptadorListaCompraDe1Grupo.ViewHolderDatosLista>
    implements View.OnClickListener
    {
    ArrayList<claseElementoListaParaComprar> lista;
    private LayoutInflater inflater;
    private Context context;

    private View.OnClickListener listener;
    private OnAdaptadorDeListaAHacerClick onClickElementoLista;

    public AdaptadorListaCompraDe1Grupo(Context context, ArrayList<claseElementoListaParaComprar> listDatos,
                                        OnAdaptadorDeListaAHacerClick onAdaptadorDeListaAHacerClick) {
        this.lista = listDatos;
        inflater = LayoutInflater.from(context);
        this.context = context;
        onClickElementoLista = onAdaptadorDeListaAHacerClick;
    }

    public void actualizarDatos(ArrayList<claseElementoListaParaComprar> listDatos){
        this.lista = listDatos;
    }

    @Override
    public void onClick(View view){
        if(listener!=null){
            listener.onClick(view);
        }
    }

    @NonNull
    @Override
    public ViewHolderDatosLista onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.lista_para_comprar_de_1_heladera_datos, viewGroup, false);
        view.setOnClickListener(this);

        ViewHolderDatosLista holder = new ViewHolderDatosLista(view, onClickElementoLista);
        holder.asignarDatos(lista.get(i));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatosLista holder, int position) {
        holder.asignarDatos(lista.get(position));
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
        return lista.size();
    }

        public class ViewHolderDatosLista extends RecyclerView.ViewHolder {

        TextView nombre;
        TextView numero;
        TextView grupo;
        ImageView imagen;
            OnAdaptadorDeListaAHacerClick onAdaptadorDeListaAHacerClick;

            ImageButton sumar, restar;
            TextView descripcionTipo;

        public ViewHolderDatosLista(@NonNull View itemView, OnAdaptadorDeListaAHacerClick onClick) {
            super(itemView);
            nombre = itemView.findViewById(R.id.recycler_view_lista_para_comprar_nombreProducto);
            numero = itemView.findViewById(R.id.lista_de_compra_cantidad_numerica);

            descripcionTipo = itemView.findViewById(R.id.textView_info_de_elemento_de_1lista_de_compra);
/*
            ArrayAdapter<CharSequence> adaptadorTipos = ArrayAdapter.createFromResource(
                    itemView.getContext(), R.array.combo_tipo_medida_cantidad_alimentos,
                    R.layout.support_simple_spinner_dropdown_item);
            */
            sumar = itemView.findViewById(R.id.imageButton_aniadir_1_numero);
            restar = itemView.findViewById(R.id.imageButton_restar_1_numero);

            onAdaptadorDeListaAHacerClick = onClick;

            nombre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    ModificarValorNumerico();
                }
            });

            descripcionTipo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    ModificarValorNumerico();
                }
            });

            sumar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Sumar();
                }
            });
            restar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Restar();
                }
            });

            numero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ModificarValorNumerico();
                }
            });



        }

        public void asignarDatos(claseElementoListaParaComprar claseElementoAlmacenamiento) {
            Log.i("Hola", "Paso por: " + claseElementoAlmacenamiento.getNombreProducto() + claseElementoAlmacenamiento.getNumero());
            numero.setText(Integer.toString(claseElementoAlmacenamiento.getNumero()));
            nombre.setText(claseElementoAlmacenamiento.getNombreProducto());
            descripcionTipo.setText(claseElementoAlmacenamiento.getNombreTipoUnidad());
        }

            public void ModificarValorNumerico() {
                onAdaptadorDeListaAHacerClick.onElementoListaNumeroClick(getAdapterPosition());
            }

            private void Sumar(){
            //1 SUMA
                onAdaptadorDeListaAHacerClick.onSumarORestar1NumeroClick(true, getAdapterPosition());
            }
            private void Restar(){
            //0 RESTA
                onAdaptadorDeListaAHacerClick.onSumarORestar1NumeroClick(false, getAdapterPosition());
            }
        }

    public interface OnAdaptadorDeListaAHacerClick{
            void onElementoListaNumeroClick(int posicion);
            void onSumarORestar1NumeroClick(Boolean esSuma, int posicion);
        }
}
