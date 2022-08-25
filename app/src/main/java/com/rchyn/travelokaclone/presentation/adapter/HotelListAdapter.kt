package com.rchyn.travelokaclone.presentation.adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rchyn.travelokaclone.databinding.ItemRowHotelBinding
import com.rchyn.travelokaclone.domain.model.Hotel

class HotelListAdapter(
    private val onClikItem: (hotel: Hotel) -> Unit
) : ListAdapter<Hotel, HotelListAdapter.HotelListViewHolder>(DiffCallback) {
    private lateinit var ctx: Context

    inner class HotelListViewHolder(
        binding: ItemRowHotelBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val root = binding.root
        private val ivHotel = binding.ivHotel
        private val tvUrbanVillage = binding.tvUrbanVillage
        private val tvHotel = binding.tvTitleHotel
        private val tvSale = binding.tvSale
        private val tvPriceOriginal = binding.tvPriceOriginal
        private val tvPriceResult = binding.tvPriceResult

        fun bind(hotel: Hotel) {
            ivHotel.setImageResource(hotel.image)
            tvUrbanVillage.text = ctx.getString(hotel.urbanVillage)
            tvHotel.text = ctx.getString(hotel.title)
            tvSale.text = ctx.getString(hotel.sale)
            tvPriceOriginal.apply {
                paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                text = ctx.getString(hotel.priceOriginal)
            }
            tvPriceResult.text = ctx.getString(hotel.priceResult)
        }
    }

    private companion object DiffCallback : DiffUtil.ItemCallback<Hotel>() {
        override fun areItemsTheSame(oldItem: Hotel, newItem: Hotel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Hotel, newItem: Hotel): Boolean {
            return oldItem.title == newItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelListViewHolder {
        ctx = parent.context
        val binding = ItemRowHotelBinding.inflate(LayoutInflater.from(ctx), parent, false)
        return HotelListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotelListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }
}