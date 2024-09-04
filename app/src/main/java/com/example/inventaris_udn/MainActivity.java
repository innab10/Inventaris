package com.example.inventaris_udn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText editTextEmail;
    EditText editTextPass;

    String email ;
    String fullemail ;
    String pswd ;
    public MainActivity(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);

        editTextEmail = findViewById(R.id.eml);
        editTextPass = findViewById(R.id.psw);
    }
    public String getmail(){
        return email;
    }
    public void setmail(String mail){
        this.email = mail;
    }
    public String getfullmail(){
        return fullemail;
    }
    public void setfullmail(String email){
        this.fullemail = email;
    }
    public String getpass(){
        return pswd;
    }
    public void setpass(String pass){
        this.pswd = pass;
    }


    public void frgtpass(View view) {
        Intent i = new Intent(MainActivity.this, LupaPassword.class);
        startActivity(i);
    }

    public void daftar(View view) {
        Intent i = new Intent(MainActivity.this, daftarakun.class);
        startActivity(i);
    }

    public void Login (View view) {
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())
                &&
                TextUtils.isEmpty(editTextPass.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email dan Password tidak Boleh Kosong",Toast.LENGTH_LONG).show();
        }

        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email Tidak boleh Kosong!", Toast.LENGTH_LONG).show();
        }
        else
        if (!isValidEmail(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email Tidak Valid", Toast.LENGTH_LONG).show();
        }
        else
        if (TextUtils.isEmpty(editTextPass.getText().toString())){
            Toast.makeText(view.getContext(),"Password tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }
//        else
//        if (db.validateLogin(editTextEmail.getText().toString().trim(), editTextPass.getText().toString())){
//            Intent i = new Intent(MainActivity.this, BerandaAdmin.class);
//            startActivity(i);
//        }
        else
        if (db.validateLoginMhs(editTextEmail.getText().toString().trim(), editTextPass.getText().toString())){
            setmail(db.splitmail(editTextEmail.getText().toString().trim()));
            setpass(editTextPass.getText().toString());
            setfullmail(editTextEmail.getText().toString().trim());
            Intent i = new Intent(MainActivity.this, Beranda.class);
            startActivity(i);
        }
        else
        if (db.validateLoginDsn(editTextEmail.getText().toString().trim(), editTextPass.getText().toString())){
            setmail(db.splitmail(editTextEmail.getText().toString().trim()));
            setfullmail(editTextEmail.getText().toString().trim());
            setpass(editTextPass.getText().toString());
            Intent i = new Intent(MainActivity.this, Beranda.class);
            startActivity(i);
        }
        else
        if (db.validateLoginStf(editTextEmail.getText().toString().trim(), editTextPass.getText().toString())){
            setmail(db.splitmail(editTextEmail.getText().toString().trim()));
            setfullmail(editTextEmail.getText().toString().trim());
            setpass(editTextPass.getText().toString());
            Intent i = new Intent(MainActivity.this, Beranda.class);
            startActivity(i);
        }
        else {
            //Toast.makeText(view.getContext(),"Akun tidak ditemukan",Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity.this, BerandaAdmin.class);
            startActivity(i);
        }
    }

    public static boolean isValidEmail(CharSequence email){
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}