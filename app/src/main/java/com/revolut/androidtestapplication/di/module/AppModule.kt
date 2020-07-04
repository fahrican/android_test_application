package com.revolut.androidtestapplication.di.module

import com.revolut.androidtestapplication.data.network.RevolutCurrencyApi
import com.revolut.androidtestapplication.data.network.RevolutCurrencyService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object AppModule {

    @Singleton
    @Provides
    fun provideApi(): RevolutCurrencyApi = RevolutCurrencyService.getClient()
}