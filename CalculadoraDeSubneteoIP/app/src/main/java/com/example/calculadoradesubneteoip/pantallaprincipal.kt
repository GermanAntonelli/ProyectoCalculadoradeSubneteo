package com.example.calculadoradesubneteoip

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_pantallaprincipal.*
import java.util.HashMap
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.location.Address
import android.widget.EditText
import android.widget.Toast
import com.example.calculadoradesubneteoip.R.id.textView_address
import kotlinx.android.synthetic.main.activity_pantallaprincipal.view.*
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View


class pantallaprincipal : AppCompatActivity() {
   /* override fun onClick(v: View?) {
        val address = editText_ip_address.text
        textView_address.text = "Address $address"
        val netmask = editText_add_netmask.text
        textView_netmask.text = "Netmask: $netmask"
    }*/

    lateinit var editText_ip_address: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantallaprincipal)

        /*val btnChangeText=findViewById(R.id.button_calcular) as Button;
        val tvHello=findViewById(R.id.textViewtype_of_netmask) as TextView;
        btnChangeText.setOnClickListener {
            tvHello.text= obtenerClase();*/

        val calculadora = calculadora("192.168.1.0", 16)
        val DireccionIP = DireccionIP()

        //val btnChangeText=findViewById(R.id.button_calcular) as Button;
        //val tvAddress=findViewById(R.id.textView_address) as TextView;
        //val tvNetmask=findViewById(R.id.textView_Broadcast) as TextView;
        //val tvType=findViewById(R.id.textViewtype_of_netmask) as TextView;
        //btnChangeText.setOnClickListener {
        //  val obtenerClase = calculadora
        // tvType.text= clase.toString()

        button_calcular.setOnClickListener {
            Toast.makeText(this, "¡Calculando resultado!", Toast.LENGTH_SHORT).show()
            //textView_address.text = findViewById<>()
            //val address = editText_ip_address.text
            // editText_ip_address = findViewById(R.id.editText_ip_address)
            //textView_address = findViewById(R.id.editText_ip_address)
           // textView_address.text = "Address: ${getString(editText_ip_address)}"
            textView_netmask.text = "Netmask: ${calculadora.mascaraClase()}"
            textViewtype_of_netmask.text = "Type of Netmask: ${calculadora.obtenerClase()}"
            textView_network.text = "Network: ${calculadora.mascaraSubRed()}"
            textView_Broadcast.text = "Broadcast: ${calculadora.mascaraClase()}"
            textView_host_min.text = "Host-Min: ${1}"
            textView_host_max.text = "Host-Max: ${calculadora.contadorSubRedes()}"
            textView_host_net.text = "Host/Net: ${com.example.calculadoradesubneteoip.DireccionIP.getNumberOfAddressesFromPrefix(prefixLength = 254)}"

            //val name2 = sharedPreferences.getString("Nombre2", "")
        }


        button_limpiar.setOnClickListener {
            textView_address.text = "Address:"
            textView_netmask.text = "Netmask:"
            textViewtype_of_netmask.text = "Type of Netmask:"
            textView_network.text = "Network: "
            textView_Broadcast.text = "Broadcast: "
            textView_host_min.text = "Host-Min:"
            textView_host_max.text = "Host-Max: "
            textView_host_net.text = "Host/Net: "
        }


    }

}


