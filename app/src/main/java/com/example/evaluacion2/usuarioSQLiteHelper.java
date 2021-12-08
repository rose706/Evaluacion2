package com.example.evaluacion2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class usuarioSQLiteHelper extends SQLiteOpenHelper {
    String sql = "CREATE TABLE Cliente(Idetificacion INTEGER,Nombres TEXT, Apellidos TEXT)";

    public usuarioSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS Cliente");
        db.execSQL(sql);

    }
}
