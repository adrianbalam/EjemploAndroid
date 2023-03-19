package com.adrianbalam.practicas.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.adrianbalam.practicas.R

class TareasAdaptador(
    private val itemList: List<TareaMolde>,
    private val borrarItem: (Int) -> Unit
) : RecyclerView.Adapter<TareasAdaptador.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarea, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (itemList.isNotEmpty()) {
            val item = itemList[position]
            holder.tvNombreTarea.setText(item.titulo)
            holder.tvDescTarea.setText(item.desc)
            holder.cvTarea.setOnClickListener {
                borrarItem(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombreTarea: TextView = itemView.findViewById(R.id.tvNombreTarea)
        val tvDescTarea: TextView = itemView.findViewById(R.id.tvDescTarea)
        val cvTarea: CardView = itemView.findViewById(R.id.cvTarea)
    }
}