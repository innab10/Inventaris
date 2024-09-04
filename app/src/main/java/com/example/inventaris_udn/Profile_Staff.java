package com.example.inventaris_udn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Profile_Staff extends AppCompatActivity {

    EditText editTextnama2;
    EditText editTextid;
    EditText editTextposisi;

    MainActivity main;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_staff);

        editTextnama2 = findViewById(R.id.editnama2);
        editTextposisi = findViewById(R.id.editpos);
        editTextid = findViewById(R.id.edtid);
        DatabaseHelper db = new DatabaseHelper(this);
        Cursor res=db.getProfileStf(main.getfullmail());

        editTextid.setText(res.getString(0));
        editTextnama2.setText(res.getString(3));
        editTextposisi.setText(res.getString(4));

    }

    public void done2(View view) {
        if (TextUtils.isEmpty(editTextnama2.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Nama Tidak boleh Kosong!", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(editTextid.getText().toString())) {
            Toast.makeText(view.getContext(), "ID tidak boleh Kosong!", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(editTextposisi.getText().toString())) {
            Toast.makeText(view.getContext(), "Posisi tidak boleh Kosong!", Toast.LENGTH_LONG).show();
        } else if (db.updateDataStf(main.getfullmail(),editTextnama2.getText().toString(),editTextid.getText().toString(),editTextposisi.getText().toString())) {
            Intent i = new Intent(Profile_Staff.this, Beranda.class);
            startActivity(i);
        }
    }
}