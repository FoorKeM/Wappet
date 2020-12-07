package com.asignatura.wappet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AdaptadorMascotasE extends FirebaseRecyclerAdapter<ElementMascota,AdaptadorMascotasE.myviewholder>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdaptadorMascotasE(@NonNull FirebaseRecyclerOptions<ElementMascota> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull ElementMascota model) {
        holder.txtName.setText(model.getNombre());
        holder.txtTipo.setText(model.getTipo());
        holder.txtSexo.setText(model.getSexo());
        holder.txtcontacto.setText(model.getContacto());
        holder.txtcorreo.setText(model.getCorreo());
        holder.txtfecha.setText(model.getFecha());
        holder.txtdescripcion.setText(model.getDescripcion());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        TextView txtName, txtTipo, txtSexo, txtcontacto, txtcorreo, txtfecha, txtdescripcion;

        public myviewholder(@NonNull View itemView){
            super(itemView);
            txtName=itemView.findViewById(R.id.txtname);
            txtTipo=itemView.findViewById(R.id.txttipo);
            txtSexo=itemView.findViewById(R.id.txtsexo);
            txtcontacto=itemView.findViewById(R.id.txtcontacto);
            txtcorreo=itemView.findViewById(R.id.txtcorreo);
            txtfecha=itemView.findViewById(R.id.txtfecha);
            txtdescripcion=itemView.findViewById(R.id.txtdescripcion);
        }
    }
}
