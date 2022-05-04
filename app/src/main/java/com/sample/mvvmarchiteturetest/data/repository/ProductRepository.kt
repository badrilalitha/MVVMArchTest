package com.sample.mvvmarchiteturetest.data.repository

import com.sample.mvvmarchiteturetest.data.api.ApiService
import com.sample.mvvmarchiteturetest.data.api.BaseApiResponse
import com.sample.mvvmarchiteturetest.data.model.product.ProductDetails
import com.sample.mvvmarchiteturetest.util.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiService: ApiService):
    BaseApiResponse(){



    suspend fun getProductList(): NetworkResult<List<ProductDetails>> {
        // Move the execution of the coroutine to the I/O dispatcher
        return withContext(Dispatchers.IO) {
            // Blocking network request code
            safeApiCall { apiService.getProductList() }
        }
    }
}