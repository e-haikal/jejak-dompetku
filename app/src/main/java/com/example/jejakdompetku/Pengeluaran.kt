package com.example.jejakdompetku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Pengeluaran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pengeluaran)

        val btn_pemasukan:Button = findViewById(R.id.btn_pemasukan)
        val btn_simpan:Button = findViewById(R.id.btn_simpan)

        btn_pemasukan.setOnClickListener {
            val pindah:Intent = Intent(this, Tambah::class.java)
            startActivity(pindah)
        }

        btn_simpan.setOnClickListener {
            val pindah:Intent = Intent(this, Dashboard::class.java)
            startActivity(pindah)
        }
    }
}