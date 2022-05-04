package com.sample.mvvmarchiteturetest.data.api


import com.sample.mvvmarchiteturetest.data.model.product.ProductDetails
import retrofit2.Response
import retrofit2.http.*

interface ApiService {


    @GET("products")
    suspend fun getProductList() :Response<List<ProductDetails>>



}