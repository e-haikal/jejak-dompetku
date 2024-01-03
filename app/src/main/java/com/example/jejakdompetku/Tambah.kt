package com.example.jejakdompetku

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class Tambah : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tambah)

        val img_balik:ImageView = findViewById(R.id.img_balik)
        val btn_simpan:Button = findViewById(R.id.btn_simpan)
        val btn_pengeluaran:Button = findViewById(R.id.btn_pengeluaran)
        val edt_tanggal:EditText = findViewById(R.id.edt_tanggal)
        val edt_jumlah:EditText = findViewById(R.id.edt_jumlah)
        val edt_kategori:EditText = findViewById(R.id.edt_kategori)
        val edt_keterangan:EditText = findViewById(R.id.edt_keterangan )

        img_balik.setOnClickListener {
            val pindah:Intent = Intent(this,Dashboard::class.java)
            startActivity(pindah)
        }
        btn_simpan.setOnClickListener {

            val isi_tanggal:String = edt_tanggal.text.toString()
            val isi_jumlah:String = edt_jumlah.text.toString()
            val isi_kategori:String = edt_kategori.text.toString()
            val isi_keterangan:String = edt_keterangan.text.toString()

            val dbjejak:SQLiteDatabase = openOrCreateDatabase("jejak", MODE_PRIVATE, null)
            val eksekutor = dbjejak.rawQuery("INSERT INTO pemasukan(tanggal_pemasukan,jumlah_pemasukan,kategori_pemasukan,keterangan_pemasukan) VALUES('$isi_tanggal','$isi_jumlah','$isi_kategori','$isi_keterangan')",null)
            eksekutor.moveToNext()

            val pindah:Intent = Intent(this, Dashboard::class.java)
            startActivity(pindah)
        }
        btn_pengeluaran.setOnClickListener {
            val pindah:Intent = Intent(this,Pengeluaran::class.java)
            startActivity(pindah)
        }
    }
}