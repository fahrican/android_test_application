package com.revolut.androidtestapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.revolut.androidtestapplication.di.DaggerAppComponent
import com.revolut.androidtestapplication.repository.CurrencyRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class CurrencyViewModel @Inject constructor(val repository: CurrencyRepository) : ViewModel() {

    val compositeDisposable by lazy { CompositeDisposable() }


    init {
        DaggerAppComponent.create().inject(this)
        compositeDisposable.add(repository.initialFetchOfEuroRate())
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}