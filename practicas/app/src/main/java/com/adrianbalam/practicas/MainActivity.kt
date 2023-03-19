package com.adrianbalam.practicas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsuario = findViewById<TextInputEditText>(R.id.etUsuario);
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword);
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin);

        btnLogin.setBackgroundColor(ContextCompat.getColor(this,R.color.black))

        btnLogin.setOnClickListener(View.OnClickListener {
            toastDatosLogin(etUsuario,etPassword)
        })

        //variablesYConstantes()
        //tiposDeDatos()
        //sentenciaIf()
        //sentenciaWhen()
        //arreglos()
        mapas()
        val programador1 = Programador("Luis",25,"9851139993", arrayOf(Programador.LENG.JAVA,Programador.LENG.KOTLIN))
        programador1.impDatosBasicos()
        programador1.impLenguajes()
        programador1.tel = "9851018454"
        println("Telefono: ${programador1.tel}")

        val valor1:valores?
        valor1 = valores.VALOR1
        println(valor1.id)
        println(valor1.ordinal)
        println(valor1.descTexto())
    }

    fun toastDatosLogin(etUsuario:TextInputEditText,etPassword:TextInputEditText){
        if(!etUsuario.text.toString().isEmpty() && !etPassword.text.toString().isEmpty()){
            Toast.makeText(this,"Usuario: ${etUsuario.text.toString()}\nPassword:${etPassword.text.toString()}",Toast.LENGTH_LONG).show()
            val intent = Intent(this,DashboardActivity::class.java)
            intent.putExtra("USER",etUsuario.text.toString())
            startActivity(intent)
        }
    }
    enum class valores (val id:Int) {
        VALOR1(1),VALOR2(2),VALOR3(3),VALOR4(4);
        fun descTexto():String {
            return when(this){
                VALOR1 -> "valor1"
                VALOR2 -> "valor2"
                VALOR3 -> "valor3"
                VALOR4 -> "valor4"
            }
        }
    }

    private fun arreglos() {
        val arreglo = arrayListOf<Int>()
        arreglo.add(10)
        arreglo.add(20)
        arreglo.add(30)
        println(arreglo)
        arreglo.addAll(listOf(40,50,60,70,80))
        println(arreglo)
        val numero = arreglo[0]
        println(numero)
        arreglo[2] = 40
        println(arreglo)
        arreglo.removeAt(0)
        println(arreglo)
        arreglo.forEach {
            println(it)
        }
        arreglo.clear()
        println(arreglo)
    }

    private fun variablesYConstantes(){
        //Hola Comentario
        /*Hola comentario*/
        var myVariable = "Hola Mundo"
        println(myVariable)
        myVariable = "Hello World :D"
        println(myVariable)
        val myConstant = 1
    }

    private fun tiposDeDatos(){
        var myString: String = "Hola"
        var myString2 = "Hola 2"
        var myInt: Int = 1
        var myInt2 = 2
        var myDouble: Double = 2.2
        var myDouble2 = 2.3
        var myFloat: Float = 3.4f
        var myFloat2 = 3.4f
        var myLong: Long = 1234455435345345
        var myLong2 = 1234123123123123213
        var myBool: Boolean = true
        var myBool2 = false
    }

    private fun sentenciaIf(){
        val numero:Int = 2
        if ( (numero*2) == 4 ){
            println("Es igual")
        }else{
            println("Es diferente")
        }
    }

    fun sentenciaWhen(){
        val country:String = "Venezuela"
        when(country){
            "Mexico" -> {
                println("Es latinoamerica")
            } "Peru","Argentina","Colombia" ->{
                println("Es sudamerica")
            } "Estados Unidos","Canada" -> {
                println("Es norteamerica")
            }else -> {
                println("¿Donde es?")
            }
        }

        val edad: Int = 18

        when(edad){
            in 4 .. 10 -> {
                println("Es un niño")
            } in 11 .. 17 -> {
                println("Es un adolescente")
            } else -> {
                println("Es un adulto")
            }
        }
    }

    fun mapas(){
        //Inicializar mapa vacio
        var miMapa:Map<String,Int> = mapOf()
        miMapa = mutableMapOf("Cl1" to 1,"Cl2" to 2)
        println(miMapa)
        miMapa["Cl3"] = 3
        miMapa.put("Cl4",4)
        println(miMapa)
        println(miMapa["Cl3"])
        miMapa.remove("Cl3")
        println(miMapa)
        for (valor in miMapa){
            println("${valor.key} - ${valor.value}")
        }
        for (valor in 0..10 step 4){
            println(valor)
        }
        for (valor in 0 until 10){
            println(valor)
        }
        for (valor in 10 downTo 0){
            println(valor)
        }

        var iteracion = 0
        while (iteracion<=10){
            println(iteracion)
            iteracion++
        }

        var nombre:String? = "Hola"
        //nombre = null
        println(nombre)
        println(nombre?.length)

        nombre?.let {
            println("No es nulo")
        }?: run {
            println("Es nulo")
        }

    }

    fun hola(){

    }
    fun hola2(nombre:String,apellido:String){

    }

    fun hola(nombre:String):String {
        return "hola"
    }
}