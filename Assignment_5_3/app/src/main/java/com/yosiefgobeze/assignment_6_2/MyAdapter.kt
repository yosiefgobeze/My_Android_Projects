package com.yosiefgobeze.assignment_6_2

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MyAdapter(var context: Context,var products:ArrayList<Product>): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var productTitle: TextView=itemView.findViewById<TextView>(R.id.tvProductTitle)
        var productPrice: TextView=itemView.findViewById<TextView>(R.id.tvProductPrice)
        var productColor: TextView=itemView.findViewById<TextView>(R.id.tvProductColor)
        var productImage: ImageView=itemView.findViewById<ImageView>(R.id.ivProductImage)
        var parentlayout: RelativeLayout =itemView.findViewById<RelativeLayout>(R.id.rlparentlayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val v =LayoutInflater.from(parent?.context).inflate(R.layout.product_layout,parent,false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        holder?.productTitle.text=products[position].Title
        holder?.productPrice.text="Price : $" + products[position].Price.toString()
        holder?.productColor.text="Color : " + products[position].Color
        holder?.productImage.setImageResource(products[position].Image.toInt())

        holder.parentlayout.setOnClickListener{
            val intent=Intent(context,ProductDetail::class.java)
            var product=Product(products[position].ItemId,products[position].Title,products[position].Price,
                products[position].Color,products[position].Image.toString(),
                products[position].Desc)
            intent.putExtra("SelectedProduct",product)
            context.startActivity(intent)
        }
    }

}