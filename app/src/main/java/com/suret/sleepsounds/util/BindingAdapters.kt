package com.suret.sleepsounds.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("bind:image")
fun AppCompatImageView.setImage(image: Int) {
    Glide.with(this)
        .load(image)
        .into(this)
}