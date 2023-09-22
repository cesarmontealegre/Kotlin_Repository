package com.cesarmontealegre.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivityCartas : AppCompatActivity() {
    private lateinit var cartaImageView: ImageView
    private lateinit var generarCartaButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cartas)

        cartaImageView = findViewById(R.id.cartaImageView)
        generarCartaButton = findViewById(R.id.generarCartaButton)

        generarCartaButton.setOnClickListener {
            generarCartaAleatoria()
        }
    }

    private fun generarCartaAleatoria() {
        val valoresCartas = listOf("dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", "jota", "reina", "rey", "as")
        val palos = listOf("corazones", "diamantes", "treboles", "picas")

        // Seleccionar un valor de carta y un palo al azar
        val valorCarta = valoresCartas.random()
        val palo = palos.random()

        // Obtener el recurso de la carta en función de su valor y palo
        val resourceName = "${valorCarta}_${palo}"

        // Obtener el identificador del recurso
        val resourceId = resources.getIdentifier(resourceName, "drawable", packageName)

        // Mostrar la carta en la ImageView
        cartaImageView.setImageResource(resourceId)
    }
}