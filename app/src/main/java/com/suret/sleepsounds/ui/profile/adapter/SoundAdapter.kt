package com.suret.sleepsounds.ui.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.suret.sleepsounds.data.model.SoundModel
import com.suret.sleepsounds.databinding.ListPackItemBinding

class SoundAdapter : ListAdapter<SoundModel, SoundViewHolder>(DiffCB) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundViewHolder {
        return SoundViewHolder(
            ListPackItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: SoundViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class SoundViewHolder(private val binding: ListPackItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(model: SoundModel) {
        binding.model = model
    }
}

private object DiffCB : DiffUtil.ItemCallback<SoundModel>() {
    override fun areItemsTheSame(oldItem: SoundModel, newItem: SoundModel): Boolean {
        return oldItem.image == newItem.image
    }

    override fun areContentsTheSame(oldItem: SoundModel, newItem: SoundModel): Boolean {
        return oldItem == newItem
    }

}


