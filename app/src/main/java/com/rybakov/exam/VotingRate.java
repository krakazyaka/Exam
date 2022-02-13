package com.rybakov.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

public class VotingRate extends AppCompatActivity {

    ListView lv;
    Integer[] photos = {R.drawable.kotik2,R.drawable.kotik3, R.drawable.kotik4, R.drawable.kotik5};
    MyDb mdb;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_rate);

        lv = (ListView)findViewById(R.id.vote_list);

        mdb=new MyDb(this);
        sqLiteDatabase=mdb.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery("select * from cats", null);

        String[] ids = new String[cursor.getCount()];
        String[] names = new String[cursor.getCount()];
        String[] votes = new String[cursor.getCount()];
        int x =0;
        cursor.moveToFirst();

        while (cursor.isAfterLast()==false){
            ids[x] = cursor.getString(0);
            names[x] = cursor.getString(1);
            votes[x] = cursor.getString(2);
            x++;
            cursor.moveToNext();
        }

        CustomVote cv = new CustomVote(this, R.layout.mu_row,ids,names,votes,photos);
        lv.setAdapter(cv);
    }
}