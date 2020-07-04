package com.revolut.androidtestapplication.helper

import com.revolut.androidtestapplication.model.Currency
import com.revolut.androidtestapplication.model.EndpointResponse


class CurrencyHolder {

    val listOfCurrencies = ArrayList<Currency>()

    fun getListOfCurrencies(endpointResponse: EndpointResponse) {
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/aus.svg",
                "AUD",
                "Australian dollar",
                endpointResponse.rates.AUD
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/bgr.svg",
                "BGN",
                "Bulgarian lev",
                endpointResponse.rates.BGN
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/bra.svg",
                "BRL",
                "Brazilian real",
                endpointResponse.rates.BRL
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/can.svg",
                "CAD",
                "Canadian dollar",
                endpointResponse.rates.CAD
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/che.svg",
                "CHF",
                "Swiss franc",
                endpointResponse.rates.CHF
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/chn.svg",
                "CNY",
                "Chinese yuan",
                endpointResponse.rates.CNY
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/cze.svg",
                "CZK",
                "Czech koruna",
                endpointResponse.rates.CZK
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/dnk.svg",
                "DKK",
                "Danish krone",
                endpointResponse.rates.DKK
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/gbr.svg",
                "GBP",
                "British pound",
                endpointResponse.rates.GBP
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/hkg.svg",
                "HKD",
                "Hong Kong dollar",
                endpointResponse.rates.HKD
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/hrv.svg",
                "HRK",
                "Croatian kuna",
                endpointResponse.rates.HRK
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/hun.svg",
                "HUF",
                "Hungarian forint",
                endpointResponse.rates.HUF
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/idn.svg",
                "IDR",
                "Indonesian rupiah",
                endpointResponse.rates.IDR
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/isr.svg",
                "ILS",
                "Israeli new shekel",
                endpointResponse.rates.ILS
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/ind.svg",
                "INR",
                "Indian rupee",
                endpointResponse.rates.INR
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/isl.svg",
                "ISK",
                "Icelandic króna",
                endpointResponse.rates.ISK
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/jpn.svg",
                "JPY",
                "Japanese yen",
                endpointResponse.rates.JPY
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/kor.svg",
                "KRW",
                "South Korean won",
                endpointResponse.rates.KRW
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/mex.svg",
                "MXN",
                "Mexican peso",
                endpointResponse.rates.MXN
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/mys.svg",
                "MYR",
                "Malaysian ringgit",
                endpointResponse.rates.MYR
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/nor.svg",
                "NOK",
                "Norwegian krone",
                endpointResponse.rates.NOK
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/nzl.svg",
                "NZD",
                "New Zealand dollar",
                endpointResponse.rates.NZD
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/phl.svg",
                "PHP",
                "Philippine peso",
                endpointResponse.rates.PHP
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/pol.svg",
                "PLN",
                "Polish złoty",
                endpointResponse.rates.PLN
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/rou.svg",
                "RON",
                "Romanian leu",
                endpointResponse.rates.RON
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/rus.svg",
                "RUB",
                "Russian ruble",
                endpointResponse.rates.RUB
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/swe.svg",
                "SEK",
                "Swedish krona",
                endpointResponse.rates.SEK
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/sgp.svg",
                "SGD",
                "Singapore dollar",
                endpointResponse.rates.SGD
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/tha.svg",
                "THB",
                "Thai baht",
                endpointResponse.rates.THB
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/usa.svg",
                "USD",
                "United States dollar",
                endpointResponse.rates.USD
            )
        )
        listOfCurrencies.add(
            Currency(
                "https://restcountries.eu/data/zaf.svg",
                "ZAR",
                "South African rand",
                endpointResponse.rates.ZAR
            )
        )
    }
}