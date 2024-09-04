package com.example.inventaris_udn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    EditText editTextnama;
    EditText editTextnim;
    EditText editTextfakultas;
    EditText editTextjurusan;
    EditText editTextnomor;
    MainActivity main;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editTextnama = findViewById(R.id.editnama);
        editTextnim = findViewById(R.id.editnim);
        editTextfakultas = findViewById(R.id.editfakultas);
        editTextjurusan = findViewById(R.id.editjurusan);
        editTextnomor = findViewById(R.id.editnomor);
    }



    public void done(View view) {
        if(TextUtils.isEmpty(editTextnama.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Nama Tidak boleh Kosong!", Toast.LENGTH_LONG).show();
        }else
        if (TextUtils.isEmpty(editTextnim.getText().toString())){
            Toast.makeText(view.getContext(),"NIM tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
        if (TextUtils.isEmpty(editTextfakultas.getText().toString())){
            Toast.makeText(view.getContext(),"Fakultas tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
        if (TextUtils.isEmpty(editTextjurusan.getText().toString())){
            Toast.makeText(view.getContext(),"Jurusan tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
        if (TextUtils.isEmpty(editTextnomor.getText().toString())){
            Toast.makeText(view.getContext(),"Nomor HP tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
        if (db.updateDataMhs(main.getfullmail(),editTextnama.getText().toString(),editTextnim.getText().toString(),editTextfakultas.getText().toString(),editTextjurusan.getText().toString(),editTextnomor.getText().toString())){
            Intent i = new Intent(Profile.this, Beranda.class);
            startActivity(i);
        }
    }
}