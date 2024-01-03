package com.example.jejakdompetku

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Hapus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hapus)

        val id_pengguna_terpilih:String = intent.getStringExtra("id_pengguna_terpilih").toString()
        val dbjejak:SQLiteDatabase = openOrCreateDatabase("jejak", MODE_PRIVATE, null)

        val query = dbjejak.rawQuery("DELETE FROM pemasukan WHERE id_pemasukan = '$id_pengguna_terpilih'",null)
        query.moveToNext()

        val pindah:Intent = Intent(this, Dashboard::class.java)
        startActivity(pindah)
    }
}
