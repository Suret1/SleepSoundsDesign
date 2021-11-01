package com.suret.sleepsounds.ui.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.suret.sleepsounds.data.model.SongModel
import com.suret.sleepsounds.databinding.ListSongItemBinding
import com.suret.sleepsounds.ui.profile.adapter.SongAdapter.SongViewHolder

class SongAdapter : ListAdapter<SongModel, SongViewHolder>(Diff) {

    class SongViewHolder(private val binding: ListSongItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: SongModel) {
            binding.apply {
                tvSongNumber.text = model.index.toString()
                tvSongName.text = model.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(
            ListSongItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private object Diff : DiffUtil.ItemCallback<SongModel>() {
    override fun areItemsTheSame(oldItem: SongModel, newItem: SongModel): Boolean {
        return oldItem.index == newItem.index
    }

    override fun areContentsTheSame(oldItem: SongModel, newItem: SongModel): Boolean {
        return oldItem == newItem
    }

}


