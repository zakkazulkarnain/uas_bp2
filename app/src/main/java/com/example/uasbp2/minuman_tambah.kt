package com.example.aprinew

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class minuman_tambah : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.minuman_tambah)

        val edt_nama: EditText = findViewById(R.id.edt_nama)
        val edt_harga: EditText = findViewById(R.id.edt_harga)
        val btn_simpan: Button = findViewById(R.id.btn_simpan)

        btn_simpan.setOnClickListener {
            val isi_nama:String = edt_nama.text.toString()
            val isi_harga:String = edt_harga.text.toString()

            val dbuas: SQLiteDatabase = openOrCreateDatabase("databaseuas", MODE_PRIVATE, null)
            val eksekutor = dbuas.rawQuery("INSERT INTO menu_minuman (nama_minuman,harga_minuman)VALUES('$isi_nama','$isi_harga')", null)
            eksekutor.moveToNext()

            val pindah: Intent = Intent(this,minuman::class.java)
            startActivity(pindah)
            Log.d("namanya",isi_nama)
            Log.d("harganya", isi_harga)
        }
    }
}