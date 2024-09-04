package com.example.inventaris_udn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class daftarakun extends AppCompatActivity {

    EditText editTextEmail, editTextPassword, editTextPassword2;
    DatabaseHelper db;

    String Email;
    String Pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarakun);
        editTextEmail = findViewById(R.id.emailbaru);
        editTextPassword = findViewById(R.id.pass);
        editTextPassword2 = findViewById(R.id.konfirmasi_password);
        db = new DatabaseHelper(this);
    }
    public void Daftar (View view) {
        if(TextUtils.isEmpty(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email Tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
        if (!isValidEmail(editTextEmail.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Email Tidak Valid", Toast.LENGTH_LONG).show();
        }else
            if (TextUtils.isEmpty(editTextPassword.getText().toString())){
            Toast.makeText(view.getContext(),"Password tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
            if(!isValidPassword()){
            Toast.makeText(view.getContext(),"Password tidak sesuai",Toast.LENGTH_LONG).show();

        }else
        if (db.validateLoginMhs(editTextEmail.getText().toString().trim(), editTextPassword.getText().toString())){
            Toast.makeText(view.getContext(),"Akun sudah ada",Toast.LENGTH_LONG).show();
        }
        else
        if (db.validateLoginDsn(editTextEmail.getText().toString().trim(), editTextPassword.getText().toString())){
            Toast.makeText(view.getContext(),"Akun sudah ada",Toast.LENGTH_LONG).show();
        }
        else
        if (db.validateLoginStf(editTextEmail.getText().toString().trim(), editTextPassword.getText().toString())){
            Toast.makeText(view.getContext(),"Akun sudah ada",Toast.LENGTH_LONG).show();
        }
        else
        if (db.daftarAkun(editTextEmail.getText().toString().trim(), editTextPassword.getText().toString())){
            Toast.makeText(view.getContext(),"Akun Berhasil ditambahkan",Toast.LENGTH_LONG).show();
            Intent i = new Intent(daftarakun.this, MainActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(view.getContext(),"Registrasi Gagal",Toast.LENGTH_LONG).show();
        }
    }
    private boolean isValidPassword() {
        boolean temp=true;
        String pass=editTextPassword.getText().toString();
        String cpass=editTextPassword2.getText().toString();
        if(!pass.equals(cpass)){
            temp=false;
        }
        return temp;
    }

    public static boolean isValidEmail(CharSequence email){
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}