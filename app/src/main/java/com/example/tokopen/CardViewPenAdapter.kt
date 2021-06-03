package com.example.tokopen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewPenAdapter(val list: ArrayList<Pen>): RecyclerView.Adapter<CardViewPenAdapter.CardViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
        val tvDesc: TextView = itemView.findViewById(R.id.tv_item_detail)
        val imgPict: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_pen, parent,false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val pen = list[position]

        Glide.with(holder.itemView.context)
            .load(pen.src)
            .apply(RequestOptions().override(350,550))
            .into(holder.imgPict)

        holder.tvName.text = pen.name
        holder.tvPrice.text = "Rp.${pen.price}"
        holder.tvDesc.text = pen.detail

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(list[holder.adapterPosition]) }
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Pen)
    }
}