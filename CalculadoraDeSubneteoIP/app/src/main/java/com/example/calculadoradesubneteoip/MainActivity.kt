package com.example.calculadoradesubneteoip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btniniciar.setOnClickListener{
            val intento1 =  Intent(this, pantallaprincipal :: class.java)
            startActivity(intento1)
                Toast.makeText(this, "¡Ha iniciado correctamente la aplicación!", Toast.LENGTH_SHORT).show()

            btnayuda.setOnClickListener {
                val intento2 = Intent (this, pantallaayuda :: class.java)
                startActivity(intento2)
                Toast.makeText(this, "¡Ha iniciado la pantalla ayuda de la aplicación!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
