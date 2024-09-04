package com.example.inventaris_udn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Konfirmasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi);
    }

    public void batal(View view) {
        Intent i = new Intent(Konfirmasi.this, Keranjang.class);
        startActivity(i);
    }

    public void lanjut(View view) {
        Intent i = new Intent(Konfirmasi.this, Beranda.class);
        startActivity(i);
    }
}