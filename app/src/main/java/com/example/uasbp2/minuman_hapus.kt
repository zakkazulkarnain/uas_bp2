package com.example.aprinew

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class minuman_hapus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.minuman_hapus)

        val id_produk_terpilih:String = intent.getStringExtra("id_produk_terpilih").toString()

        val dbtoko: SQLiteDatabase = openOrCreateDatabase("databaseuas", MODE_PRIVATE, null)
        val query = dbtoko.rawQuery("DELETE FROM menu_minuman WHERE id_minuman= '$id_produk_terpilih'", null)
        query.moveToNext()

        val pindah: Intent = Intent(this,minuman::class.java)
        startActivity(pindah)



    }
}