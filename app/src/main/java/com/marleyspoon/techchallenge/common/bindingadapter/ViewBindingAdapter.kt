package com.marleyspoon.techchallenge.common.bindingadapter

import android.view.View
import androidx.databinding.BindingAdapter
import com.marleyspoon.techchallenge.common.extension.setOnDebouncedClickListener

object ViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("visibleIf")
    fun changeVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @BindingAdapter("onSafeClick")
    fun onSafeClick(view: View, listener: View.OnClickListener) {
        view.setOnDebouncedClickListener {
            listener.onClick(view)
        }
    }
}