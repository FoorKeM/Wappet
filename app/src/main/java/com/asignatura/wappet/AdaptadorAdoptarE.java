package com.asignatura.wappet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AdaptadorAdoptarE extends FirebaseRecyclerAdapter<ElementAdoptar,AdaptadorAdoptarE.myviewholder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdaptadorAdoptarE(@NonNull FirebaseRecyclerOptions<ElementAdoptar> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull AdaptadorAdoptarE.myviewholder holder, int position, @NonNull ElementAdoptar model) {
        holder.txtName.setText(model.getNombre());
        holder.txtTipo.setText(model.getTipo());
        holder.txtSexo.setText(model.getSexo());
        holder.txtcontacto.setText(model.getContacto());
        holder.txtcorreo.setText(model.getCorreo());
        holder.txtfecha.setText(model.getFecha());
        holder.txtdescripcion.setText(model.getDescripcion());
        holder.txttamaño.setText(model.getTamaño());
    }

    @NonNull
    @Override
    public AdaptadorAdoptarE.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_adoptar,parent,false);
        return new AdaptadorAdoptarE.myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        TextView txtName, txtTipo, txtSexo, txtcontacto, txtcorreo, txtfecha, txtdescripcion, txttamaño;

        public myviewholder(@NonNull View itemView){
            super(itemView);
            txtName=itemView.findViewById(R.id.txtname);
            txtTipo=itemView.findViewById(R.id.txttipo);
            txtSexo=itemView.findViewById(R.id.txtsexo);
            txtcontacto=itemView.findViewById(R.id.txtcontacto);
            txtcorreo=itemView.findViewById(R.id.txtcorreo);
            txttamaño=itemView.findViewById(R.id.txttamaño);
            txtfecha=itemView.findViewById(R.id.txtfecha);
            txtdescripcion=itemView.findViewById(R.id.txtdescripcion);
        }
    }
}

