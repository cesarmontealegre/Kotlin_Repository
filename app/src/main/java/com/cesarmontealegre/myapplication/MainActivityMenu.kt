package com.cesarmontealegre.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivityMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val calculadora = findViewById<Button>(R.id.buttonCalculadora)
        val cajero = findViewById<Button>(R.id.buttonCajero)
        val cartas = findViewById<Button>(R.id.buttonCartas)
        val juego = findViewById<Button>(R.id.buttonGenPassword)

        calculadora.setOnClickListener {
            val intent = Intent(this, MainActivityCalculadora::class.java)
            startActivity(intent)
        }

        cajero.setOnClickListener {
            val intent = Intent(this, MainActivityCajero::class.java)
            startActivity(intent)
        }

        cartas.setOnClickListener {
            val intent = Intent(this, MainActivityCartas::class.java)
            startActivity(intent)
        }

        juego.setOnClickListener {
            val intent = Intent(this, MainActivityGenPassword::class.java)
            startActivity(intent)
        }
    }
}