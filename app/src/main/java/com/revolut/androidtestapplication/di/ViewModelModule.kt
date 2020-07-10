package com.revolut.androidtestapplication.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.revolut.androidtestapplication.viewmodel.CurrencyViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CurrencyViewModel::class)
    internal abstract fun bindCurrencyViewModel(viewModel: CurrencyViewModel): ViewModel

}