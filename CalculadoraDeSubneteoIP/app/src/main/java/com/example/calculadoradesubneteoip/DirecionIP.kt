package com.example.calculadoradesubneteoip

import java.util.HashMap

internal class DireccionIP : HashMap<Int,Int>() {
    companion object {

        private val prefijoYNumeroDeDirecciones: HashMap<Int, Int>
        private val prefijoYSubred: HashMap<Int, String>

        init {
            prefijoYNumeroDeDirecciones = HashMap()
            prefijoYNumeroDeDirecciones[1] = 2147483646
            prefijoYNumeroDeDirecciones[2] = 1073741822
            prefijoYNumeroDeDirecciones[3] = 536870910
            prefijoYNumeroDeDirecciones[4] = 268435454
            prefijoYNumeroDeDirecciones[5] = 134217726
            prefijoYNumeroDeDirecciones[6] = 67108862
            prefijoYNumeroDeDirecciones[7] = 33554430
            prefijoYNumeroDeDirecciones[8] = 16777214
            prefijoYNumeroDeDirecciones[9] = 8388606
            prefijoYNumeroDeDirecciones[10] = 4194302
            prefijoYNumeroDeDirecciones[11] = 2097150
            prefijoYNumeroDeDirecciones[12] = 1048574
            prefijoYNumeroDeDirecciones[13] = 524286
            prefijoYNumeroDeDirecciones[14] = 262142
            prefijoYNumeroDeDirecciones[15] = 131070
            prefijoYNumeroDeDirecciones[16] = 65534
            prefijoYNumeroDeDirecciones[17] = 32766
            prefijoYNumeroDeDirecciones[18] = 16382
            prefijoYNumeroDeDirecciones[19] = 8190
            prefijoYNumeroDeDirecciones[20] = 4094
            prefijoYNumeroDeDirecciones[21] = 2046
            prefijoYNumeroDeDirecciones[22] = 1022
            prefijoYNumeroDeDirecciones[23] = 510
            prefijoYNumeroDeDirecciones[24] = 254
            prefijoYNumeroDeDirecciones[25] = 126
            prefijoYNumeroDeDirecciones[26] = 62
            prefijoYNumeroDeDirecciones[27] = 30
            prefijoYNumeroDeDirecciones[28] = 14
            prefijoYNumeroDeDirecciones[29] = 6
            prefijoYNumeroDeDirecciones[30] = 2
        }

        init {
            prefijoYSubred = HashMap()
            prefijoYSubred[1] = "128.0.0.0"
            prefijoYSubred[2] = "192.0.0.0"
            prefijoYSubred[3] = "224.0.0.0"
            prefijoYSubred[4] = "240.0.0.0"
            prefijoYSubred[5] = "248.0.0.0"
            prefijoYSubred[6] = "252.0.0.0"
            prefijoYSubred[7] = "254.0.0.0"
            prefijoYSubred[8] = "255.0.0.0"
            prefijoYSubred[9] = "255.128.0.0"
            prefijoYSubred[10] = "255.192.0.0"
            prefijoYSubred[11] = "255.224.0.0"
            prefijoYSubred[12] = "255.240.0.0"
            prefijoYSubred[13] = "255.248.0.0"
            prefijoYSubred[14] = "255.252.0.0"
            prefijoYSubred[15] = "255.254.0.0"
            prefijoYSubred[16] = "255.255.0.0"
            prefijoYSubred[17] = "255.255.128.0"
            prefijoYSubred[18] = "255.255.192.0"
            prefijoYSubred[19] = "255.255.224.0"
            prefijoYSubred[20] = "255.255.240.0"
            prefijoYSubred[21] = "255.255.248.0"
            prefijoYSubred[22] = "255.255.252.0"
            prefijoYSubred[23] = "255.255.254.0"
            prefijoYSubred[24] = "255.255.255.0"
            prefijoYSubred[25] = "255.255.255.128"
            prefijoYSubred[26] = "255.255.255.192"
            prefijoYSubred[27] = "255.255.255.224"
            prefijoYSubred[28] = "255.255.255.240"
            prefijoYSubred[29] = "255.255.255.248"
            prefijoYSubred[30] = "255.255.255.252"
        }


        //con este codigo obtenemos la subred del prefijo
        fun getSubredDeNumero(prefixLength: Int): String? {
            return prefijoYSubred[prefixLength].toString()
        }

        //obtener el número de direcciones del prefijo y retornara el prefijo y numero de direcciones en prefijo corto
        fun getNumberOfAddressesFromPrefix(prefixLength: Int): String {
            return prefijoYNumeroDeDirecciones[prefixLength].toString()
        }



        //en esta parte hacemos la parte de obtener el prefijo del número de direcciones
        fun getPrefixFromNumberOfAddresses(numberOfAddresses: Int): Int {
            var entryKey = 0
            var closestHigherValue = 16777217
            for ((key, entryValue) in prefijoYNumeroDeDirecciones) {
                if (entryValue >= numberOfAddresses && entryValue < closestHigherValue) {
                    closestHigherValue = entryValue
                    entryKey = key
                }
            }

            return entryKey
        }

        // En esta seccion vamos a optener el prefijo de la subred
        fun getPrefixFromSubnet(subnet: String): Int {
            for ((key, entryValue) in prefijoYSubred) {
                if (entryValue == subnet) {
                    return key
                }
            }
            return 0
        }

        //En esta funcion hace la parte de obtener el número de direcciones de la subred
        fun getNumberOfAddressesFromSubnet(subnet: String): String {
            val prefix = getPrefixFromSubnet(subnet)
            return prefijoYNumeroDeDirecciones[prefix].toString()
        }

        //En esta funcion obtiene la subred del número de direcciones
        fun getSubnetFromNumberOfAddresses(numberOfAddresses: Int): String {
            val prefix = getPrefixFromNumberOfAddresses(numberOfAddresses)
            return prefijoYSubred[prefix].toString()
        }
    }
}




