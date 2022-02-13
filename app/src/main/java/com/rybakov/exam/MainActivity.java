package com.rybakov.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText etU, etP;
    MyDb mdb;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etU = (EditText)findViewById(R.id.etUsername);
        etP = (EditText)findViewById(R.id.etPassword);
    }

    public  void login(View v){
        mdb = new MyDb(this);
        db= mdb.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=? and password=?",new String[]{etU.getText().toString(), etP.getText().toString()});

        if(cursor.getCount()==0)
            Toast.makeText(this, "Неправильное имя пользователя или пароль", Toast.LENGTH_LONG).show();
        else{
            MyDb.username=etU.getText().toString();
            Intent i = new Intent (this,ProfileAct.class);
            startActivity(i);
        }
    }
}