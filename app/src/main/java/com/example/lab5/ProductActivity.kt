package com.example.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab5.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
    private var products = arrayListOf<Product>()
    private val cart = arrayListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeProductList()
        setupRecyclerView()
        binding.recyclerViewProducts.adapter = ProductAdapter(products) { product ->
            addToCart(product)
        }
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(this)
    }
    private fun initializeProductList() {
        products = ArrayList()
        products.add(Product("iPad", "iPad Pro 11-inch", 400.0))
        products.add(Product("MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.00))
        products.add(Product("Dell Inspiron", "13th Gen Intel® Core™ i7", 1499.00))
        products.add(Product("Logitech Keyboard", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", 199.00))
        products.add(Product("MacBook M3 Max", "14-core CPU\n30-core GPU", 3499.00))
    }

    private fun setupRecyclerView() {
        var productAdapter = ProductAdapter(products){}
        binding.recyclerViewProducts.adapter = productAdapter
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(this)
    }

    private fun addToCart(product: Product) {
        cart.add(product)
        Toast.makeText(this, "${product.productName} added to cart", Toast.LENGTH_SHORT).show()
    }
}