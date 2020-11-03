package com.asignatura.wappet.ui.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.android.material.tabs.TabLayout;

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

    public DbHelper(Context context) { super(context,DATABASE_NAME, null, DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
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
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS veterinarias");
        onCreate(db);
    }
}
