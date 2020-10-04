package com.marleyspoon.techchallenge.common.extension

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders

fun ImageView.loadImageCenterCrop(
    url: String,
    placeholder: Drawable?
) {
    if (placeholder != null) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .placeholder(placeholder)
            .centerCrop()
            .into(this)
    } else {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .centerCrop()
            .into(this)
    }
}

fun ImageView.loadImageFitCenter(
    url: String,
    placeholder: Drawable?
) {

    if (placeholder != null) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .placeholder(placeholder)
            .fitCenter()
            .into(this)
    } else {
        val headerWithUrl = GlideUrl(
            url, LazyHeaders.Builder()
                .addHeader("User-Agent", "your-user-agent")
                .build()
        )
        Glide.with(context)
            .load(headerWithUrl)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .fitCenter()
            .into(this)
    }
}