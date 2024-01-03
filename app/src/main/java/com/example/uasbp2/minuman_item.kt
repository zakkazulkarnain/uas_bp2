package com.example.aprinew

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class minuman_item (val ini: Context, val id:MutableList<String>, val nama:MutableList<String>, val harga:MutableList<String>, val foto:MutableList<Int>) : RecyclerView.Adapter<minuman_item.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): minuman_item.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.minuman_item, parent, false)

        return ViewHolder(view)
    }

    class ViewHolder (iv: View) : RecyclerView.ViewHolder(iv){

        val txt_nama: TextView = iv.findViewById(R.id.txt_nama)
        val txt_harga: TextView = iv.findViewById(R.id.txt_harga)
        val iv_foto: ImageView = iv.findViewById(R.id.iv_foto)
        val btn_hapus: Button = iv.findViewById(R.id.btn_hapus)
        val btn_edit: Button = iv.findViewById(R.id.btn_edit)
    }

    override fun getItemCount(): Int {
        return nama.size
    }

    override fun onBindViewHolder(holder: minuman_item.ViewHolder, position: Int) {
        holder.txt_nama.text = nama.get(position)
        holder.txt_harga.text = harga.get(position)
        holder.iv_foto.setImageResource(foto.get(position))

        holder.btn_hapus.setOnClickListener {
            val id_produk_terpilih:String = id.get(position)

            val pindah: Intent = Intent(ini, minuman_hapus::class.java)
            pindah.putExtra("id_produk_terpilih", id_produk_terpilih)
            ini.startActivity(pindah)
        }

        holder.btn_edit.setOnClickListener {
            val id_produk_terpilih:String = id.get(position)

            val pindah1: Intent = Intent(ini, edit_minuman::class.java)
            pindah1.putExtra("id_produk_terpilih", id_produk_terpilih)
            ini.startActivity(pindah1)
        }
    }
}