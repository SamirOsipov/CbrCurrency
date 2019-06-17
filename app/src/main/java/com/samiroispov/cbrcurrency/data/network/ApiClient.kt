package com.samiroispov.cbrcurrency.data.network

import com.google.gson.GsonBuilder
import com.samiroispov.cbrcurrency.data.model.DailyResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import io.reactivex.Observable
import retrofit2.HttpException

/**
 * Created by samirosipov on 17/06/2019
 */
class ApiClient {

    private val service: ApiService

    private val BASE_URL = "https://www.cbr-xml-daily.ru/"

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val buildClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(logging)
            .build()

        val gson = GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(buildClient)
            .build()

        service = retrofit.create(ApiService::class.java)
    }


    fun getCurrencies(): Observable<DailyResponse>{
        return service.getCurrency()
            .flatMap { response ->
                when(response.isSuccessful){
                    false -> Observable.error(HttpException(response))
                    true -> Observable.just(response.body())
                }
            }
    }
}