package com.example.sqlite_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {
    private String create_users = "CREATE TABLE users ("+
            "member_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "name TEXT NOT NULL,"+
            "sex TEXT,"+
            "address TEXT,"+
            "phone TEXT"+
            ");";

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_users);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
