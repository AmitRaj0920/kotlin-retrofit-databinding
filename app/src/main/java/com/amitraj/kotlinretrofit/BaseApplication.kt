package com.amitraj.kotlinretrofit

import android.app.Application
import com.google.gson.GsonBuilder
import com.amitraj.kotlinretrofit.network.IRetrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by amitacharya on 06-Dec-17.
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    @Volatile private var IRETROFIT: IRetrofit? = null

    @Synchronized
    fun getRetrofitAPI(): IRetrofit? {

        val gsonBuilder = GsonBuilder()

        val gson = gsonBuilder.create()

        val httpClientBuilder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClientBuilder.addInterceptor(loggingInterceptor)
        }

        IRETROFIT = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/movie/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .callFactory(httpClientBuilder.build())
                .build()
                .create(IRetrofit::class.java)

        return IRETROFIT
    }
}