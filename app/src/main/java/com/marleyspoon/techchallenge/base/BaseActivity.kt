package com.marleyspoon.techchallenge.base

import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.ContentLoadingProgressBar
import com.marleyspoon.techchallenge.common.extension.isNull
import com.marleyspoon.techchallenge.common.extension.notNull
import com.marleyspoon.techchallenge.common.extension.toast
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    private var progress: ContentLoadingProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindScreen()
        attachObserver()
    }

    abstract fun bindScreen()
    abstract fun attachObserver()

    fun hideLoading() {
        progress.notNull { it.hide() }
    }

    fun showLoading() {
        hideLoading()
        progress.isNull {
            progress = ContentLoadingProgressBar(this)
        }
        progress?.show()
    }

    fun showError(message: String?) {
        hideLoading()
        message ?: return
        toast(message)
    }
}