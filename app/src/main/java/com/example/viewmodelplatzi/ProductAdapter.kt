package com.example.viewmodelplatzi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter:ListAdapter<Product,ProductAdapter.ViewHolder>(DiffCallBack) {
    inner class ViewHolder(val view:View):RecyclerView.ViewHolder(view){
         var productTitle:TextView=view.findViewById(R.id.itemTitle)
        var productID:TextView=view.findViewById(R.id.itemtaskID)
        var productImage:ImageView=view.findViewById(R.id.itemView)

        fun onBind(product: Product){
            val image= product.category.image
            productTitle.text=product.category.name
            productID.text=product.ID
            Picasso.get().load(image).into(productImage)

        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val myview:View=LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return ViewHolder(myview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val binder = getItem(position)
        holder.onBind(binder)

    }
    companion object DiffCallBack : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.ID == newItem.ID
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}