package com.example.inventaris_udn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

public class BerandaAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda_admin);
        RecyclerView itemadmin = (RecyclerView) findViewById(R.id.itemadmin);

        DatabaseHelper db = new DatabaseHelper(this);
//        Cursor res = db.tampilbarang();
//
//        itemadmin.setLayoutManager(new LinearLayoutManager(this));
//        String[] Barang = new String[res.getCount()];
//        String[] Jumlah = new String[res.getCount()];;
//
//        int i = 0;
//        while(res.moveToNext()){
//            String barang = res.getString(1);
//            String jumlah = res.getString(5);
//            Barang[i] = barang;
//            Jumlah[i] = jumlah;
//            i++;
//        }
//        itemadmin.setAdapter(new AdapterAdmin(Barang,Jumlah));
    }

    public void tambah(View view) {
        Intent i = new Intent(BerandaAdmin.this, tambah_barang.class);
        startActivity(i);
    }

    public void cetakA(View view) {
        Intent i = new Intent(BerandaAdmin.this, Beranda.class);
        startActivity(i);
    }
}