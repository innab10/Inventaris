package com.example.inventaris_udn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {

    EditText editTextKode;
    EditText editTextPass;
    EditText editTextPass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        editTextKode = findViewById(R.id.edt_reset_code);
        editTextPass = findViewById(R.id.edt_new_password);
        editTextPass2 = findViewById(R.id.edt_confirm_password);
    }

    public void postChangePassword (View view) {
        if(TextUtils.isEmpty(editTextKode.getText().toString().trim())){
            Toast.makeText(view.getContext(),"Kode Tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else
        if (TextUtils.isEmpty(editTextPass.getText().toString())){
            Toast.makeText(view.getContext(),"Password tidak boleh Kosong!",Toast.LENGTH_LONG).show();
        }else if(!isValidPassword()){
            Toast.makeText(view.getContext(),"Password tidak sesuai",Toast.LENGTH_LONG).show();

        }
        else {
            Intent i = new Intent(ResetPassword.this, MainActivity.class);
            startActivity(i);

        }
    }
    private boolean isValidPassword() {
        boolean temp=true;
        String pass=editTextPass.getText().toString();
        String cpass=editTextPass2.getText().toString();
        if(!pass.equals(cpass)){
            temp=false;
        }
        return temp;
    }
}