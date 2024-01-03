package com.example.jejakdompetku

import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class Login1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login1)

        val img_kembali:ImageView = findViewById(R.id.img_kembali)
        val edt_email:EditText = findViewById(R.id.edt_email)
        val edt_password:EditText = findViewById(R.id.edt_password)
        val btn_login:Button = findViewById(R.id.btn_login);

        img_kembali.setOnClickListener {
            val pindah:Intent = Intent(this, Login::class.java)
            startActivity(pindah)
        }

        btn_login.setOnClickListener {
            val isi_email:String = edt_email.text.toString()
            val isi_password:String =edt_password.text.toString()

            val dbjejak:SQLiteDatabase = openOrCreateDatabase("jejak", MODE_PRIVATE,null)

            val query = dbjejak.rawQuery("SELECT * FROM pengguna WHERE email='$isi_email'AND password='$isi_password'",null)
            val cek = query.moveToNext()

            if (cek){
                val id = query.getString(0)
                val nama = query.getString(1)
                val email = query.getString(2)
                val password = query.getString(3)

                val session:SharedPreferences = getSharedPreferences("pengguna", MODE_PRIVATE)
                val tiket = session.edit()
                tiket.putString("id", id)
                tiket.putString("nama",nama)
                tiket.putString("email", email)
                tiket.putString("password", password)
                tiket.commit()

                val pindah:Intent = Intent(this, Dashboard::class.java)
                startActivity(pindah)
            }
            else{
                Toast.makeText(this, "Email atau Password Salah!",Toast.LENGTH_LONG ).show()
            }
        }

    }
}