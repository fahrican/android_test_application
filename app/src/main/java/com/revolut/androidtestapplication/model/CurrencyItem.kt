package com.revolut.androidtestapplication.model

import com.revolut.androidtestapplication.CurrencyApplication
import java.lang.ref.WeakReference
import java.math.BigDecimal

data class CurrencyItem(
    var flag: String,
    var shortName: String,
    var fullName: String,
    var rate: Double
) {

    lateinit var listener: WeakReference<AmountListener>

    var rateTimesAmount: String = ""
        get() =
            //String.format("%.2f", (CurrencyApplication.userEnteredAmount * 2))
            (CurrencyApplication.userEnteredAmount * 2).toString()
        set(amount) {
            val amountAsDecimal = BigDecimal(amount)
            val number2digits = BigDecimal(String.format("%.2f", amountAsDecimal))
            CurrencyApplication.userEnteredAmount = number2digits.toInt()
            field = amountAsDecimal.toString()
            listener.get()?.triggerNotifyDataSetChanged()
            //notifyPropertyChanged(BR.rateTimesAmount)
        }

}

interface AmountListener {
    fun triggerNotifyDataSetChanged()
}