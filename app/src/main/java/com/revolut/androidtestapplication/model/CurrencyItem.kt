package com.revolut.androidtestapplication.model

import com.revolut.androidtestapplication.internal.userEnteredAmount

data class CurrencyItem(
    var flag: String,
    var shortName: String,
    var fullName: String,
    var rate: Double
) {
    fun multiplyAmountWithRates(): String {
        return (rate * userEnteredAmount).toString()
    }

}