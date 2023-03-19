package com.adrianbalam.practicas

class Programador (val nombre:String,
                   val edad:Int,
                   var tel:String,
                   val leng:Array<LENG>?) {

    enum class LENG {
        JAVA,
        KOTLIN
    }

    fun impDatosBasicos(){
        println("Datos del programador:\nNombre: $nombre\nEdad: $edad ")
    }

    fun impLenguajes(){
        leng?.forEach {
            println("Programa en $it")
        }
    }

    class claseAnidada {
        //codigo
    }

}