package com.marleyspoon.techchallenge.di.module

import com.marleyspoon.techchallenge.ui.recipedetail.RecipeDetailFragment
import com.marleyspoon.techchallenge.ui.recipedetail.RecipeDetailFragmentModule
import com.marleyspoon.techchallenge.ui.recipes.RecipesActivity
import com.marleyspoon.techchallenge.ui.recipes.RecipesActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [RecipesActivityModule::class])
    abstract fun bindRecipesActivity(): RecipesActivity

    @ContributesAndroidInjector(modules = [RecipeDetailFragmentModule::class])
    abstract fun bindRecipeDetailFragment(): RecipeDetailFragment
}