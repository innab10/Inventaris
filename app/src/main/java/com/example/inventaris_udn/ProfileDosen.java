package com.example.inventaris_udn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileDosen extends AppCompatActivity {

    EditText editTextnama1;
    EditText editTextnidn1;
    EditText editTextfakultas1;
    EditText editTextjurusan1;

    MainActivity main;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_dosen);
        editTextnama1 = findViewById(R.id.editnama1);
        editTextnidn1 = findViewById(R.id.editnidn1);
        editTextfakultas1 = findViewById(R.id.editfakultas1);
        editTextjurusan1 = findViewById(R.id.editjurusan1);

        DatabaseHelper db = new DatabaseHelper(this);
        Cursor res=db.getProfileDsn(main.getfullmail());

        editTextnidn1.setText(res.getString(0));
        editTextnama1.setText(res.getString(3));
        editTextfakultas1.setText(res.getString(4));
        editTextjurusan1.setText(res.getString(5));



    }
    public void done1 (View view) {
        if(TextUtils.isEmpty(editTextnama1.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Nama Tidak boleh Kosong!", Toast.LENGTH_LONG).show();
        }else
        if (TextUtils.isEmpty(editTextnidn1.getText().toString())){
            Toast.makeText(view.getContext(),"NIDN tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
        if (TextUtils.isEmpty(editTextfakultas1.getText().toString())){
            Toast.makeText(view.getContext(),"Fakultas tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
        if (TextUtils.isEmpty(editTextjurusan1.getText().toString())){
            Toast.makeText(view.getContext(),"Jurusan tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
        if (db.updateDataDsn(main.getfullmail(),editTextnama1.getText().toString(),editTextnidn1.getText().toString(),editTextfakultas1.getText().toString(),editTextjurusan1.getText().toString())){
            Intent i = new Intent(ProfileDosen.this, Beranda.class);
            startActivity(i);
        }
    }
}