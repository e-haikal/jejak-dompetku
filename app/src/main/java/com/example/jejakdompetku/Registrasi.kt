package com.example.jejakdompetku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Registrasi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registrasi)

        val btn_buat:Button = findViewById(R.id.btn_buat);

        btn_buat.setOnClickListener {
            val pindah:Intent = Intent(this, Login::class.java)
            startActivity(pindah);
        }
    }
}