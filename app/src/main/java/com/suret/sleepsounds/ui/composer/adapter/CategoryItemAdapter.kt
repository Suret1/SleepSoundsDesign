package com.suret.sleepsounds.ui.composer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.suret.sleepsounds.data.model.CategoryItem
import com.suret.sleepsounds.databinding.CategoryRowItemBinding
import com.suret.sleepsounds.ui.composer.adapter.CategoryItemAdapter.CategoryItemViewHolder

class CategoryItemAdapter : ListAdapter<CategoryItem, CategoryItemViewHolder>(diffCallBack) {

    class CategoryItemViewHolder(private val binding: CategoryRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: CategoryItem) {
            binding.apply {
                iwCategoryItem.setImageResource(model.icon)
                tvCategoryItemName.text = model.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        return CategoryItemViewHolder(
            CategoryRowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private object diffCallBack : DiffUtil.ItemCallback<CategoryItem>() {
        override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
            return oldItem == newItem
        }

    }
}


