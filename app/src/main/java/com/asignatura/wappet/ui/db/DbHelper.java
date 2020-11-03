package com.asignatura.wappet.ui.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    private static int DB_VERSION =2;
    private static String DATABASE_NAME = "wappets_db";
    private static String TABLE_NAME = "veterinarias";
    private static String ID = "id";
    private static String NOMBRE = "nombre";
    private static String DESCRIPCION = "descripcion";
    private static String LATITUD =  "latitud";
    private static String LONGITUD = "longitud";

    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + NOMBRE + " TEXT," + DESCRIPCION + " TEXT," + LATITUD + " TEXT," + LONGITUD + " TEXT)";

    public DbHelper(Context context) { super(context,DATABASE_NAME, null, DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DELETE FROM "+ TABLE_NAME);
        db.execSQL(CREATE_TABLE);

        db = this.getWritableDatabase();

        String query = "SELECT * FROM veterinarias";
        db.rawQuery(query, null);

        ContentValues values = new ContentValues();
        values.put("id", "1");
        values.put("nombre", "Blanco y violeta");
        values.put("descripcion", "veterinaria especializada en la atencion de caninos funciona las 24 hrs de lunes a domingo, excepto festivos");
        values.put("latitud", "-29.921759");
        values.put("longitud", "-71.235805");

        db.insert(TABLE_NAME, null, values);

        values.put("id", "2");
        values.put("nombre", "Mundo Animal");
        values.put("descripcion", "veterinaria ubicada en eduardo de la barra #660, horario de apertura: 10:00, telefono: 9 3168 6065");
        values.put("latitud", "-29.904477");
        values.put("longitud", "-71.251779");

        db.insert(TABLE_NAME, null, values);

        values.put("id", "3");
        values.put("nombre", "SilvaVet");
        values.put("descripcion", "veterinaria ubicada en Gómez Carreño #324, horario de apertura: 09:00, telefono: 51 221 2389");
        values.put("latitud", "-29.912675");
        values.put("longitud", "-71.254872");

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS veterinarias");
        onCreate(db);
    }

   public Cursor ViewData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);

        return cursor;
    }

   /** public ArrayList<String> ViewData()
    {
        ArrayList<String> arraylist = new ArrayList<String>();
        SQLiteDatabase sql=this.getReadableDatabase();

        String query = "SELECT * FROM "+TABLE_NAME;

        Cursor c = sql.rawQuery(query, null);
        c.moveToFirst();
        while(c.isAfterLast() == false) {
            arraylist.add(c.getString(1));
            arraylist.add(c.getString(2));
            arraylist.add(c.getString(3));
            arraylist.add(c.getString(4));
            c.moveToNext();
        }

        c.close();
        return arraylist;
    } */
}
