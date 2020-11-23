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

    private static String INSERT_MARKER = "INSERT INTO " + TABLE_NAME + "("+ID+"," +NOMBRE+ "," + DESCRIPCION+ "," + LATITUD+ "," + LONGITUD+") VALUES ('1', 'Blanco y violeta', 'veterinaria especializada en la atencion de caninos funciona las 24 hrs de lunes a domingo, excepto festivos','-29.921759','-71.235805')";

    public DbHelper(Context context) { super(context,DATABASE_NAME, null, DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(INSERT_MARKER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS veterinarias");
        onCreate(db);
    }
}
