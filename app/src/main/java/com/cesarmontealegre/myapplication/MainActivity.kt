package com.cesarmontealegre.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val usuario = findViewById<EditText>(R.id.editTextTextUsuario)
        val clave = findViewById<EditText>(R.id.editTextTextPasswordClave)
        val botonIniciar = findViewById<Button>(R.id.buttonIniciar)

        botonIniciar.setOnClickListener {
            if (usuario.text.toString().equals("Admin") && clave.text.toString().equals("123")){
                val intento = Intent(this, MainActivityMenu::class.java)
                startActivity(intento)
                Toast.makeText(this, "¡Bienvenido " +
                        "" +
                        "", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ingrese bien los datos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}