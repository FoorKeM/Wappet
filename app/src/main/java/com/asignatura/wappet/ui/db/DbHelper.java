package com.asignatura.wappet.ui.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


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
            + ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + NOMBRE + " TEXT," + DESCRIPCION + " TEXT," + LATITUD + " REAL," + LONGITUD + " REAL)";

    private static String INSERT_MARKER = "INSERT INTO " + TABLE_NAME + "("+ID+"," +NOMBRE+ "," + DESCRIPCION+ "," + LATITUD+ "," + LONGITUD+") VALUES (1, 'Blanco y violeta', 'veterinaria especializada en la atencion de caninos funciona las 24 hrs de lunes a domingo, excepto festivos','-29.921759','-71.235805')";

    public DbHelper(Context context) { super(context,DATABASE_NAME, null, DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DELETE FROM "+ TABLE_NAME);
        db.execSQL(CREATE_TABLE);
        db.execSQL(INSERT_MARKER);
        /*db = this.getWritableDatabase();

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
        db.close();*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS veterinarias");
        onCreate(db);
    }

    public ArrayList getAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> array_list = new ArrayList<String>();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NAME, null);
        cursor.moveToFirst();
        while(cursor.isAfterLast() == false){
            array_list.add(cursor.getString(cursor.getColumnIndex("id")));
            cursor.moveToNext();
        }
        return array_list;
    }
}
