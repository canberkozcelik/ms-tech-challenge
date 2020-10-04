package com.marleyspoon.techchallenge.data

import com.marleyspoon.techchallenge.data.model.RecipesResponse
import com.marleyspoon.techchallenge.data.model.SingleAssetResponse
import com.marleyspoon.techchallenge.data.model.SingleEntryResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {

    @GET("entries")
    fun getRecipes(
        @Query("access_token") accessToken: String,
        @Query("content_type") contentType: String
    ): Observable<RecipesResponse>
}