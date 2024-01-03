package com.example.jejakdompetku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val txt_login:TextView = findViewById(R.id.txt_login);

        txt_login.setOnClickListener {
            val pindah:Intent = Intent(this, Login1::class.java);
            startActivity(pindah);
        }
        val btn_register:Button = findViewById(R.id.btn_register);

        btn_register.setOnClickListener {
            val pindah:Intent = Intent(this, Registrasi::class.java);
            startActivity(pindah)
        }
    }
}