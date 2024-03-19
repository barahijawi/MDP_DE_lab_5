package com.example.lab5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5.databinding.ItemProductBinding

class ProductAdapter(private val productList: List<Product>, private val listener: (Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        with(holder.binding) {
            val product = productList[position]
//            textProductDetailName.text = product.productName
//            tvProductDescription.text = product.productDescription
//            tvProductCost.text = product.productCost.toString()
//            btnAdd.setOnClickListener { listener(product) }
        }
    }

    override fun getItemCount() = productList.size
}
