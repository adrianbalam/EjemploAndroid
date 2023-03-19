package com.adrianbalam.practicas.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adrianbalam.practicas.R

class CategoriasAdaptador(private val itemList:List<CategoriaMolde>):RecyclerView.Adapter<CategoriasAdaptador.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categoria,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.tvNombreCat.setText(item.nombreCat)
        holder.tvDescCat.setText(item.descCat)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvNombreCat:TextView = itemView.findViewById(R.id.tvNombreCat)
        val tvDescCat:TextView = itemView.findViewById(R.id.tvDescCat)
    }
}