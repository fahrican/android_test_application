package com.revolut.androidtestapplication.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.revolut.androidtestapplication.CurrencyApplication
import java.lang.ref.WeakReference

data class CurrencyItem(
    var flag: String,
    var shortName: String,
    var fullName: String,
    var rate: Double
) : BaseObservable() {

    lateinit var listener: WeakReference<AmountListener>

    @Bindable
    var rateTimesAmount: String = ""
        get() =
            (CurrencyApplication.userEnteredAmount * rate).toString()
        set(amount) {
            val amountAsDouble = amount.toDouble()
            val number2digits: Double = String.format("%.2f", amountAsDouble).toDouble()
            CurrencyApplication.userEnteredAmount = number2digits
            field = number2digits.toString()
            notifyPropertyChanged(BR.rateTimesAmount)
            listener.get()?.triggerNotifyDataSetChanged()
        }

}

interface AmountListener {
    fun triggerNotifyDataSetChanged()
}