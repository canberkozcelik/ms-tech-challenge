package com.marleyspoon.techchallenge.data

import com.marleyspoon.techchallenge.BuildConfig.ACCESS_TOKEN
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val service: Service) {

    fun getRecipes() = service.getRecipes(ACCESS_TOKEN, "recipe")
}