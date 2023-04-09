package com.example.tokopen.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tokopen.domain.model.Pen
import com.example.tokopen.R
import com.example.tokopen.databinding.ItemPenBinding

class CardViewPenAdapter : RecyclerView.Adapter<CardViewPenAdapter.CardViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    private var list: ArrayList<Pen> = arrayListOf()

    fun setList(list: List<Pen>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class CardViewHolder(private val binding: ItemPenBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pen: Pen) {

            with(binding) {
                Glide.with(itemView.context)
                    .load(pen.src)
                    .apply(RequestOptions().override(350, 550))
                    .into(imageView)

                tvPenName.text = pen.name
                tvPenPrice.text = "Rp.${pen.price}"
                tvPenDescription.text = pen.detail

                itemView.setOnClickListener { onItemClickCallback.onItemClicked(pen) }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = ItemPenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(list[position])


    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Pen)
    }
}