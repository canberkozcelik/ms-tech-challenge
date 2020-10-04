package com.marleyspoon.techchallenge.common.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.marleyspoon.techchallenge.R
import com.marleyspoon.techchallenge.common.extension.loadImageCenterCrop
import com.marleyspoon.techchallenge.common.extension.loadImageFitCenter
import com.marleyspoon.techchallenge.common.extension.notNull
import com.marleyspoon.techchallenge.common.extension.resDrawable

object ImageBindingAdapter {

    @JvmStatic
    @BindingAdapter("setImageCenterCrop")
    fun setImageCenterCrop(view: ImageView, url: String?) {
        url.notNull {
            view.loadImageCenterCrop(it, view.resDrawable(R.drawable.ic_noimage))
        }
    }

    @JvmStatic
    @BindingAdapter("setImageFitCenter")
    fun setImageFitCenter(view: ImageView, url: String?) {
        url.notNull {
            view.loadImageFitCenter(
                it,
                view.resDrawable(R.drawable.ic_noimage)
            )
        }
    }
}