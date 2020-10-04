package com.marleyspoon.techchallenge.common.extension

import com.marleyspoon.techchallenge.data.Resource
import io.reactivex.Observable
import io.reactivex.ObservableTransformer

/**
 * https://blog.danlew.net/2015/03/02/dont-break-the-chain/
 */
fun <T> applyLoading(): ObservableTransformer<Resource<T>, Resource<T>> =
    ObservableTransformer { upstream ->
        Observable.just(Resource.loading<T>()).concatWith(upstream)
    }