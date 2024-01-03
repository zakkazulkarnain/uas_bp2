package com.example.aprinew

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class makanan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.makanan)

        val rv_makanan:RecyclerView = findViewById(R.id.rv_makanan)

        val btn_kembali:Button = findViewById(R.id.btn_kembali)
        btn_kembali.setOnClickListener {
            val keluar:Intent = Intent(this,dashboard::class.java)
            startActivity(keluar)
            finish()
        }

        val id:MutableList<String> = mutableListOf()
        val nama:MutableList<String> = mutableListOf()
        val harga:MutableList<String> = mutableListOf()
        val foto:MutableList<Int> = mutableListOf()

        val dbuas: SQLiteDatabase = openOrCreateDatabase("databaseuas", MODE_PRIVATE, null)
        val detail_produk = dbuas.rawQuery("SELECT * FROM menu_makanan", null)

        while (detail_produk.moveToNext()){
            id.add(detail_produk.getString(0))
            nama.add(detail_produk.getString(1))
            harga.add(detail_produk.getString(2))
            foto.add(R.drawable.nasgor)
        }
        val mi = makanan_item(this, id,nama,harga,foto)

        rv_makanan.adapter = mi
        rv_makanan.layoutManager = GridLayoutManager(this, 2)

        val btn_tambah:Button = findViewById(R.id.btn_tambah)
        btn_tambah.setOnClickListener {
            val pindah:Intent = Intent(this, makanan_tambah::class.java)
            startActivity(pindah)
        }



//        val btn_logout: Button = findViewById(R.id.btn_logout)
//        btn_logout.setOnClickListener {
//
//            val keluar: Intent = Intent(this, dashboard::class.java)
//            startActivity(keluar)
//            finish()
//        }
    }

}