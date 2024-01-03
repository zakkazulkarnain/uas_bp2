package com.example.aprinew

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class edit_makanan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.edit_makanan)

        val id_produk_terpilih:String = intent.getStringExtra("id_produk_terpilih").toString()

        val dbuas : SQLiteDatabase = openOrCreateDatabase("databaseuas", MODE_PRIVATE, null)
        val ambil = dbuas.rawQuery("SELECT * FROM menu_makanan WHERE id_makanan = '$id_produk_terpilih'",null)
        ambil.moveToNext()

        val isi_namamakanan = ambil.getString(1)
        val isi_hargamakanan = ambil.getString(2)

        val edt_namamakanan: EditText = findViewById(R.id.edt_namabarang)
        val edt_hargamakanan: EditText = findViewById(R.id.edt_hargabarang)
        val btn_simpan: Button = findViewById(R.id.btn_Save)


        edt_namamakanan.setText(isi_namamakanan)
        edt_hargamakanan.setText(isi_hargamakanan)

        btn_simpan.setOnClickListener {
            val nama_baru:String = edt_namamakanan.text.toString()
            val harga_baru:String = edt_hargamakanan.text.toString()
            val mengubah = dbuas.rawQuery("UPDATE menu_makanan SET nama_makanan='$nama_baru',harga_makanan='$harga_baru' WHERE id_makanan = '$id_produk_terpilih'",null)
            mengubah.moveToNext()

            val pindah:Intent = Intent (this,makanan::class.java)
            startActivity(pindah)
        }



    }
}