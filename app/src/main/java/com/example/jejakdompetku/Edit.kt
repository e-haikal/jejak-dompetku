package com.example.jejakdompetku

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class Edit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit)

        val id_pengguna_terpilih:String = intent.getStringExtra("id_pengguna_terpilih").toString()

        val dbjejak:SQLiteDatabase = openOrCreateDatabase("jejak", MODE_PRIVATE,null)
        val ambil = dbjejak.rawQuery("SELECT * FROM pemasukan WHERE id_pemasukan='$id_pengguna_terpilih'",null)
        ambil.moveToNext()

        val isi_tanggal:String = ambil.getString(1)
        val isi_jumlah:String  = ambil.getString(2)
        val isi_kategori:String = ambil.getString(3)
        val isi_keterangan:String = ambil.getString(4)

        val tanggal:EditText = findViewById(R.id.tanggal)
        val jumlah:EditText = findViewById(R.id.jumlah)
        val kategori:EditText = findViewById(R.id.kategori)
        val keterangan:EditText = findViewById(R.id.keterangan)
        val btn_simpan:Button = findViewById(R.id.btn_simpan)
        //val iv_hapus:ImageView = findViewById(R.id.iv_hapus)

        tanggal.setText(isi_tanggal)
        jumlah.setText(isi_jumlah)
        kategori.setText(isi_kategori)
        keterangan.setText(isi_keterangan)

        btn_simpan.setOnClickListener {
            val tanggal_baru:String = tanggal.text.toString()
            val jumlah_baru:String = jumlah.text.toString()
            val kategori_baru:String = kategori.text.toString()
            val keterangan_baru:String = keterangan.text.toString()

            val query = dbjejak.rawQuery("UPDATE pemasukan SET tanggal_pemasukan='$tanggal_baru', jumlah_pemasukan='$jumlah_baru', kategori_pemasukan='$kategori_baru', keterangan_pemasukan='$keterangan_baru' WHERE id_pemasukan='$id_pengguna_terpilih'",null)
            query.moveToNext()
            val pindah:Intent = Intent(this, Dashboard::class.java)
            startActivity(pindah)
        }

    }
}
