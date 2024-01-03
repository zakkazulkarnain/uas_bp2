package com.example.aprinew

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class makanan_hapus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.makanan_hapus)

        val id_produk_terpilih:String = intent.getStringExtra("id_produk_terpilih").toString()

        val dbuas: SQLiteDatabase = openOrCreateDatabase("databaseuas", MODE_PRIVATE, null)
        val query = dbuas.rawQuery("DELETE FROM menu_makanan WHERE id_makanan= '$id_produk_terpilih'", null)
        query.moveToNext()

        val pindah: Intent = Intent(this,makanan::class.java)
        startActivity(pindah)



    }
}