package com.example.kitsuapi;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbKitsu extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "KitsuDb.db";
    public static final String USUARIO_TABLE_NAME = "usuario";
    public static final String USUARIO_COLUMN_ID = "id";
    public static final String USUARIO_COLUMN_NOME = "nome";
    public static final String USUARIO_COLUMN_EMAIL = "email";
    public static final String USUARIO_COLUMN_SENHA = "senha";
    public static final String FAVORITOS_TABLE_NAME = "favoritos";
    public static final String FAVORITOS_COLUMN_ID = "id";
    public static final String FAVORITOS_COLUMN_FOREIGN_USUARIO = "userid";
    public static final String FAVORITOS_COLUMN_FOREIGN_ANIME = "animeid";
    public static final String ANIME_TABLE_NAME = "anime";
    public static final String ANIME_COLUMN_ID = "id";
    public static final String ANIME_COLUMN_TITULO_BR = "titulobr";
    public static final String ANIME_COLUMN_TITULO_JP = "titulojp";
    public static final String ANIME_COLUMN_SINOPSE = "sinopse";
    public static final String ANIME_COLUMN_AVALIACAO = "aval";
    public static final String ANIME_COLUMN_TEMPS = "temps";
    public static final String ANIME_COLUMN_EPS = "eps";
    public static final String ANIME_COLUMN_CLASS = "class";
    public static final String ANIME_COLUMN_URL_IMG = "img";


    public DbKitsu(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " + USUARIO_TABLE_NAME +
                        "(" + USUARIO_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        USUARIO_COLUMN_NOME + " TEXT , " +
                        USUARIO_COLUMN_EMAIL + " TEXT , " +
                        USUARIO_COLUMN_SENHA + " TEXT)"
        );

        db.execSQL(
                "create table " + ANIME_TABLE_NAME +
                        "(" + ANIME_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        ANIME_COLUMN_TITULO_BR + " text ," +
                        ANIME_COLUMN_TITULO_JP + " text ," +
                        ANIME_COLUMN_SINOPSE + " text ," +
                        ANIME_COLUMN_AVALIACAO + " real ," +
                        ANIME_COLUMN_TEMPS + " integer ," +
                        ANIME_COLUMN_EPS + " integer ," +
                        ANIME_COLUMN_CLASS + " text ," +
                        ANIME_COLUMN_URL_IMG + " text)"
        );

        db.execSQL(
                "create table " + FAVORITOS_TABLE_NAME +
                        "(" + FAVORITOS_COLUMN_ID + " integer primary key autoincrement," +
                        FAVORITOS_COLUMN_FOREIGN_USUARIO + " integer, " +
                        FAVORITOS_COLUMN_FOREIGN_ANIME + " integer, " +
                        "FOREIGN KEY(" + FAVORITOS_COLUMN_FOREIGN_USUARIO + ") REFERENCES " + USUARIO_TABLE_NAME + "(" + USUARIO_COLUMN_ID +"), " +
                        " FOREIGN KEY(" + FAVORITOS_COLUMN_FOREIGN_ANIME +  ") REFERENCES " + ANIME_TABLE_NAME + "(" + ANIME_COLUMN_ID + ") " +
                        ");"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " +
                USUARIO_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +
                ANIME_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +
                FAVORITOS_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUsuario(Cad cad){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(USUARIO_COLUMN_NOME, cad.get_nome());
        contentValues.put(USUARIO_COLUMN_EMAIL, cad.get_email());
        contentValues.put(USUARIO_COLUMN_SENHA, cad.get_senha());
        return  db.insert(USUARIO_TABLE_NAME,
                null,
                contentValues) > 0;
    }

    @SuppressLint("Range")
    public String logarUsuario(String email, String senha) {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] colunas = {USUARIO_COLUMN_NOME};
        String selecao = USUARIO_COLUMN_EMAIL + " = ? AND " + USUARIO_COLUMN_SENHA + " = ?";
        String[] selecaoArgs = {email, senha};

        Cursor cursor = db.query(USUARIO_TABLE_NAME, colunas, selecao, selecaoArgs, null, null, null);

        String nomeUsuario = "Not Found";
        if (cursor.moveToFirst()) {
            int tantofaz = cursor.getColumnIndex(USUARIO_COLUMN_NOME);
            nomeUsuario = cursor.getString(tantofaz);
        }

        cursor.close();
        db.close();

        return nomeUsuario;
    }

    public String getUserName(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] colunas = {USUARIO_COLUMN_NOME}; // Array com os nomes das colunas que você deseja retornar
        Cursor cursor = db.query(USUARIO_TABLE_NAME, colunas, null, null, null, null, null);
        String nomefinal = "No Results";
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String nome = cursor.getString(cursor.getColumnIndex(USUARIO_COLUMN_NOME));
                nomefinal = nome;
            } while (cursor.moveToNext());
        }

        return nomefinal;
    }

}
