package com.revolut.androidtestapplication.di

import com.revolut.androidtestapplication.repository.CurrencyRepository
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(currencyRepository: CurrencyRepository)
}