package com.asignatura.wappet;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){
        return mData.size();
    }
    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder , final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListElement> items){
        mData = items;
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView txname, txsexo, txtipo;

        ViewHolder(View itemView){
            super(itemView);
            txname = itemView.findViewById(R.id.txtname);
            txsexo = itemView.findViewById(R.id.txtsexo);
            txtipo = itemView.findViewById(R.id.txttipo);
        }

        void bindData(final ListElement item){
            txname.setText(item.getNombre());
            txsexo.setText(item.getSexo());
            txtipo.setText(item.getTipo());
        }
    }
}
