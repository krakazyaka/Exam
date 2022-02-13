package com.rybakov.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordAct extends AppCompatActivity {

    EditText etNP,etCP;
    MyDb mdb;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        etNP=(EditText)findViewById(R.id.etNewPassword);
        etCP=(EditText)findViewById(R.id.etConfirmPassword);
    }
    public void changePassword(View v){
        if(etNP.getText().toString().equals(etCP.getText().toString())) {
            mdb = new MyDb(this);
            sqLiteDatabase = mdb.getWritableDatabase();
            sqLiteDatabase.execSQL("Update users set password=? where username=?"
                    , new String[]{etNP.getText().toString(), MyDb.username});
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this,"Пароли не совпадают", Toast.LENGTH_LONG).show();
        }
    }
}