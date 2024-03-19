package com.example.lab5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab5.databinding.ActivityProductDetailBinding

//class ProductDetailActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityProductDetailBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityProductDetailBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // Extract the Product object passed from the MainActivity
//        val product = intent.getParcelableExtra<Product>("EXTRA_PRODUCT")
//        product?.let {
//            binding.imageProduct.setImageResource(R.drawable.ic_product_image_placeholder) // Use actual image in a real app
//            binding.textProductDetailName.text = it.productName
//            binding.textProductDetailCost.text = getString(R.string.product_cost, it.productCost)
//        }
//
//        // Set the Home button's click listener to finish the activity
//        binding.buttonHome.setOnClickListener {
//            finish()
//        }
//    }
//}
