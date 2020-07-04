package com.revolut.androidtestapplication.repository

import com.revolut.androidtestapplication.data.network.RevolutCurrencyApi
import javax.inject.Inject

class CurrencyRepository {

    @Inject
    lateinit var revolutService: RevolutCurrencyApi
}