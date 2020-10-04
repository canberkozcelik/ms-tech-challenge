package com.marleyspoon.techchallenge.ui.recipes

import com.marleyspoon.techchallenge.di.ViewModelKey
import dagger.Module

@Module
abstract class RecipesActivityModule {
    @ViewModelKey(RecipesViewModel::class)
    internal abstract fun provideRecipesViewModel(viewModel: RecipesViewModel): RecipesViewModel
}