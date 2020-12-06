package com.asignatura.wappet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterMascota extends RecyclerView.Adapter<AdapterMascota.ViewHolder> {

    private List<ElementMascota> mData;
    private LayoutInflater mInflater;
    private Context context;
    private OnNoteListener mOnNoteListener;

    public AdapterMascota(List<ElementMascota> itemList, Context context, OnNoteListener onNoteListener){
        this.context = context;
        this.mData = itemList;
        this.mOnNoteListener = onNoteListener;

    }

    @Override
    public int getItemCount(){
        return mData.size();
    }

    @NonNull
    @Override
    public AdapterMascota.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element, null);
        return new AdapterMascota.ViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(final AdapterMascota.ViewHolder holder , final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ElementMascota> items){
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txname, txsexo, txtipo;

        AdapterMascota.OnNoteListener onNoteListener;
         ViewHolder(View itemView, OnNoteListener onNoteListener){
            super(itemView);
            txname = itemView.findViewById(R.id.txtname);
            txsexo = itemView.findViewById(R.id.txtsexo);
            txtipo = itemView.findViewById(R.id.txttipo);
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        void bindData(final ElementMascota item){
            txname.setText(item.getNombre());
            txsexo.setText(item.getSexo());
            txtipo.setText(item.getTipo());
        }
        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }
    public interface OnNoteListener{
        void onNoteClick(int position);

    }
}
