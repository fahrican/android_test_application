package com.revolut.androidtestapplication.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.revolut.androidtestapplication.data.network.RevolutCurrencyApi
import com.revolut.androidtestapplication.di.DaggerAppComponent
import com.revolut.androidtestapplication.helper.CurrencyHolder
import com.revolut.androidtestapplication.internal.EURO
import com.revolut.androidtestapplication.internal.POSITION_OF_EURO_IN_DEFAULT_LIST
import com.revolut.androidtestapplication.model.CurrencyItem
import com.revolut.androidtestapplication.model.EndpointResponse
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class CurrencyRepository {

    @Inject
    lateinit var revolutService: RevolutCurrencyApi

    private val _currencies by lazy { MutableLiveData<List<CurrencyItem>>() }
    val currencies: LiveData<List<CurrencyItem>>
        get() = _currencies

    private val _isInProgress by lazy { MutableLiveData<Boolean>() }
    val isInProgress: LiveData<Boolean>
        get() = _isInProgress

    private val _isError by lazy { MutableLiveData<Boolean>() }
    val isError: LiveData<Boolean>
        get() = _isError

    private val _currencyRates by lazy { MutableLiveData<List<Double>>() }
    val currencyRates: LiveData<List<Double>>
        get() = _currencyRates

    private val currencyHolder = CurrencyHolder() //todo: rework this


    init {
        DaggerAppComponent.create().inject(this)
    }

    fun initialFetchOfEuroRate(): Disposable { //todo: here should go in the currency code
        return revolutService.getEndpointResponse(EURO)
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    _isInProgress.postValue(true)
                    if (it != null) {
                        val list = currencyHolder.retrieveCurrencies(it, EURO)
                        _currencies.postValue(list)
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

    fun fetchUserEnteredCurrency(currencyCode: String): Disposable {
        return revolutService.getEndpointResponse(currencyCode)
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    if (it != null) {
                        val list = currencyHolder.retrieveCurrencies(it, currencyCode)
                        _currencies.postValue(list)
                    }
                },
                {
                    _isInProgress.postValue(true)
                    Log.e("subscribeToObserver()", "network error: ${it.message}")
                    _isError.postValue(true)
                    _isInProgress.postValue(false)
                }
            )
    }

    /* fun assignRates(endpointResponse: EndpointResponse, currency: String) {

        _currencies.observe(, Observer { currencies ->
        }

    }*/
}