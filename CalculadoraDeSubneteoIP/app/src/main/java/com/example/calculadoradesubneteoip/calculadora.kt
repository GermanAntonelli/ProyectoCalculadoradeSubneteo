package com.example.calculadoradesubneteoip

//Este es el enlace en el cual se baso la idea para realizar la calculadora de subneteo
//https://www.aprendaredes.com/cgi-bin/ipcalc/ipcalc_cgi

class calculadora(private val direccionIP: String, private val subRedes: Int) {

    private var bitsMascara: Int = 0


    // Paso 1: Indentificar clase de la dirección IP by JBY
    // Retorna String de clase ejemplo: "Clase A"
    //
    // Clase A :   0 - 127
    // Clase B : 128 - 191
    // Clase C : 192 - 223
    // Clase D : 224 - 239
    // Clase E : 240 - 255
    //
    fun obtenerClase(): String {
        val arregloDireccion =
            this.direccionIP.split("[.]".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val primerOcteto = Integer.parseInt(arregloDireccion[0])
        var clase = ""

        if (primerOcteto <= 127) {
            clase = "Clase A"
        } else if (primerOcteto >= 128 && primerOcteto <= 191) {
            clase = "Clase B"
        } else if (primerOcteto >= 192 && primerOcteto <= 223) {
            clase = "Clase C"
        } else if (primerOcteto >= 224 && primerOcteto <= 239) {
            clase = "Clase D"
        } else if (primerOcteto >= 240 && primerOcteto <= 255) {
            clase = "Clase E"
        }

        return clase
    }

    // Paso 2: Obtener la masacara a partir de la clase by JBY
    // Retorna String de Mascara ejemplo Clase A: 8
    //
    // Clase A :  8
    // Clase B : 16
    // Clase C : 24
    //
    fun mascaraClase(): String {
        var mascara = "0"
        val clase = obtenerClase()

        if (clase.equals("Clase a", ignoreCase = true)) {
            mascara = "8"
        } else if (clase.equals("Clase b", ignoreCase = true)) {
            mascara = "16"
        } else if (clase.equals("Clase c", ignoreCase = true)) {
            mascara = "24"
        } else if (clase.equals("Clase d", ignoreCase = true)) {
            mascara = "0"
        } else if (clase.equals("Clase e", ignoreCase = true)) {
            mascara = "0"
        }

        return mascara
    }

    // Paso 3: Obtener la mascaraSubred a partir de la MascaraClase by JBY
    // Retorna int : MascaraSubred + MascaraClase
    //
    fun mascaraSubRed(): String {
        val subRedes = this.subRedes
        val mascaraClase = Integer.parseInt(mascaraClase())
        var mascaraSubRed = 0

        val bits = 2

        var i = 0
        while (i < 8) {
            val exponente = Math.pow(bits.toDouble(), i.toDouble()).toInt()
            val buscandoRango = exponente - subRedes

            if (buscandoRango >= 0) {
                mascaraSubRed = i
                i = 8 //Cortando el loop
            }
            i++
        }

        this.bitsMascara = mascaraSubRed // agregando los bits encendidos

        return "" + (mascaraSubRed + mascaraClase)
    }

    // Paso 4: Otener el numero contador que saltará por cada subRed
    // Ejemplo : Bits encendidos = 3 entonces retornará 32
    //
    // Con esto se podrá saltar de IP a otra IP
    // 200.21.0.0 -> 200.21.0.32 -> 200.21.0.64 -> 200.21.0.96
    fun contadorSubRedes(): Int {
        val bits = this.bitsMascara
        var binario = 128
        var resto = 0

        for (i in 1 until bits) {
            binario = binario / 2
            resto = binario
        }

        return resto
    }


}












