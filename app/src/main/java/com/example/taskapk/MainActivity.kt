package com.example.taskapk

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private  var adapter: ProductAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView =findViewById(R.id.recyclerApi)
        recyclerView.layoutManager=LinearLayoutManager(this)

        val myApis =RetrofitClient.retrofit.create(UserApis::class.java)
        val callProduct =myApis.getProducts()
        recyclerView.adapter=adapter
        callProduct.enqueue(object :Callback<List<ProductItem>> {
            override fun onResponse(
                call: Call<List<ProductItem>>,
                response: Response<List<ProductItem>>
            ) {
                val product = response.body()
                adapter = product?.let { ProductAdapter(this@MainActivity, it) }
                Log.d("massage product", product.toString())
            }
            override fun onFailure(call: Call<List<ProductItem>>, t: Throwable) {
                Log.d("massage product failure",t.message.toString())
            }
        })
    }
}