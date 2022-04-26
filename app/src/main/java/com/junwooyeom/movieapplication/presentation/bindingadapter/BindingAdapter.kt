package com.junwooyeom.movieapplication.presentation.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.junwooyeom.movieapplication.GlideApp

object BindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun load(imageView: ImageView, url: String) {
        GlideApp.with(imageView.context).load(url).into(imageView)
    }
}