package com.example.aprinew

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class edit_minuman : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.edit_minuman)

        val id_produk_terpilih:String = intent.getStringExtra("id_produk_terpilih").toString()

        val dbuas : SQLiteDatabase = openOrCreateDatabase("databaseuas", MODE_PRIVATE, null)
        val ambil = dbuas.rawQuery("SELECT * FROM menu_minuman WHERE id_minuman = '$id_produk_terpilih'",null)
        ambil.moveToNext()

        val isi_namaminuman = ambil.getString(1)
        val isi_hargaminuman = ambil.getString(2)

        val edt_namaminuman: EditText = findViewById(R.id.edt_namaminuman)
        val edt_hargaminuman: EditText = findViewById(R.id.edt_hargaminuman)
        val btn_simpan: Button = findViewById(R.id.btn_simpan)


        edt_namaminuman.setText(isi_namaminuman)
        edt_hargaminuman.setText(isi_hargaminuman)

        btn_simpan.setOnClickListener {
            val nama_baru: String = edt_namaminuman.text.toString()
            val harga_baru: String = edt_hargaminuman.text.toString()
            val mengubah = dbuas.rawQuery(
                "UPDATE menu_minuman SET nama_minuman='$nama_baru',harga_minuman='$harga_baru' WHERE id_minuman = '$id_produk_terpilih'",
                null
            )
            mengubah.moveToNext()

            val pindah: Intent = Intent(this, minuman::class.java)
            startActivity(pindah)
        }

    }
}