package com.marleyspoon.techchallenge.ui.recipedetail

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.marleyspoon.techchallenge.base.BaseViewModel
import com.marleyspoon.techchallenge.common.extension.notNull
import com.marleyspoon.techchallenge.data.model.RecipesResponse
import javax.inject.Inject

class RecipeDetailViewModel @Inject constructor() : BaseViewModel() {

    var assetLiveData = MutableLiveData<List<RecipesResponse.Includes.Asset>>()
    var entryLiveData = MutableLiveData<List<RecipesResponse.Includes.Entry>>()
    val recipeLiveData = MutableLiveData<RecipesResponse.Item>()
    private val tagsLiveData = MutableLiveData<ArrayList<String>>()

    val photoUrl = ObservableField("")
    val title = ObservableField("")
    val chefsName = ObservableField("")
    val description = ObservableField("")

    fun setUrlByAssetId() {
        assetLiveData.value?.map { asset ->
            if (asset.sys?.id == recipeLiveData.value?.fields?.photo?.sys?.id) {
                asset.fields?.file?.url.notNull {
                    photoUrl.set(String.format("http:%s", it))
                    return
                }
            }
        }
    }

    fun setChefsNameByEntryId() {
        entryLiveData.value?.map { entry ->
            if (entry.sys?.id == recipeLiveData.value?.fields?.chef?.sys?.id) {
                entry.fields?.name.notNull {
                    chefsName.set(String.format("Chef: %s", it))
                    return
                }
            }
        }
    }

    fun getTagsByEntryIds(): List<String>? {
        recipeLiveData.value?.fields?.tags?.map { tag ->
            entryLiveData.value?.map { entry ->
                if (entry.sys?.id == tag?.sys?.id) {
                    entry.fields?.name.notNull {
                        tagsLiveData.value?.add(it)
                    }
                }
            }
        }
        return tagsLiveData.value?.toList()
    }
}
