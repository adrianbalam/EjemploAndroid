package com.adrianbalam.practicas.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.adrianbalam.practicas.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class CalculadoraActivity : AppCompatActivity() {

    //Declaración de variables
    private var genero:Boolean = true
    private var altura:Int = 120
    private var peso:Int = 50
    private var edad:Int = 20
    private var imc:Double = 0.0

    //Declaración de Views o Componentes
    private lateinit var cvHombre:CardView
    private lateinit var cvMujer:CardView
    private lateinit var rsAltura:RangeSlider
    private lateinit var tvValorAltura:TextView
    private lateinit var tvValorPeso:TextView
    private lateinit var tvValorEdad:TextView
    private lateinit var fabMasPeso:FloatingActionButton
    private lateinit var fabMenosPeso:FloatingActionButton
    private lateinit var fabMasEdad:FloatingActionButton
    private lateinit var fabMenosEdad:FloatingActionButton
    private lateinit var btnCalcular:MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        //Inicializando los views o componentes
        initViews()
        //Inicializando listeners de los views correspondientes
        initListeners()
    }

    private fun initViews(){
        cvHombre = findViewById(R.id.cvHombre)
        cvMujer = findViewById(R.id.cvMujer)
        rsAltura = findViewById(R.id.rsAltura)
        tvValorAltura = findViewById(R.id.tvValorAltura)
        tvValorPeso = findViewById(R.id.tvValorPeso)
        tvValorEdad = findViewById(R.id.tvValorEdad)
        fabMasPeso = findViewById(R.id.fabMasPeso)
        fabMenosPeso = findViewById(R.id.fabMenosPeso)
        fabMasEdad = findViewById(R.id.fabMasEdad)
        fabMenosEdad = findViewById(R.id.fabMenosEdad)
        btnCalcular = findViewById(R.id.btnCalcular)
    }

    private fun initListeners(){
        cvHombre.setOnClickListener {
            if (!genero){
                cambiarGenero()
                cvHombre.setCardBackgroundColor(ContextCompat.getColor(this,R.color.cv_selected))
                cvMujer.setCardBackgroundColor(ContextCompat.getColor(this,R.color.cv_unselected))
            }
        }
        cvMujer.setOnClickListener {
            if (genero){
                cambiarGenero()
                cvMujer.setCardBackgroundColor(ContextCompat.getColor(this,R.color.cv_selected))
                cvHombre.setCardBackgroundColor(ContextCompat.getColor(this,R.color.cv_unselected))
            }
        }
        rsAltura.addOnChangeListener { _, value, _ ->
            altura = value.toInt()
            tvValorAltura.setText("${value.toInt()} cm")
        }
        fabMasPeso.setOnClickListener {
            tvValorPeso.setText("${++peso} Kg")
        }
        fabMenosPeso.setOnClickListener {
            if (peso>0){
                tvValorPeso.setText("${--peso} Kg")
            }
        }
        fabMasEdad.setOnClickListener {
            tvValorEdad.setText("${++edad}")
        }
        fabMenosEdad.setOnClickListener {
            if (edad>0){
                tvValorEdad.setText("${--edad}")
            }
        }
        btnCalcular.setOnClickListener {
            calcularIMC()
            Toast.makeText(this,"IMC: $imc",Toast.LENGTH_LONG).show()
        }
    }
    private fun cambiarGenero(){
        genero = !genero
    }

    private fun calcularIMC(){
        imc = (peso/((altura.toDouble()/100)*(altura.toDouble()/100)))
    }
}