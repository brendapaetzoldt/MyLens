package com.example.mylens.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;
    private static final String TABELA = "lente";

    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table lente(id integer primary key autoincrement, " +
                "marca varchar(30), grauOE varchar(5), grauOD varchar(5), diasValidade integer, diasDuracao integer, motivoTroca varchar (50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABELA);
        onCreate(db);

    }
}
