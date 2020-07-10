package com.revolut.androidtestapplication.model

data class CurrencyItem(
    var flag: String,
    var shortName: String,
    var fullName: String,
    var rate: Double,
    var rateToString: String = rate.toString()
)