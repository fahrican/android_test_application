package com.revolut.androidtestapplication.model

data class Currency(
    val flag: String,
    val shortName: String,
    val fullName: String,
    var rate: Double
) {
    fun rateToString(): String {
        return rate.toString()
    }
}