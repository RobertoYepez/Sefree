package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.sefree.R
import com.example.sefree.models.Category

class CustomAdapter(val listener: CustomAdapterListener): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var items: ArrayList<Category> = arrayListOf()


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v=LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val item = items[i]

        viewHolder.itemTitulo.text= item.name
        viewHolder.itemImagen.setImageResource(item.icon)

        viewHolder.container.setOnClickListener {
            listener.onClickContainer(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateData(newData: List<Category>){
        items.clear()
        items.addAll(newData)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var itemImagen: ImageView
        var itemTitulo: TextView
        var container: CardView

        init {
            itemImagen=itemView.findViewById(R.id.item_imagen)
            itemTitulo=itemView.findViewById(R.id.item_title)
            container=itemView.findViewById(R.id.card_view)
        }
    }

    interface CustomAdapterListener {
        fun onClickContainer(item: Category)
    }
}