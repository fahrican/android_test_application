package com.revolut.androidtestapplication

import android.app.Application

class CurrencyApplication : Application() {

    companion object {
        var userEnteredAmount: Double = 1.0
    }

}