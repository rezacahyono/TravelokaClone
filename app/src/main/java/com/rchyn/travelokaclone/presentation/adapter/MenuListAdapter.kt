package com.rchyn.travelokaclone.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rchyn.travelokaclone.databinding.ItemRowMenuBinding
import com.rchyn.travelokaclone.domain.model.Menu

class MenuListAdapter(
    private val onClickItem: (menu: Menu) -> Unit
) : ListAdapter<Menu, MenuListAdapter.MenuListViewHolder>(DiffCallback) {
    private lateinit var ctx: Context

    inner class MenuListViewHolder(
        binding: ItemRowMenuBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val root = binding.root
        private val title = binding.tvTitleMenu
        private val icon = binding.ivIconMenu

        fun bind(menu: Menu) {
            title.text = ctx.getString(menu.title)
            icon.setImageResource(menu.icon)
        }

    }

    private companion object DiffCallback : DiffUtil.ItemCallback<Menu>() {
        override fun areItemsTheSame(oldItem: Menu, newItem: Menu): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Menu, newItem: Menu): Boolean {
            return oldItem.title == newItem.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuListViewHolder {
        ctx = parent.context
        val binding = ItemRowMenuBinding.inflate(LayoutInflater.from(ctx), parent, false)
        return MenuListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }
}