package com.junwooyeom.movieapplication

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun load(imageView: ImageView, url: String) {
        GlideApp.with(imageView.context).load(url).into(imageView)
    }
}