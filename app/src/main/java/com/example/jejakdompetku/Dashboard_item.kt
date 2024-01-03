package com.example.jejakdompetku

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class Dashboard_item (val ini:Context, val id:MutableList<String>,val kategori:MutableList<String>, val pemasukan:MutableList<String>,val keterangan:MutableList<String>,val tanggal:MutableList<String>): RecyclerView.Adapter<Dashboard_item.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Dashboard_item.ViewHolder {
       val view= LayoutInflater.from(parent.context).inflate(R.layout.dashboard_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder (ItemView : View) : RecyclerView.ViewHolder(ItemView){
        val txt_kategori:TextView = ItemView.findViewById(R.id.txt_kategori)
        val txt_pemasukan:TextView = ItemView.findViewById(R.id.txt_pemasukan)
        val txt_keterangan:TextView = ItemView.findViewById(R.id.txt_keterangan)
        val txt_tanggal:TextView = ItemView.findViewById(R.id.txt_tanggal)
        val ly_isi:LinearLayout = ItemView.findViewById(R.id.ly_isi)
    }

    override fun getItemCount(): Int {
        return kategori.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txt_kategori.text = kategori.get(position)
        holder.txt_pemasukan.text = pemasukan.get(position)
        holder.txt_keterangan.text = keterangan.get(position)
        holder.txt_tanggal.text= tanggal.get(position)

        holder.ly_isi.setOnClickListener {
          val id_pengguna_terpilih:String = id.get(position)

            val pindah:Intent = Intent(ini, Edit::class.java)
            pindah.putExtra("id_pengguna_terpilih", id_pengguna_terpilih)
            ini.startActivity(pindah)
        }

    }
}