package br.com.lucasrodrigues.meupedido.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.lucasrodrigues.meupedido.R
import br.com.lucasrodrigues.meupedido.data.models.Product

class ProductAdapter(
    private var products: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val productNameTextView: TextView = itemView.findViewById(R.id.tv_item_product_name)
        val productDescriptionTextView: TextView = itemView.findViewById(R.id.tv_item_product_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_product,
                parent,
    false
            )
        )
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = products[position]
        holder.productNameTextView.text = item.name
        holder.productDescriptionTextView.text = item.description
    }

    fun updateData(newProducts: List<Product>) {
        products = newProducts
        notifyDataSetChanged()
    }
}