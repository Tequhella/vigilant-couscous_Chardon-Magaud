package com.example.myrecipes_chardon_magaud.API

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor

class ApiClient {
    companion object RetrofitClient {
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

        val instance = build()

        private fun build(): Retrofit {
            val converter = GsonConverterFactory.create()

            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)

            val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(converter)
                .client(okHttpClient)
                .build()

        }
    }
}