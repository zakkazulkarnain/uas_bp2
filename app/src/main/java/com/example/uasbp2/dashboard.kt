package com.example.aprinew

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        val btn_makanan:Button = findViewById(R.id.btn_makanan)
        val btn_minuman:Button = findViewById(R.id.btn_minuman)



        btn_makanan.setOnClickListener {
            val pindah:Intent = Intent(this,makanan::class.java)
            startActivity(pindah)
        }
        btn_minuman.setOnClickListener {
            val pindah1:Intent = Intent(this,minuman::class.java)
            startActivity(pindah1)

            val tiket : SharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
            val email_user = tiket.getString("email_user", null).toString()
            val btn_logout:Button = findViewById(R.id.btn_logout)
            btn_logout.setOnClickListener {
                val edittiket = tiket.edit()
                edittiket.clear()
                edittiket.commit()

                val keluar:Intent = Intent(this,login::class.java)
                startActivity(keluar)
                finish()
            }
//            val dbtoko1: SQLiteDatabase = openOrCreateDatabase("toko", MODE_PRIVATE, null)
//            val detail_produk1 = dbtoko1.rawQuery("SELECT * FROM keyboard", null)
//
//            val dbtoko3: SQLiteDatabase = openOrCreateDatabase("toko", MODE_PRIVATE, null)
//            val detail_produk3 = dbtoko3.rawQuery("SELECT * FROM mouse", null)

//            while (detail_produk.moveToNext()){
//                id.add(detail_produk.getString(0))
//                nama.add(detail_produk.getString(1))
//                harga.add(detail_produk.getString(2))
            }

        }
    }
