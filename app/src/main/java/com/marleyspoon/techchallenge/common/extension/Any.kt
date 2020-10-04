package com.marleyspoon.techchallenge.common.extension

fun Any?.isNull(): Boolean {
    return (this == null)
}

inline fun <R> R?.notNull(f: (it: R) -> Unit) {
    if (this != null) {
        f(this)
    }
}

inline fun <R> R?.isNull(f: (it: R?) -> Unit) {
    if (this == null) {
        f(this)
    }
}