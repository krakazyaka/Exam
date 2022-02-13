package com.rybakov.exam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDb extends SQLiteOpenHelper {
    public static String username;
    public MyDb(Context context) {
        super(context, "voting.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users(username varchar(20), password varchar(20));");
        sqLiteDatabase.execSQL("insert into users values ('admin', 'admin');");
        sqLiteDatabase.execSQL("create table cats(id number(2),name varchar(50),votes number(4));");

        sqLiteDatabase.execSQL("create table voting (id number(2),mobile varchar(20));");

        sqLiteDatabase.execSQL("insert into cats values (1, 'Alisa', 0);");
        sqLiteDatabase.execSQL("insert into cats values (2, 'German', 0);");
        sqLiteDatabase.execSQL("insert into cats values (3, 'Bysya', 0);");
        sqLiteDatabase.execSQL("insert into cats values (4, 'Murzik', 0);");
        sqLiteDatabase.execSQL("insert into cats values (5, 'Arnold', 0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
