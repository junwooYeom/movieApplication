package com.junwooyeom.movieapplication.presentation.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.junwooyeom.movieapplication.GlideApp
import com.junwooyeom.movieapplication.R

object BindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun load(imageView: ImageView, url: String) {
        if (url.isEmpty()) {
            imageView.setBackgroundResource(R.drawable.ic_baseline_image_not_supported_24)
        } else {
            GlideApp.with(imageView.context).load(url).into(imageView)
        }
    }
}
