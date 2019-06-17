package com.samiroispov.cbrcurrency.data.network

import com.samiroispov.cbrcurrency.data.model.DailyResponse
import retrofit2.Response
import retrofit2.http.GET
import io.reactivex.Observable

/**
 * Created by samirosipov on 17/06/2019
 */
interface ApiService {

    @GET("daily_json.js")
    fun getCurrency(): Observable<Response<DailyResponse>>
}