package com.example.taskapk

import retrofit2.Call
import retrofit2.http.GET

interface UserApis {
   @GET("products")
    fun getProducts () :Call<List<ProductItem>>
}