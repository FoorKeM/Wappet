package com.asignatura.wappet.ui.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
            + ID + " TEXT," + NOMBRE + " TEXT," + DESCRIPCION + " TEXT," + LATITUD + " REAL," + LONGITUD + " REAL)";

    public DbHelper(Context context) { super(context,DATABASE_NAME, null, DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(CREATE_TABLE);}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
