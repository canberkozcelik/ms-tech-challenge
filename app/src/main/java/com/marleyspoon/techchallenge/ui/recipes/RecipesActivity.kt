package com.marleyspoon.techchallenge.ui.recipes

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.marleyspoon.techchallenge.R
import com.marleyspoon.techchallenge.base.BaseActivity
import com.marleyspoon.techchallenge.common.extension.observeNonNull
import com.marleyspoon.techchallenge.data.Status
import com.marleyspoon.techchallenge.data.model.RecipesResponse
import com.marleyspoon.techchallenge.databinding.ActivityRecipesBinding
import com.marleyspoon.techchallenge.ui.recipedetail.RecipeDetailFragment
import javax.inject.Inject

class RecipesActivity : BaseActivity() {

    @Inject
    lateinit var recipesViewModel: RecipesViewModel

    private lateinit var binding: ActivityRecipesBinding

    override fun bindScreen() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recipes)
        binding.viewModel = recipesViewModel
        binding.lifecycleOwner = this

        binding.rvRecipes.apply {
            layoutManager = LinearLayoutManager(this@RecipesActivity)
            adapter = RecipesAdapter(object : RecipesAdapter.OnRecipeItemSelectedListener {
                override fun itemSelected(item: RecipesResponse.Item) {
                    openRecipeItemDetail(item)
                }

            })
        }
        recipesViewModel.getRecipes()
    }

    private fun openRecipeItemDetail(item: RecipesResponse.Item) {
        recipesViewModel.assetLiveData.value?.let { asset ->
            recipesViewModel.entryLiveData.value?.let { entry ->
                val recipeDetailFragment =
                    RecipeDetailFragment.newInstance(item, asset, entry)
                recipeDetailFragment.show(supportFragmentManager, "RecipeDetailFragment")
            }
        }
    }

    override fun attachObserver() {
        recipesViewModel.recipesLiveData.observeNonNull(this) {
            when (it.status) {
                Status.SUCCESS -> showRecipeList(
                    it.data?.items,
                    it.data?.includes?.asset,
                    it.data?.includes?.entry
                )
                Status.LOADING -> showLoading()
                Status.ERROR -> showError(it.error?.localizedMessage)
            }
        }
    }

    private fun showRecipeList(
        items: List<RecipesResponse.Item?>?,
        asset: ArrayList<RecipesResponse.Includes.Asset?>?,
        entry: ArrayList<RecipesResponse.Includes.Entry?>?,
    ) {
        items?.let { list ->
            recipesViewModel.itemsLiveData.value = list
            asset?.let {
                recipesViewModel.assetLiveData.value = it
                (binding.rvRecipes.adapter as RecipesAdapter).updateList(list, it)
            }
        }
        entry?.let { recipesViewModel.entryLiveData.value = it }
    }

}