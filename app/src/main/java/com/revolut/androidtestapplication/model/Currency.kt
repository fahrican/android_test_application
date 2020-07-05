package com.revolut.androidtestapplication.model

data class Currency(
    val flag: String,
    val shortName: String,
    val fullName: String,
    val rate: Double,
    val rateToString: String = rate.toString()
)