package com.cesarmontealegre.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivityGenPassword : AppCompatActivity() {

    private lateinit var generarContraseñaButton: Button
    private lateinit var contraseñaTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_genpassword)

        generarContraseñaButton = findViewById(R.id.generarContraseñaButton)
        contraseñaTextView = findViewById(R.id.contraseñaTextView)

        generarContraseñaButton.setOnClickListener {
            val contraseñaGenerada = generarContraseñaSegura()
            contraseñaTextView.text = contraseñaGenerada
        }

    }

    private fun generarContraseñaSegura(): String {
        val caracteresPermitidos = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=<>?/[]{},."
        val longitudContraseña = 12
        val contraseña = StringBuilder()

        val random = java.util.Random()

        for (i in 0 until longitudContraseña) {
            val index = random.nextInt(caracteresPermitidos.length)
            contraseña.append(caracteresPermitidos[index])
        }

        return contraseña.toString()
    }
}