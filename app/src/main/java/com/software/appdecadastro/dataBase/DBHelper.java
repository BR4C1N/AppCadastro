package com.software.appdecadastro.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context){
        super(context, "AppCadastro", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String querySQL =
                "CREATE TABLE PRODUTOS(" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT" +
                        "" +
                        ")";
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
