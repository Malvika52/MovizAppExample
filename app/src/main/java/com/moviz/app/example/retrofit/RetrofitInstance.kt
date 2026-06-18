package com.moviz.app.example.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://imdb-top-100-movies.p.rapidapi.com/"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("x-rapidapi-key", "3c18adeab6mshb5392c9561962b4p1fb0a5jsncee3699a625b")
                .addHeader("x-rapidapi-host", "imdb-top-100-movies.p.rapidapi.com")
                .build()
            chain.proceed(request)
        }
        .build()


    val apiService : ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiService::class.java)
    }

}