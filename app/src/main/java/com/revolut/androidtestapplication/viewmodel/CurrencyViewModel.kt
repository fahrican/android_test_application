package com.revolut.androidtestapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.revolut.androidtestapplication.di.DaggerAppComponent
import com.revolut.androidtestapplication.repository.CurrencyRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CurrencyViewModel : ViewModel() {


    @Inject
    lateinit var repository: CurrencyRepository

    val compositeDisposable by lazy { CompositeDisposable() }


    init {
        DaggerAppComponent.create().inject(this)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}