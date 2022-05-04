package com.sample.mvvmarchiteturetest.util

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView


@BindingAdapter("setImage")
fun setImage(imageView: ShapeableImageView, image: String) {
    Glide.with(imageView.context)
        .load(image)
        .into(imageView)
}