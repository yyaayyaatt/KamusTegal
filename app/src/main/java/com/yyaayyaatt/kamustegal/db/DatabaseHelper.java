package com.yyaayyaatt.kamustegal.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.yyaayyaatt.juara1.entity.BankSoal;
import com.yyaayyaatt.juara1.entity.Kategory;
import com.yyaayyaatt.juara1.entity.Tes;
import com.yyaayyaatt.juara1.entity.Users;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    // List kategori
    public ArrayList<Kategory> kategoriList = new ArrayList<>();

    public ArrayList<BankSoal> bankSoalList = new ArrayList<>();
    public ArrayList<Users> users = new ArrayList<>();
    public ArrayList<Tes> nilList = new ArrayList<>();

    // Database Name
    public static String DATABASENAME = "RankOne";

    // Field dalam Tabel
    public static String ID = "idx";
    public static String NAMA_KATEGORI = "nama_kategori";
    public static String KETERANGAN = "keterangan";
    public static String IMAGES = "image";
    //Field Bank Soal
    public static String PERTANYAAN = "pertanyaan";
    public static String PIL1 = "pil1";
    public static String PIL2 = "pil2";
    public static String PIL3 = "pil3";
    public static String PIL4 = "pil4";
    public static String PIL5 = "pil5";
    public static String GAMBAR = "gambar";
    public static String JAWABAN = "jawaban_benar";
    public static String KATEGORI = "kategori";


    public static String NAMA = "nama";
    public static String MAPEL = "mapel";
    public static String NILAI = "nilai";

    // Tabel tabel
    public static String TABELKAT = "kategori";
    public static String TABELBANK = "bank_soal";
    public static String TABELNIL = "nilai";

    //Tabel Users
    public static String TABELUSERS = "users";
    public static String ID_TABEL = "id_users";
    public static String NAMA_LENGKAP = "nama_lengkap";
    public static String NAMA_PENGGUNA = "nama_pengguna";
    public static String JK = "jk";
    public static String SANDI = "sandi";

    // Context
    Context c;

    public DatabaseHelper(Context context) {
        super(context, DATABASENAME, null, 8);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // -------- Rancangan Tabel ---------------
        String TBLKAT = ("CREATE TABLE if not exists " + TABELKAT + "(" + ID
                + " INTEGER PRIMARY KEY," + NAMA_KATEGORI
                + " TEXT," + KETERANGAN + " TEXT," + IMAGES + " INTEGER)");

        String tBLBANKSOAL = ("CREATE TABLE if not exists " + TABELBANK + "(" + ID
                + " INTEGER PRIMARY KEY," + PERTANYAAN
                + " TEXT," + PIL1 + " TEXT," + PIL2 + " TEXT," + PIL3 +
                " TEXT," + PIL4 + " TEXT," + PIL5 + " TEXT," + GAMBAR + " INTEGER," + JAWABAN + " TEXT," + KATEGORI + " INTEGER)");

        String tBLNIL = ("CREATE TABLE if not exists " + TABELNIL + "(" + ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAMA
                + " TEXT," + ID_TABEL + " INTEGER,"+ MAPEL + " TEXT," + NILAI + " TEXT)");

        String tblUser = ("CREATE TABLE if not exists " + TABELUSERS + "(" + ID_TABEL
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAMA_LENGKAP
                + " TEXT," + NAMA_PENGGUNA + " TEXT," + JK + " TEXT," + SANDI + " TEXT)");

        db.execSQL(TBLKAT);
        db.execSQL(tBLBANKSOAL);
        db.execSQL(tBLNIL);
        db.execSQL(tblUser);
        System.out.println("Create Tabel Selesai>>>>>>");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELKAT);
        db.execSQL("DROP TABLE IF EXISTS " + TABELBANK);
        db.execSQL("DROP TABLE IF EXISTS " + TABELNIL);
        db.execSQL("DROP TABLE IF EXISTS " + TABELUSERS);
        System.out.println("Upgrade Tabel Selesai>>>>>>");

        onCreate(db);
    }


    public void register(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAMA_LENGKAP, users.nama_lengkap);
        contentValues.put(NAMA_PENGGUNA, users.nama_pengguna);
        contentValues.put(JK, users.jk);
        contentValues.put(SANDI, users.sandi);
        db.insert(TABELUSERS, null, contentValues);
        db.close();
    }

    // Method Simpan data kategori
    public void addKat(Kategory kategori) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, kategori.id);
        contentValues.put(NAMA_KATEGORI, kategori.nama_kategori);
        contentValues.put(KETERANGAN, kategori.keterangan);
        contentValues.put(IMAGES, kategori.images);
        db.insert(TABELKAT, null, contentValues);
        db.close();
    }

    // Method Simpan data kategori
    public void addNil(Tes kategori) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_TABEL, kategori.id_users);
        contentValues.put(NAMA, kategori.nama);
        contentValues.put(MAPEL, kategori.mapel);
        contentValues.put(NILAI, kategori.nilai);
        db.insert(TABELNIL, null, contentValues);
        db.close();
    }

    // method get data kategori
    public ArrayList<Kategory> getkategoris() {

        kategoriList.clear();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABELKAT, null);
        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
                    Kategory item = new Kategory();
                    item.id = cursor.getInt(cursor
                            .getColumnIndex(ID));
                    item.nama_kategori = cursor.getString(cursor
                            .getColumnIndex(NAMA_KATEGORI));
                    item.keterangan = cursor.getString(cursor
                            .getColumnIndex(KETERANGAN));
                    item.images = cursor.getInt(cursor
                            .getColumnIndex(IMAGES));

                    kategoriList.add(item);

                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return kategoriList;
    }

    // Method Simpan data kategori
    public void addBankSoal(BankSoal bankSoal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, bankSoal.id);
        contentValues.put(PERTANYAAN, bankSoal.pertanyaan);
        contentValues.put(PIL1, bankSoal.pil1);
        contentValues.put(PIL2, bankSoal.pil2);
        contentValues.put(PIL3, bankSoal.pil3);
        contentValues.put(PIL4, bankSoal.pil4);
        contentValues.put(GAMBAR, bankSoal.gambar);
        contentValues.put(JAWABAN, bankSoal.jawaban_benar);
        contentValues.put(KATEGORI, bankSoal.kategori);
        db.insert(TABELBANK, null, contentValues);
        db.close();
    }

    // method get data kategori
    public ArrayList<BankSoal> getBankSoals(int id) {

        bankSoalList.clear();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABELBANK + " where " + KATEGORI + " = " + id, null);
        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
                    BankSoal item = new BankSoal();
                    item.id = cursor.getInt(cursor
                            .getColumnIndex(ID));
                    item.pertanyaan = cursor.getString(cursor
                            .getColumnIndex(PERTANYAAN));
                    item.pil1 = cursor.getString(cursor
                            .getColumnIndex(PIL1));
                    item.pil2 = cursor.getString(cursor
                            .getColumnIndex(PIL2));
                    item.pil3 = cursor.getString(cursor
                            .getColumnIndex(PIL3));
                    item.pil4 = cursor.getString(cursor
                            .getColumnIndex(PIL4));
                    item.gambar = cursor.getInt(cursor
                            .getColumnIndex(GAMBAR));
                    item.jawaban_benar = cursor.getString(cursor
                            .getColumnIndex(JAWABAN));
                    item.kategori = cursor.getString(cursor
                            .getColumnIndex(KATEGORI));

                    bankSoalList.add(item);

                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return bankSoalList;
    }


    public ArrayList<BankSoal> getTotalSoales() {
        bankSoalList.clear();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABELBANK, null);
        if (c.getCount() != 0) {
            if (c.moveToFirst()) {
                do {
                    BankSoal menu = new BankSoal();
                    menu.id = c.getInt(c.getColumnIndex(ID));
                    bankSoalList.add(menu);
                } while (c.moveToNext());
            }
        }
        c.close();
        db.close();
        return bankSoalList;
    }

    public ArrayList<Kategory> getTotalKates() {
        kategoriList.clear();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABELKAT, null);
        if (c.getCount() != 0) {
            if (c.moveToFirst()) {
                do {
                    Kategory menu = new Kategory();
                    menu.id = c.getInt(c.getColumnIndex(ID));
                    kategoriList.add(menu);
                } while (c.moveToNext());
            }
        }
        c.close();
        db.close();
        return kategoriList;
    }

    // method get data kategori
    public ArrayList<Tes> getNils() {

        nilList.clear();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABELNIL + " order by " + NILAI + " DESC", null);
        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
                    Tes item = new Tes();
                    item.id = cursor.getInt(cursor
                            .getColumnIndex(ID));
                    item.nama = cursor.getString(cursor
                            .getColumnIndex(NAMA));
                    item.mapel = cursor.getString(cursor
                            .getColumnIndex(MAPEL));
                    item.nilai = cursor.getString(cursor
                            .getColumnIndex(NILAI));

                    nilList.add(item);

                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return nilList;
    }

    public ArrayList<Users> getUsers(int id) {

        users.clear();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABELUSERS + " where " + ID_TABEL + " = " + id, null);
        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
                    Users item = new Users();
                    item.id = cursor.getInt(cursor
                            .getColumnIndex(ID_TABEL));
                    item.nama_lengkap = cursor.getString(cursor
                            .getColumnIndex(NAMA_LENGKAP));
                    item.nama_pengguna = cursor.getString(cursor
                            .getColumnIndex(NAMA_PENGGUNA));
                    item.jk = cursor.getString(cursor
                            .getColumnIndex(JK));
                    item.sandi = cursor.getString(cursor
                            .getColumnIndex(SANDI));
                    users.add(item);

                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return users;
    }

    public ArrayList<Users> login(String nama_pengguna, String sandi) {

        users.clear();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABELUSERS + " where " + NAMA_PENGGUNA + " = '" + nama_pengguna +"' AND "+SANDI+" = '"+sandi+"'", null);
        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
                    Users item = new Users();
                    item.id = cursor.getInt(cursor
                            .getColumnIndex(ID_TABEL));
                    item.nama_lengkap = cursor.getString(cursor
                            .getColumnIndex(NAMA_LENGKAP));
                    item.nama_pengguna = cursor.getString(cursor
                            .getColumnIndex(NAMA_PENGGUNA));
                    item.jk = cursor.getString(cursor
                            .getColumnIndex(JK));
                    item.sandi = cursor.getString(cursor
                            .getColumnIndex(SANDI));
                    users.add(item);

                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return users;
    }
}
