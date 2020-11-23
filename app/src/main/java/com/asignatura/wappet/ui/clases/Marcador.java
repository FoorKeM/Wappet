package com.asignatura.wappet.ui.clases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.asignatura.wappet.ui.db.DbHelper;

import java.util.ArrayList;

public class Marcador {

    private String nombre;
    private String descripcion;
    private double latitud;
    private double longitud;

    public Marcador(String nombre, String descripcion, double latitud, double longitud){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Marcador(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public SQLiteDatabase lectura (Context context){
        DbHelper dbHelper = new DbHelper (context);
        return dbHelper.getReadableDatabase();
    }

    public ArrayAdapter<Object> obtenerMarcadores (Context context){
        try {
            ArrayAdapter<Object> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1);
            ArrayList<Object> arrayList = new ArrayList<>();
            Cursor c = lectura(context).rawQuery("select * from veterinarias", null);
            while (c.moveToNext()){
                arrayList.add(new Marcador(c.getString(0),c.getString(1),c.getDouble(2),c.getDouble(3)));
            }
            adapter.addAll(arrayList);
            return adapter;
        }catch (Exception e){
            return new ArrayAdapter<Object>(context, android.R.layout.simple_list_item_1);
        }
    }
}
