package com.marleyspoon.techchallenge.ui.recipedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.andrefrsousa.superbottomsheet.SuperBottomSheetFragment
import com.marleyspoon.techchallenge.R
import com.marleyspoon.techchallenge.common.extension.dpToPx
import com.marleyspoon.techchallenge.common.extension.screenHeight
import com.marleyspoon.techchallenge.data.model.RecipesResponse
import com.marleyspoon.techchallenge.databinding.BottomSheetRecipeDetailBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class RecipeDetailFragment : SuperBottomSheetFragment() {

    @Inject
    lateinit var recipeDetailViewModel: RecipeDetailViewModel

    lateinit var binding: BottomSheetRecipeDetailBinding

    companion object {
        fun newInstance(
            item: RecipesResponse.Item,
            assetArrayList: ArrayList<RecipesResponse.Includes.Asset?>,
            entryArrayList: ArrayList<RecipesResponse.Includes.Entry?>
        ): RecipeDetailFragment {
            val args = Bundle()
            args.putParcelable("RECIPE_DETAIL", item)
            args.putParcelableArrayList("ASSET_LIST", assetArrayList)
            args.putParcelableArrayList("ENTRY_LIST", entryArrayList)
            val fragment = RecipeDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.bottom_sheet_recipe_detail,
            container,
            false
        )
        binding.lifecycleOwner = this
        binding.viewModel = recipeDetailViewModel
        bindScreen()
        return binding.rootRecipeDetail
    }

    private fun bindScreen() {
        recipeDetailViewModel.recipeLiveData.value = arguments?.getParcelable("RECIPE_DETAIL")
        recipeDetailViewModel.assetLiveData.value = arguments?.getParcelableArrayList("ASSET_LIST")
        recipeDetailViewModel.entryLiveData.value = arguments?.getParcelableArrayList("ENTRY_LIST")
        recipeDetailViewModel.recipeLiveData.value?.let {
            recipeDetailViewModel.title.set(it.fields?.title)
            recipeDetailViewModel.description.set(it.fields?.description)
        }
        recipeDetailViewModel.setUrlByAssetId()
        recipeDetailViewModel.setChefsNameByEntryId()
        binding.rvTags.apply {
            adapter = RecipeTagsAdapter(recipeDetailViewModel.getTagsByEntryIds().orEmpty())
        }
    }

    override fun getPeekHeight(): Int {
        return context.screenHeight / 2
    }
}

