package com.sample.mvvmarchiteturetest.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.mvvmarchiteturetest.data.model.product.ProductDetails
import com.sample.mvvmarchiteturetest.data.repository.ProductRepository
import com.sample.mvvmarchiteturetest.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor
    (
    private val repository: ProductRepository
) : ViewModel() {
    private val _productList: MutableLiveData<NetworkResult<List<ProductDetails>>> = MutableLiveData()
     val productList: LiveData<NetworkResult<List<ProductDetails>>> = _productList


    fun fetchProductList() = viewModelScope.launch {
        _productList.postValue(NetworkResult.Loading())
        val result= repository.getProductList()
        _productList.postValue(result)
    }

}