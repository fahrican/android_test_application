package com.revolut.androidtestapplication.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

data class CurrencyItem(
    var flag: String,
    var shortName: String,
    var fullName: String,
    var rate: Double
) : BaseObservable() {

    @Bindable
    var rateTimesAmount: String = rate.toString()
        set(amount) {
            val amountAsDouble = amount.toDouble()
            val number2digits:Double = String.format("%.2f", amountAsDouble).toDouble()
            field = number2digits.toString()
            notifyPropertyChanged(BR.rateTimesAmount)
        }
}