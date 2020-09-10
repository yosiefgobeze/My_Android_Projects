package com.yosiefgobeze.assignment_6_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.product_layout.*

class ProductDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        // To avoid application crash check intent has data or not
        if(intent.hasExtra("SelectedProduct")){
            var currentProduct =intent.getSerializableExtra("SelectedProduct") as Product

            tvProductDetailTitle.text = currentProduct.Title.toString()
            tvProductDetailColor.text = currentProduct.Color.toString()
            tvProductDetailID.text="Walamart #: "+ currentProduct.ItemId.toString()
            tvProductDetailDescription.text=currentProduct.Desc.toString()
            ivProductDetailImage.setImageResource(currentProduct.Image.toInt())
        }
    }
}