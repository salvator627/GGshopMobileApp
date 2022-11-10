package com.example.ggshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val list: ArrayList<Game>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    private var OnItemClickListener : onItemClickListener? = null

    fun setOnItemClickListener(onItemClickListener: onItemClickListener){
        this.OnItemClickListener = onItemClickListener
    }


   inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       fun bind(game: Game){
           with(itemView){
               val tittle = findViewById<TextView>(R.id.tv_tittle)
               val price = findViewById<TextView>(R.id.tv_price)
               val img = findViewById<ImageView>(R.id.imageView)

               tittle.text = game.tittle
               price.text = game.price
               img.setImageResource(game.image)

               itemView.setOnClickListener {
                   OnItemClickListener?.onItemClick(game)
               }
           }
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


    interface onItemClickListener{
        fun onItemClick(data:Game)
    }
}