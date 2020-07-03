package com.revolut.androidtestapplication.data.network

import com.revolut.androidtestapplication.internal.BASE_CURRENCY
import com.revolut.androidtestapplication.internal.ENDPOINT
import com.revolut.androidtestapplication.model.EndpointResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RevolutCurrencyApi {

    @GET(ENDPOINT)
    fun getEndpointResponse(
        @Query(BASE_CURRENCY)
        baseCurrency: String
    ): Observable<EndpointResponse>
}