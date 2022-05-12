package com.sample.mvvmarchiteturetest.ui.main


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.sample.mvvmarchiteturetest.R
import com.sample.mvvmarchiteturetest.data.model.product.ProductDetails
import com.sample.mvvmarchiteturetest.databinding.ProductRowBinding

class ProductAdapter ( var list:List<ProductDetails>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    //remove this code
    fun updateList(list:List<ProductDetails>){
        this.list=list
        notifyDataSetChanged()
    }

//    fun updateList(list:List<ProductDetails>){
//        this.list=list
//        notifyDataSetChanged()
    var data = list
//    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binder = DataBindingUtil.inflate<ProductRowBinding>(
            LayoutInflater.from(parent.context),
            R.layout.product_row,
            parent,
            false
        )

        return ViewHolder(binder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binder.apply {
            product = list[position]
            executePendingBindings()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class ViewHolder(var binder:ProductRowBinding) : RecyclerView.ViewHolder(binder.root)


}


