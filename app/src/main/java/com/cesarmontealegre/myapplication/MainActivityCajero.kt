package com.cesarmontealegre.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivityCajero : AppCompatActivity(){

    private lateinit var saldoTextView: TextView
    private lateinit var inputEditText: EditText
    private var saldo = 10000.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_cajero)

        saldoTextView = findViewById(R.id.saldoTextView)
        inputEditText = findViewById(R.id.inputEditText)

        updateSaldoText()

        val consultarSaldoButton: Button = findViewById(R.id.consultarSaldoButton)
        consultarSaldoButton.setOnClickListener {
            mostrarSaldo()
        }

        val retirarEfectivoButton: Button = findViewById(R.id.retirarEfectivoButton)
        retirarEfectivoButton.setOnClickListener {
            retirarEfectivo()
        }

        val realizarDepositoButton: Button = findViewById(R.id.realizarDepositoButton)
        realizarDepositoButton.setOnClickListener {
            realizarDeposito()
        }

        val salirButton: Button = findViewById(R.id.salirButton)
        salirButton.setOnClickListener {
            finish()
        }
    }

    private fun mostrarSaldo() {
        saldoTextView.text = "Su saldo es: $saldo"
    }

    private fun retirarEfectivo() {
        val cantidad = inputEditText.text.toString().toDoubleOrNull() ?: 0.0

        if (saldo - cantidad < 0) {
            saldoTextView.text = "Usted no cuenta con tanto dinero en su cuenta."
        } else {
            saldo -= cantidad
            updateSaldoText()

            // Lógica para entregar billetes
            var dinero = cantidad.toInt()

            val billetesDe1000 = dinero / 1000
            dinero %= 1000

            val billetesDe500 = dinero / 500
            dinero %= 500

            val billetesDe200 = dinero / 200
            dinero %= 200

            val billetesDe100 = dinero / 100

            val mensaje = StringBuilder()
            mensaje.append("Operación realizada con éxito, su saldo es: $saldo\n")

            if (billetesDe1000 > 0) {
                mensaje.append("Se entregan $billetesDe1000 billetes de 1000 pesos.\n")
            }
            if (billetesDe500 > 0) {
                mensaje.append("Se entregan $billetesDe500 billetes de 500 pesos.\n")
            }
            if (billetesDe200 > 0) {
                mensaje.append("Se entregan $billetesDe200 billetes de 200 pesos.\n")
            }
            if (billetesDe100 > 0) {
                mensaje.append("Se entregan $billetesDe100 billetes de 100 pesos.\n")
            }

            saldoTextView.text = mensaje.toString()
        }
    }

    private fun realizarDeposito() {
        val cantidad = inputEditText.text.toString().toDoubleOrNull() ?: 0.0
        saldo += cantidad
        updateSaldoText()
    }

    private fun updateSaldoText() {
        saldoTextView.text = "Saldo actual: $saldo"
    }

}
