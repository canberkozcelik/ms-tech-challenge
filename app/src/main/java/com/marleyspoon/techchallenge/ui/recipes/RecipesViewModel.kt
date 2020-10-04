package com.marleyspoon.techchallenge.ui.recipes

import androidx.lifecycle.MutableLiveData
import com.marleyspoon.techchallenge.base.BaseViewModel
import com.marleyspoon.techchallenge.data.Repository
import com.marleyspoon.techchallenge.data.Resource
import com.marleyspoon.techchallenge.data.model.RecipesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import javax.inject.Inject

class RecipesViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel() {

    val recipesLiveData = MutableLiveData<Resource<RecipesResponse>>()
    val itemsLiveData = MutableLiveData<List<RecipesResponse.Item?>?>()
    val assetLiveData = MutableLiveData<ArrayList<RecipesResponse.Includes.Asset?>>()
    val entryLiveData = MutableLiveData<ArrayList<RecipesResponse.Includes.Entry?>>()

    fun getRecipes() {
        repository
            .getRecipes()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                recipesLiveData.value = it
            }
            .also { disposable += it }
    }
}