package com.revolut.androidtestapplication.di

import com.revolut.androidtestapplication.repository.CurrencyRepository
import com.revolut.androidtestapplication.ui.view.MainActivity
import com.revolut.androidtestapplication.viewmodel.CurrencyViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(currencyRepository: CurrencyRepository)

    fun inject(viewModel: CurrencyViewModel)

    fun inject(activity: MainActivity)

}