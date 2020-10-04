package com.marleyspoon.techchallenge.ui.recipedetail

import com.marleyspoon.techchallenge.di.ViewModelKey
import dagger.Module

@Module
abstract class RecipeDetailFragmentModule {
    @ViewModelKey(RecipeDetailViewModel::class)
    internal abstract fun provideRecipeDetailViewModel(viewModel: RecipeDetailViewModel): RecipeDetailViewModel

}