package com.asignatura.wappet.ui.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class DbHelper extends SQLiteOpenHelper {

    private static int DB_VERSION = 1;
    private static String DATABASE_NAME = "wappets_db";
    private static String TABLE_NAME = "veterinarias";
    private static String ID = "id";
    private static String NOMBRE = "nombre";
    private static String DESCRIPCION = "descripcion";
    private static String LATITUD =  "latitud";
    private static String LONGITUD = "longitud";

    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NOMBRE + " TEXT," + DESCRIPCION + " TEXT," + LATITUD + " REAL," + LONGITUD + " REAL)";

    private static String INSERT_MARKER = "INSERT INTO " + TABLE_NAME + "("+ID+"," +NOMBRE+ "," + DESCRIPCION+ "," + LATITUD+ "," + LONGITUD+") VALUES ('1', 'Blanco y violeta', 'Dirección: Eduardo de la barra #660, La Serena, Coquimbo \n Horario: Lunes a Viernes 10:00 - 23:00 \n Telefono: 9 8383 7766','-29.921759','-71.235805')";
    private static String INSERT_MARKER2 = "INSERT INTO " + TABLE_NAME + "("+ID+"," +NOMBRE+ "," + DESCRIPCION+ "," + LATITUD+ "," + LONGITUD+") VALUES ('2', 'Mundo Animal', 'Dirección: Av Guillermo Ulriksen 1693, La Serena, Coquimbo \n Horario: Lunes a Viernes 10:00 - 23:00 \n Telefono: 9 3168 6065','-29.904477','-71.251779')";


    public DbHelper(Context context) { super(context,DATABASE_NAME, null, DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS veterinarias");
        db.execSQL(CREATE_TABLE);
        db.execSQL(INSERT_MARKER);
        db.execSQL(INSERT_MARKER2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS veterinarias");
        onCreate(db);
    }

    public Cursor alldata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor= db.rawQuery("Select * from veterinarias",null);
        return cursor;
    }
}
