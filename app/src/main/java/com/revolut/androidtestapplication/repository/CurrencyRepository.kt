package com.revolut.androidtestapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.revolut.androidtestapplication.data.network.RevolutCurrencyApi
import com.revolut.androidtestapplication.di.DaggerAppComponent
import com.revolut.androidtestapplication.model.Currency
import javax.inject.Inject

class CurrencyRepository {

    @Inject
    lateinit var revolutService: RevolutCurrencyApi

    private val _currencies by lazy { MutableLiveData<List<Currency>>() }
    val currencies: LiveData<List<Currency>>
        get() = _currencies

    private val _isInProgress by lazy { MutableLiveData<Boolean>() }
    val isInProgress: LiveData<Boolean>
        get() = _isInProgress

    private val _isError by lazy { MutableLiveData<Boolean>() }
    val isError: LiveData<Boolean>
        get() = _isError


    init {
        DaggerAppComponent.create().inject(this)
    }



}