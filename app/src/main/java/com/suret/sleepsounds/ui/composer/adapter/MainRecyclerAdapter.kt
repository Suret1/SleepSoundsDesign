package com.suret.sleepsounds.ui.composer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.suret.sleepsounds.data.model.ComposerCategory
import com.suret.sleepsounds.databinding.MainRvRowItemBinding
import com.suret.sleepsounds.ui.composer.adapter.MainRecyclerAdapter.MainRecyclerViewHolder
import com.suret.sleepsounds.ui.composer.adapter.util.EqualSpacingItemDecoration
import com.suret.sleepsounds.ui.composer.adapter.util.Util.dpToPx

class MainRecyclerAdapter : ListAdapter<ComposerCategory, MainRecyclerViewHolder>(diffCallBack) {

    class MainRecyclerViewHolder(private val binding: MainRvRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ComposerCategory) {

            binding.apply {
                tvTitle.text = model.category
                tvSubTitle.text = model.categoryDesc

                val dividerItemDecoration =
                    EqualSpacingItemDecoration(dpToPx(8), LinearLayoutManager.HORIZONTAL)
                rvItem.addItemDecoration(dividerItemDecoration)

                val categoryItemAdapter = CategoryItemAdapter()
                rvItem.adapter = categoryItemAdapter
                categoryItemAdapter.submitList(model.list)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecyclerViewHolder {
        return MainRecyclerViewHolder(
            MainRvRowItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MainRecyclerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private object diffCallBack : DiffUtil.ItemCallback<ComposerCategory>() {
        override fun areItemsTheSame(
            oldItem: ComposerCategory,
            newItem: ComposerCategory
        ) = oldItem.category == newItem.category

        override fun areContentsTheSame(
            oldItem: ComposerCategory,
            newItem: ComposerCategory
        ) = oldItem == newItem
    }

}

