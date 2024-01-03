package com.example.jejakdompetku

import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        val rv_dashboard:RecyclerView = findViewById(R.id.rv_dashboard)

        val id:MutableList<String> = mutableListOf()
        val kategori:MutableList<String> = mutableListOf()
        val pemasukan:MutableList<String> = mutableListOf()
        val keterangan:MutableList<String> = mutableListOf()
        val tanggal:MutableList<String> = mutableListOf()

        val dbjejak:SQLiteDatabase = openOrCreateDatabase("jejak", MODE_PRIVATE,null)
        val gali_pengguna =dbjejak.rawQuery("SELECT * FROM pemasukan", null)
        while (gali_pengguna.moveToNext()){
            id.add(gali_pengguna.getString(0))
            tanggal.add(gali_pengguna.getString(1))
            pemasukan.add(gali_pengguna.getString(2))
            kategori.add(gali_pengguna.getString(3))
            keterangan.add(gali_pengguna.getString(4))
        }

        val di = Dashboard_item ( this, id, kategori, pemasukan, tanggal, keterangan)
        rv_dashboard.adapter = di
        rv_dashboard.layoutManager = LinearLayoutManager(this)

        val iv_tambah:ImageView = findViewById(R.id.iv_tambah)

        iv_tambah.setOnClickListener {
            val pindah:Intent = Intent(this, Tambah::class.java)
            startActivity(pindah)
        }

    }
}