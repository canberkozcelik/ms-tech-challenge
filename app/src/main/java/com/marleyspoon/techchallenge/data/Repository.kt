package com.marleyspoon.techchallenge.data

import com.marleyspoon.techchallenge.common.extension.applyLoading
import com.marleyspoon.techchallenge.data.model.RecipesResponse
import com.marleyspoon.techchallenge.data.model.SingleAssetResponse
import com.marleyspoon.techchallenge.data.model.SingleEntryResponse
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    fun getRecipes(): Observable<Resource<RecipesResponse>> = remoteDataSource
        .getRecipes()
        .map { Resource.success(it) }
        .onErrorReturn { Resource.error(it) }
        .subscribeOn(Schedulers.io())
        .compose(applyLoading())
}