package com.example.inventaris_udn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

public class Beranda extends AppCompatActivity {
    DatabaseHelper db;
    MainActivity main = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        RecyclerView daftarItem = (RecyclerView) findViewById(R.id.daftaritem);
        MainActivity main = new MainActivity();

        daftarItem.setLayoutManager(new LinearLayoutManager(this));
    }
    public void prof(View view) {
        String mhs = "mhs.dinus.ac.id";
        String dsn = "dsn.dinus.ac.id";
        String stf = "stf.dinus.ac.id";

        if (db.validateLoginMhs(main.getfullmail(), main.getpass())) {
            Intent i = new Intent(Beranda.this, Profile.class);
            startActivity(i);
        } else if (main.getmail().equals(dsn)) {
            Intent i = new Intent(Beranda.this, ProfileDosen.class);
            startActivity(i);
        } else if (main.getmail().equals(stf)) {
            Intent i = new Intent(Beranda.this, Profile_Staff.class);
            startActivity(i);
        }
    }
    public void keranjang(View view) {
        Intent i = new Intent(Beranda.this, Keranjang.class);
        startActivity(i);
    }
}