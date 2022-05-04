package com.sample.mvvmarchiteturetest.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.mvvmarchiteturetest.R
import com.sample.mvvmarchiteturetest.data.model.product.ProductDetails
import com.sample.mvvmarchiteturetest.databinding.MainActivityBinding
import com.sample.mvvmarchiteturetest.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : MainActivityBinding
    private val  viewModel : MainViewModel by viewModels()
    private lateinit var adapter:ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        setContentView(binding.root)

        getProdcutList()
    }

    private fun   getProdcutList() {
        viewModel.fetchProductList()
        viewModel.productList.observe(this,productObserver)
    }
    private val productObserver= Observer<NetworkResult<List<ProductDetails>>> {
        when(it){
            is NetworkResult.Success ->{
                binding.progressBar.visibility= View.GONE
                // bind RecyclerView
                val recyclerView: RecyclerView =binding.recyclerViewProduct
                recyclerView.layoutManager=LinearLayoutManager(this)
                adapter= ProductAdapter(it.data)
                recyclerView.adapter = adapter
//                adapter.updateList(it.data)
            }
            is NetworkResult.Error ->{
                binding.progressBar.visibility= View.GONE
                Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
            }
            is NetworkResult.Loading ->{
                binding.progressBar.visibility= View.VISIBLE
            }
        }
    }

}