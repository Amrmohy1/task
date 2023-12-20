package com.example.taskapk

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(private val context: Context,private val productList: List<ProductItem>):
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    inner class ViewHolder(itemView :View):RecyclerView.ViewHolder(itemView){
        val productImageView: ImageView = itemView.findViewById(R.id.productImage)
        val titleTextView: TextView = itemView.findViewById(R.id.tvProductTitle)
        val priceTextView: TextView = itemView.findViewById(R.id.product_price)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_itesm, parent, false)
        return ViewHolder(view)    }
    override fun getItemCount(): Int {
        return productList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]

        holder.titleTextView.text = product.title
        holder.priceTextView.text = String.format("$%.2f", product.price)

        Glide.with(context)
            .load(product.image)
            .into(holder.productImageView)
    }
}