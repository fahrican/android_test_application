package com.revolut.androidtestapplication.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.revolut.androidtestapplication.data.network.RevolutCurrencyApi
import com.revolut.androidtestapplication.di.DaggerAppComponent
import com.revolut.androidtestapplication.helper.CurrencyHolder
import com.revolut.androidtestapplication.model.Currency
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
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

    private val currencyHolder = CurrencyHolder() //todo: rework this


    init {
        DaggerAppComponent.create().inject(this)
    }

    fun fetchCurrencies(): Disposable { //todo: here should go in the currency code
        return revolutService.getEndpointResponse("EUR")
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    _isInProgress.postValue(true)
                    if (it != null) {
                        currencyHolder.insertCurrencies(it)
                        _currencies.postValue(currencyHolder.listOfCurrencies)
                    }
                    _isInProgress.postValue(false)
                },
                {
                    _isInProgress.postValue(true)
                    Log.e("subscribeToObserver()", "network error: ${it.message}")
                    _isError.postValue(true)
                    _isInProgress.postValue(false)
                })
    }

}