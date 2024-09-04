package com.example.inventaris_udn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class tambah_barang extends AppCompatActivity {
    EditText editTextidbar;
    EditText editTextnbar;
    EditText editTextstatus;
    EditText editTextkondisi;
    EditText editTextkat;
    EditText editTextjuml;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_barang);

        editTextnbar = findViewById(R.id.editnbar);
        editTextstatus = findViewById(R.id.editstat);
        editTextkondisi = findViewById(R.id.editkond);
        editTextkat = findViewById(R.id.editkate);
        editTextjuml = findViewById(R.id.editjuml);



    }
    public void ubah(View view) {
        if (TextUtils.isEmpty(editTextnbar.getText().toString())){
            Toast.makeText(view.getContext(),"Nama Barang tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
        if (TextUtils.isEmpty(editTextstatus.getText().toString())){
            Toast.makeText(view.getContext(),"Status tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
        if (TextUtils.isEmpty(editTextkondisi.getText().toString())){
            Toast.makeText(view.getContext(),"Kondisi Barang tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
        if (TextUtils.isEmpty(editTextkat.getText().toString())){
            Toast.makeText(view.getContext(),"Kategori Barang tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
        if (TextUtils.isEmpty(editTextjuml.getText().toString())){
            Toast.makeText(view.getContext(),"Jumlah Barang tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
        if (db.tambahdatabarang(editTextnbar.getText().toString(),editTextstatus.getText().toString(),editTextkondisi.getText().toString(),editTextkat.getText().toString(),editTextjuml.getText().toString())){
            Toast.makeText(view.getContext(),"Berhasil",Toast.LENGTH_LONG).show();
            Intent i = new Intent(tambah_barang.this, BerandaAdmin.class);
            startActivity(i);
        }
    }
}