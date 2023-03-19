package com.adrianbalam.practicas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val tvUsuario2 = findViewById<TextView>(R.id.tvUsuario2)
        val usuario:String = intent.extras?.getString("USER").orEmpty()
        tvUsuario2.setText(usuario)
    }
}