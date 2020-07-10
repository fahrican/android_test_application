package com.revolut.androidtestapplication.helper

import com.revolut.androidtestapplication.model.Currency
import com.revolut.androidtestapplication.model.EndpointResponse
import kotlin.collections.ArrayList


class CurrencyHolder {

    fun retrieveCurrencies(endpointResponse: EndpointResponse, position: Int): ArrayList<Currency> {
        val currencies = ArrayList<Currency>(32)
        currencies.add(
            0, Currency(
                "https://restcountries.eu/data/aus.svg",
                "AUD",
                "Australian dollar",
                endpointResponse.rates.AUD ?: 1.00
            )
        )
        currencies.add(
            1, Currency(
                "https://restcountries.eu/data/bgr.svg",
                "BGN",
                "Bulgarian lev",
                endpointResponse.rates.BGN ?: 1.00
            )
        )
        currencies.add(
            2, Currency(
                "https://restcountries.eu/data/bra.svg",
                "BRL",
                "Brazilian real",
                endpointResponse.rates.BRL ?: 1.00
            )
        )
        currencies.add(
            3, Currency(
                "https://restcountries.eu/data/can.svg",
                "CAD",
                "Canadian dollar",
                endpointResponse.rates.CAD ?: 1.00
            )
        )
        currencies.add(
            4, Currency(
                "https://restcountries.eu/data/che.svg",
                "CHF",
                "Swiss franc",
                endpointResponse.rates.CHF ?: 1.00
            )
        )
        currencies.add(
            5, Currency(
                "https://restcountries.eu/data/chn.svg",
                "CNY",
                "Chinese yuan",
                endpointResponse.rates.CNY ?: 1.00
            )
        )
        currencies.add(
            6, Currency(
                "https://restcountries.eu/data/cze.svg",
                "CZK",
                "Czech koruna",
                endpointResponse.rates.CZK ?: 1.00
            )
        )
        currencies.add(
            7, Currency(
                "https://restcountries.eu/data/dnk.svg",
                "DKK",
                "Danish krone",
                endpointResponse.rates.DKK ?: 1.00
            )
        )
        currencies.add(
            8, Currency(
                "https://upload.wikimedia.org/wikipedia/commons/b/b7/Flag_of_Europe.svg",
                "EUR",
                "Euro",
                endpointResponse.rates.EUR ?: 1.00
            )
        )
        currencies.add(
            9, Currency(
                "https://restcountries.eu/data/gbr.svg",
                "GBP",
                "British pound",
                endpointResponse.rates.GBP ?: 1.00
            )
        )
        currencies.add(
            10, Currency(
                "https://restcountries.eu/data/hkg.svg",
                "HKD",
                "Hong Kong dollar",
                endpointResponse.rates.HKD ?: 1.00
            )
        )
        currencies.add(
            11, Currency(
                "https://restcountries.eu/data/hrv.svg",
                "HRK",
                "Croatian kuna",
                endpointResponse.rates.HRK ?: 1.00
            )
        )
        currencies.add(
            12, Currency(
                "https://restcountries.eu/data/hun.svg",
                "HUF",
                "Hungarian forint",
                endpointResponse.rates.HUF ?: 1.00
            )
        )
        currencies.add(
            13, Currency(
                "https://restcountries.eu/data/idn.svg",
                "IDR",
                "Indonesian rupiah",
                endpointResponse.rates.IDR ?: 1.00
            )
        )
        currencies.add(
            14, Currency(
                "https://restcountries.eu/data/isr.svg",
                "ILS",
                "Israeli new shekel",
                endpointResponse.rates.ILS ?: 1.00
            )
        )
        currencies.add(
            15, Currency(
                "https://restcountries.eu/data/ind.svg",
                "INR",
                "Indian rupee",
                endpointResponse.rates.INR ?: 1.00
            )
        )
        currencies.add(
            16, Currency(
                "https://restcountries.eu/data/isl.svg",
                "ISK",
                "Icelandic króna",
                endpointResponse.rates.ISK ?: 1.00
            )
        )
        currencies.add(
            17, Currency(
                "https://restcountries.eu/data/jpn.svg",
                "JPY",
                "Japanese yen",
                endpointResponse.rates.JPY ?: 1.00
            )
        )
        currencies.add(
            18, Currency(
                "https://restcountries.eu/data/kor.svg",
                "KRW",
                "South Korean won",
                endpointResponse.rates.KRW ?: 1.00
            )
        )
        currencies.add(
            19, Currency(
                "https://restcountries.eu/data/mex.svg",
                "MXN",
                "Mexican peso",
                endpointResponse.rates.MXN ?: 1.00
            )
        )
        currencies.add(
            20, Currency(
                "https://restcountries.eu/data/mys.svg",
                "MYR",
                "Malaysian ringgit",
                endpointResponse.rates.MYR ?: 1.00
            )
        )
        currencies.add(
            21, Currency(
                "https://restcountries.eu/data/nor.svg",
                "NOK",
                "Norwegian krone",
                endpointResponse.rates.NOK ?: 1.00
            )
        )
        currencies.add(
            22, Currency(
                "https://restcountries.eu/data/nzl.svg",
                "NZD",
                "New Zealand dollar",
                endpointResponse.rates.NZD ?: 1.00
            )
        )
        currencies.add(
            23, Currency(
                "https://restcountries.eu/data/phl.svg",
                "PHP",
                "Philippine peso",
                endpointResponse.rates.PHP ?: 1.00
            )
        )
        currencies.add(
            24, Currency(
                "https://restcountries.eu/data/pol.svg",
                "PLN",
                "Polish złoty",
                endpointResponse.rates.PLN ?: 1.00
            )
        )
        currencies.add(
            25, Currency(
                "https://restcountries.eu/data/rou.svg",
                "RON",
                "Romanian leu",
                endpointResponse.rates.RON ?: 1.00
            )
        )
        currencies.add(
            26, Currency(
                "https://restcountries.eu/data/rus.svg",
                "RUB",
                "Russian ruble",
                endpointResponse.rates.RUB ?: 1.00
            )
        )
        currencies.add(
            27, Currency(
                "https://restcountries.eu/data/swe.svg",
                "SEK",
                "Swedish krona",
                endpointResponse.rates.SEK ?: 1.00
            )
        )
        currencies.add(
            28, Currency(
                "https://restcountries.eu/data/sgp.svg",
                "SGD",
                "Singapore dollar",
                endpointResponse.rates.SGD ?: 1.00
            )
        )
        currencies.add(
            29, Currency(
                "https://restcountries.eu/data/tha.svg",
                "THB",
                "Thai baht",
                endpointResponse.rates.THB ?: 1.00
            )
        )
        currencies.add(
            30, Currency(
                "https://restcountries.eu/data/usa.svg",
                "USD",
                "United States dollar",
                endpointResponse.rates.USD ?: 1.00
            )
        )
        currencies.add(
            31, Currency(
                "https://restcountries.eu/data/zaf.svg",
                "ZAR",
                "South African rand",
                endpointResponse.rates.ZAR ?: 1.00
            )
        )

        val currency = currencies[position]
        currencies.removeAt(position)
        currencies.add(0, currency)
        return currencies
    }

}