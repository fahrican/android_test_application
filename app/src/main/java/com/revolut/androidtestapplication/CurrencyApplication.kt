package com.revolut.androidtestapplication

import android.app.Application

class CurrencyApplication : Application() {

    companion object {
        var userEnteredAmount: Int = 10
    }

}