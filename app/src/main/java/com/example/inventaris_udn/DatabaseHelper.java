package com.example.inventaris_udn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Objects;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="inventarisudn.db";
    public static final String TABLE_ADMIN_NAME="admin";
    public static final String COL_USERNAME_ADMIN="email";
    public static final String COL_PASS_ADMIN="password";
    public static final String TABLE_MHS_NAME="mhs";
    public static final String TABLE_DSN_NAME="dsn";
    public static final String TABLE_STF_NAME="stf";
    public static final String TABLE_BARANG_NAME="barang";

    public static final String COL_MHS_NIM ="nim";
    public static final String COL_MHS_NAMA ="nama";
    public static final String COL_MHS_FAK ="fakultas";
    public static final String COL_MHS_JUR ="jurusan";
    public static final String COL_MHS_NOMOR ="nomorhp";


    public static final String COL_DSN_NIM ="nidn";
    public static final String COL_DSN_NAMA ="nama";
    public static final String COL_DSN_FAK ="fakultas";
    public static final String COL_DSN_JUR ="jurusan";

    public static final String COL_STF_ID ="id_staf";
    public static final String COL_STF_NAMA ="nama";
    public static final String COL_STF_POSISI ="posisi";

    public static final String COL_BRG_ID ="id_barang";
    public static final String COL_BRG_NAMA ="nama";
    public static final String COL_BRG_KONDISI ="kondisi";
    public static final String COL_BRG_STATUS ="status";
    public static final String COL_BRG_KATEGORI ="kategori";
    public static final String COL_BRG_JUMLAH ="jumlah";

    public static final int DATABASE_VERSION=1;


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table admin(id_admin INTEGER PRIMARY KEY AUTOINCREMENT, email text, password text );");
        db.execSQL("create table mhs(nim text PRIMARY KEY, email text, password text, nama text, fakultas text, jurusan text, nomorhp text);");
        db.execSQL("create table dsn(nidn text PRIMARY KEY, email text, password text, nama text, fakultas text, jurusan text);");
        db.execSQL("create table stf(id_staf text PRIMARY KEY, email text, password text, nama text, posisi text );");
        db.execSQL("create table barang(id_barang INTEGER PRIMARY KEY AUTOINCREMENT, nama text, status text, kondisi text, kategori text, jumlah text );");
        db.execSQL("insert into admin(email,password) values ('admin@admin.dinus.ac.id','123');");
        db.execSQL("insert into mhs(email,password) values ('aku@mhs.dinus.ac.id','321');");
        db.execSQL("insert into dsn(email,password) values ('dosen@dsn.dinus.ac.id','321');");
        db.execSQL("insert into stf(email,password) values ('staf@stf.dinus.ac.id','321');");
        db.execSQL("insert into barang(nama,jumlah) values ('meja','1');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists"+TABLE_ADMIN_NAME);
        onCreate(db);
    }

    boolean validateLogin(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = COL_USERNAME_ADMIN + " = ? AND " + COL_PASS_ADMIN + " = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(
                TABLE_ADMIN_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }

    public boolean validateLoginMhs(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = COL_USERNAME_ADMIN + " = ? AND " + COL_PASS_ADMIN + " = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(
                TABLE_MHS_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }
    public boolean validateLoginDsn(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = COL_USERNAME_ADMIN + " = ? AND " + COL_PASS_ADMIN + " = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(
                TABLE_DSN_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }
    public boolean validateLoginStf(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = COL_USERNAME_ADMIN + " = ? AND " + COL_PASS_ADMIN + " = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(
                TABLE_STF_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0;
    }
    boolean daftarAkun(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_USERNAME_ADMIN, username);
        contentValues.put(DatabaseHelper.COL_PASS_ADMIN, password);
        String domain = splitmail(username);

        String mhs = "mhs.dinus.ac.id";
        String dsn = "dsn.dinus.ac.id";
        String stf = "stf.dinus.ac.id";
        if (Objects.equals(domain, mhs)){
            long result = db.insert(TABLE_MHS_NAME, null, contentValues);
            return result != -1;
        } else if (Objects.equals(domain, dsn)) {
            long result = db.insert(TABLE_DSN_NAME, null, contentValues);
            return result != -1;
        } else if (Objects.equals(domain, stf)) {
            long result = db.insert(TABLE_STF_NAME, null, contentValues);
            return result != -1;
        }
        return false;
    }

    String splitmail(String email){
        String[] parts = email.split("@");
        String username = parts[0]; // "example"
        String domain = parts[1]; // "example.com"
        return domain;
    }
    public Cursor getProfileMhs(String fullmail){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from mhs where email=?",new String[]{fullmail});
        return res;
    }
    public Cursor getProfileDsn(String fullmail){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from mhs where email=?",new String[]{fullmail});
        return res;
    }
    public Cursor getProfileStf(String fullmail){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from mhs where email=?",new String[]{fullmail});
        return res;
    }

    public boolean updateDataMhs(String fullmail, String nama, String nim, String fakultas,String jurusan, String nomor){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_MHS_NIM,nim);
        contentValues.put(COL_MHS_NAMA,nama);
        contentValues.put(COL_MHS_FAK,fakultas);
        contentValues.put(COL_MHS_JUR,jurusan);
        contentValues.put(COL_MHS_NOMOR,nomor);

        db.update(TABLE_MHS_NAME,contentValues, "email = ?", new String[]{fullmail});
        return true;
    }
    public boolean updateDataDsn(String fullmail, String nama, String nidn, String fakultas,String jurusan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_DSN_NIM,nidn);
        contentValues.put(COL_DSN_NAMA,nama);
        contentValues.put(COL_DSN_FAK,fakultas);
        contentValues.put(COL_DSN_JUR,jurusan);

        db.update(TABLE_DSN_NAME,contentValues, "email = ?", new String[]{fullmail});
        return true;
    }
    public boolean updateDataStf(String fullmail, String nama, String id_staf, String posisi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_STF_ID,id_staf);
        contentValues.put(COL_STF_NAMA,nama);
        contentValues.put(COL_STF_POSISI,posisi);

        db.update(TABLE_STF_NAME,contentValues, "email = ?", new String[]{fullmail});
        return true;
    }
    public boolean tambahdatabarang(String nama, String status, String kondisi, String kategori, String jumlah){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_BRG_NAMA, nama);
        contentValues.put(COL_BRG_STATUS, status);
        contentValues.put(COL_BRG_KONDISI, kondisi);
        contentValues.put(COL_BRG_KATEGORI, kategori);
        contentValues.put(COL_BRG_JUMLAH, jumlah);
        long result = db.insert(TABLE_BARANG_NAME, null, contentValues);
        if (result == -1){
            return false;
        }else {
            return true;
        }

    }

    public Cursor tampilbarang(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from barang",null);
        return res;
    }


}
