package com.example.taskapk

import retrofit2.Retrofit

object RetrofitClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .build()

}