package com.revolut.androidtestapplication.model

data class Currency(
    var flag: String,
    var shortName: String,
    var fullName: String,
    var rate: Double,
    var rateToString: String = rate.toString()
)