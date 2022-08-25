package com.rchyn.travelokaclone.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rchyn.travelokaclone.databinding.ItemRowPromoLandscapeBinding

class PromoLandscapeListAdapter :
    ListAdapter<Int, PromoLandscapeListAdapter.PromoLandscapeViewHolder>(DiffCallback) {
    inner class PromoLandscapeViewHolder(
        binding: ItemRowPromoLandscapeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val image = binding.root
        fun bind(drawable: Int) {
            image.setImageResource(drawable)
        }
    }

    private companion object DiffCallback: DiffUtil.ItemCallback<Int>(){
        override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoLandscapeViewHolder {
        val binding = ItemRowPromoLandscapeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PromoLandscapeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PromoLandscapeViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

}