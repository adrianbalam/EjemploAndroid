package com.adrianbalam.practicas.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adrianbalam.practicas.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class TodoActivity : AppCompatActivity() {

    private lateinit var rvCategorias:RecyclerView
    private lateinit var rvTareas:RecyclerView
    private lateinit var edTituloTarea: TextInputEditText
    private lateinit var edDescTarea:TextInputEditText
    private lateinit var btnAddTarea:MaterialButton
    private lateinit var adaptador2:TareasAdaptador

    private var objetosCategoria:ArrayList<CategoriaMolde> = ArrayList()
    private var objetosTarea:ArrayList<TareaMolde> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponents()
        initRV()
        initListeners()
    }

    private fun initComponents() {
        rvCategorias = findViewById(R.id.rvCategorias)
        rvTareas = findViewById(R.id.rvTareas)
        edTituloTarea = findViewById(R.id.edTituloTarea)
        edDescTarea = findViewById(R.id.edDescTarea)
        btnAddTarea = findViewById(R.id.btnAddTarea)
    }

    private fun initListeners(){
        btnAddTarea.setOnClickListener {
            initDialogoAdd()
        }
    }

    private fun initDialogoAdd(){
        val dialogo = Dialog(this)
        dialogo.setContentView(R.layout.dialog_add_tarea)

        val etTituloTarea:TextInputEditText = dialogo.findViewById(R.id.etTituloTarea)
        val etDescTarea:TextInputEditText = dialogo.findViewById(R.id.etDescTarea)
        val btnAddTarea2:MaterialButton = dialogo.findViewById(R.id.btnAddTarea2)
        btnAddTarea2.setOnClickListener {
            if (etTituloTarea.text.toString().isNotEmpty() && etDescTarea.text.toString().isNotEmpty()){
                objetosTarea.add(TareaMolde(etTituloTarea.text.toString(),etDescTarea.text.toString()))
                adaptador2.notifyItemInserted(objetosTarea.size-1)
                dialogo.hide()
            }
        }

        dialogo.show()
    }

    private fun initRV(){
        rvCategorias.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        val adaptador = CategoriasAdaptador(obtenerDatos())
        rvCategorias.adapter = adaptador

        rvTareas.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        adaptador2 = TareasAdaptador(obtenerDatosTareas(), borrarItem = {position -> borrarItem(position)})
        rvTareas.adapter = adaptador2
    }

    private fun obtenerDatos():ArrayList<CategoriaMolde>{
        objetosCategoria.add(CategoriaMolde("Personal","Tareas de ámbito personal"))
        objetosCategoria.add(CategoriaMolde("Profesional","Tareas de ámbito profesional"))
        objetosCategoria.add(CategoriaMolde("Otros","Otros tipos de tareas"))
        return objetosCategoria
    }
    private fun obtenerDatosTareas():ArrayList<TareaMolde>{
        objetosTarea.add(TareaMolde("Estudiar Android","Repasar los conceptos de Android"))
        objetosTarea.add(TareaMolde("Ir a correr","Hacer al menos 30 minutos"))
        objetosTarea.add(TareaMolde("Ir al cine","Comprar boletos en la web"))
        return objetosTarea
    }

    private fun addTarea(){
        if(!edTituloTarea.text.toString().isEmpty() && !edDescTarea.text.toString().isEmpty()){
            objetosTarea.add(TareaMolde(edTituloTarea.text.toString(),edDescTarea.text.toString()))
            adaptador2.notifyItemInserted(objetosTarea.size-1)
        }
    }

    private fun borrarItem(index:Int){
        objetosTarea.removeAt(index)
        adaptador2.notifyItemRemoved(index)
    }
}